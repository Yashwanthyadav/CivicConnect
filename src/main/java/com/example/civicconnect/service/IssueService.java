// IssueService.java
package com.example.civicconnect.service;

import com.example.civicconnect.model.Issue;
import java.util.List;

public interface IssueService {
    Issue reportIssue(Issue issue);
    List<Issue> getAllIssues();
}
