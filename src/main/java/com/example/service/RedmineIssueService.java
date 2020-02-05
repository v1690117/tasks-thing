package com.example.service;

import com.example.dao.*;
import com.example.domain.*;
import com.taskadapter.redmineapi.*;
import org.gitlab4j.api.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;

@Service("redmineIssueService")
public class RedmineIssueService implements IssueService {
    private final IssueDao dao;

    public RedmineIssueService(@Qualifier("redmineIssueDao") IssueDao dao) {
        this.dao = dao;
    }

    public Issue getByName(String name) throws RedmineException, GitLabApiException {
        return dao.findByName(name);
    }
}
