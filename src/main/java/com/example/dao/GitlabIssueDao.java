package com.example.dao;

import com.example.connector.GitlabManager;
import com.example.domain.Issue;
import org.gitlab4j.api.GitLabApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@PropertySource("classpath:test.properties") // todo fix temp decision
@Repository("gitlabIssueDao")
public class GitlabIssueDao implements IssueDao {
    final private GitlabManager manager;
    final private String project;

    public GitlabIssueDao(final GitlabManager gl, @Value("${gitlab.project}") final String pr) { //todo instantiate for each project
        manager = gl;
        project = pr;
    }

    @Override
    public Issue findByName(final String name) throws GitLabApiException {
        org.gitlab4j.api.models.Issue glIssue = manager.getIssueById(project, name);
        Issue issue = new Issue();
        issue.setId(String.valueOf(glIssue.getId()));
        issue.setAssignee(glIssue.getAssignee().getName());
        issue.setTitle(glIssue.getTitle());
        return issue;
    }
}
