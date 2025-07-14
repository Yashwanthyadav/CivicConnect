package com.example.civicconnect.controller;

import com.example.civicconnect.model.Issue;
import com.example.civicconnect.repository.IssueRepository;
import com.example.civicconnect.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/general")
public class WebController {

    private final IssueRepository issueRepository;
    private final UserRepository userRepository;

    public WebController(IssueRepository issueRepository, UserRepository userRepository) {
        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home() {
        return "index";  // templates/index.html
    }

    @GetMapping("/issues-page")
    public String listIssues(Model model) {
        List<Issue> issues = issueRepository.findAll();
        model.addAttribute("issues", issues);
        return "issues";  // templates/issues.html
    }

    @GetMapping("/register")
    public String register() {
        return "register";  // templates/register.html
    }

    @GetMapping("/login")
    public String login() {
        return "login";  // templates/login.html
    }

    @GetMapping("/add-issue")
    public String addIssueForm() {
        return "add-issue";  // templates/add-issue.html
    }
}
