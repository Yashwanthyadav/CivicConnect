package com.example.civicconnect.controller;

import com.example.civicconnect.model.Issue;
import com.example.civicconnect.model.User;
import com.example.civicconnect.repository.IssueRepository;
import com.example.civicconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private UserRepository userRepository;

    // ✅ Create issue linked to a user
    @PostMapping
    public Issue createIssue(@RequestBody Issue issue, @RequestParam Long userId) {
        // Find user from DB by userId
        User user = userRepository.findById(userId)
                     .orElseThrow(() -> new RuntimeException("User not found"));

        // Link issue to user and set fields
        issue.setCreatedBy(user);
        issue.setStatus("pending");
        issue.setCreatedAt(LocalDateTime.now());
        issue.setUpdatedAt(LocalDateTime.now());

        // Save to DB
        return issueRepository.save(issue);
    }

    // ✅ List all issues
    @GetMapping
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }
}
