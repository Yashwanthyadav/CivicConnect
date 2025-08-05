package com.example.civicconnect.controller;

import com.example.civicconnect.model.Issue;
import com.example.civicconnect.model.User; // Import the User model
import com.example.civicconnect.repository.IssueRepository;
import com.example.civicconnect.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; // Import PostMapping
import org.springframework.web.bind.annotation.ModelAttribute; // Import ModelAttribute
// No @RequestMapping("/general") here, so paths like /register are at root

import java.util.List;

@Controller
public class WebController {
    //private final CommentRepository commentRepository;
    private final IssueRepository issueRepository;
    private final UserRepository userRepository;

    // Constructor Injection: Best practice for injecting dependencies
    public WebController(IssueRepository issueRepository, UserRepository userRepository) {
        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
    }

    // Handles the root URL, e.g., http://localhost:8080/
    @GetMapping("/")
    public String home() {
        return "index"; // Renders src/main/resources/templates/index.html
    }

    @GetMapping("/index")
    public String index()
    {
        return "index";
    }
    // Displays a list of issues
    @GetMapping("/issues-page")
    public String listIssues(Model model) {
        List<Issue> issues = issueRepository.findAll();
        model.addAttribute("issues", issues);
        return "issues"; // Renders src/main/resources/templates/issues.html
    }

    // Show the user registration page (GET request)
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        // Add an empty User object to the model so the form can bind to it
        model.addAttribute("user", new User());
        return "register"; // Renders src/main/resources/templates/register.html
    }

    // Handle user registration form submission (POST request)
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        // IMPORTANT: In a real application, you would hash the password here
        // or in a UserService before saving.
        // For example: user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        // After successful registration, redirect to the login page or home page
        return "redirect:/login"; // Redirects to the /login URL
    }

    // Show the login page
    @GetMapping("/login")
    public String login() {
        return "login"; // Renders src/main/resources/templates/login.html
    }

    // Show the form to add a new issue
    @GetMapping("/add-issue")
    public String addIssueForm() {
        return "add-issue"; // Renders src/main/resources/templates/add-issue.html
    }
}
