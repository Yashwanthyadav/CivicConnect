package com.example.civicconnect.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.civicconnect.model.User;
import com.example.civicconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserWebController {

    @Autowired
    private UserRepository userRepository;

    // Show the register page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // loads register.html
    }

    // Handle form submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userRepository.save(user);
        // redirect to home or login
       return "redirect:/"; 
    }
}
