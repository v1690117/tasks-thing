package com.example.service;

import com.example.dao.*;
import com.example.domain.*;
import com.taskadapter.redmineapi.*;
import org.springframework.stereotype.*;

@Service("issueService")
public class IssueServiceImpl implements IssueService {
    private final IssueDao dao;

    public IssueServiceImpl(IssueDao dao) {
        this.dao = dao;
    }

    public Issue getByName(String name) throws RedmineException {
        return dao.findByName(name);
    }
}
