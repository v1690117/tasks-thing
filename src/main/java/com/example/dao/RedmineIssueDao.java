package com.example.dao;

import com.example.connector.IssueManager;
import com.example.domain.*;
import com.taskadapter.redmineapi.*;
import org.springframework.stereotype.*;

@Repository("issueDao")
public class RedmineIssueDao implements IssueDao {
    private IssueManager manager;

    public RedmineIssueDao(IssueManager rm) {
        manager = rm;
    }

    public Issue findByName(String name) throws RedmineException {
        com.taskadapter.redmineapi.bean.Issue rmIssue = manager.getIssueById(name);
        Issue issue = new Issue();
        issue.setId(String.valueOf(rmIssue.getId()));
        issue.setAssignee(rmIssue.getAssigneeName());
        issue.setTitle(rmIssue.getSubject());
        return issue;
    }
}
