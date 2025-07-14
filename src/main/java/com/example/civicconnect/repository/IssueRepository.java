package com.example.civicconnect.repository;

import com.example.civicconnect.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    // optional: add methods like findByStatus if needed
}
