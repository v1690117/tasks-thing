package com.example.connector;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Issue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@PropertySource("classpath:test.properties") // todo fix temp decision
@Service
public class GitlabManager {
    final private GitLabApi manager;

    public GitlabManager(@Value("${gitlab.uri}") final String uri, @Value("${gitlab.key}") final String accessKey) { // todo and this
        manager = new GitLabApi(uri, accessKey);
    }

    public Issue getIssueById(final String project, final String name) throws GitLabApiException {
        return manager.getIssuesApi().getIssue(project, Integer.parseInt(name));
    }
}
