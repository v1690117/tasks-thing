package com.example.dao;

import com.example.connector.RedmineManager;
import com.example.domain.Issue;
import com.taskadapter.redmineapi.RedmineException;
import org.springframework.stereotype.Repository;

@Repository("redmineIssueDao")
public class RedmineIssueDao implements IssueDao {
    private RedmineManager manager;

    public RedmineIssueDao(RedmineManager rm) {
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
