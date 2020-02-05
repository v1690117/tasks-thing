package com.example.connector;

import org.gitlab4j.api.*;
import org.gitlab4j.api.models.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@PropertySource("classpath:test.properties") // todo fix temp decision
@Service
public class GitlabManager {
    GitLabApi manager;

    public GitlabManager(@Value("${gitlab.uri}") String uri, @Value("${gitlab.key}") String accessKey) { // todo and this
        manager = new GitLabApi(uri, accessKey);
    }

    public Issue getIssueById(String project, String name) throws GitLabApiException {
        return manager.getIssuesApi().getIssue(project, Integer.parseInt(name));
    }
}
