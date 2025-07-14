package com.example.civicconnect.controller;

import com.example.civicconnect.model.Comment;
import com.example.civicconnect.model.Issue;
import com.example.civicconnect.model.User;
import com.example.civicconnect.repository.CommentRepository;
import com.example.civicconnect.repository.IssueRepository;
import com.example.civicconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private UserRepository userRepository;

    // Add new comment
    @PostMapping
    public Comment addComment(@RequestParam Long issueId,
                              @RequestParam Long userId,
                              @RequestParam String content) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = Comment.builder()
                .content(content)
                .createdAt(LocalDateTime.now())
                .issue(issue)
                .user(user)
                .build();

        return commentRepository.save(comment);
    }

    // List comments by issue
    @GetMapping("/byIssue/{issueId}")
    public List<Comment> getCommentsByIssue(@PathVariable Long issueId) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue not found"));
        return commentRepository.findAll()
                .stream()
                .filter(c -> c.getIssue().getId().equals(issue.getId()))
                .toList();
    }
}
