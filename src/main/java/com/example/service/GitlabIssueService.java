package com.example.service;

import com.example.dao.IssueDao;
import com.example.domain.Issue;
import com.taskadapter.redmineapi.RedmineException;
import org.gitlab4j.api.GitLabApiException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("gitlabIssueService")
public class GitlabIssueService implements IssueService {
    private final IssueDao dao;

    public GitlabIssueService(@Qualifier("gitlabIssueDao") final IssueDao dao) {
        this.dao = dao;
    }

    @Override
    public Issue getByName(final String name) throws RedmineException, GitLabApiException {
        return dao.findByName(name);
    }
}
