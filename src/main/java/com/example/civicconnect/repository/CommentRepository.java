package com.example.civicconnect.repository;

import com.example.civicconnect.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // you can add findByIssueId if needed
}
