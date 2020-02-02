package com.example.connector;

import com.taskadapter.redmineapi.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

@PropertySource("classpath:test.properties") // todo fix temp decision
@Service
public class IssueManager {
    private final com.taskadapter.redmineapi.IssueManager manager;

    public IssueManager(@Value("${redmine.uri}") String uri, @Value("${redmine.key}") String accessKey) { // todo and this
        com.taskadapter.redmineapi.RedmineManager rmgr = RedmineManagerFactory.createWithApiKey(uri, accessKey);
        manager = rmgr.getIssueManager();
    }

    public com.taskadapter.redmineapi.bean.Issue getIssueById(String name) throws RedmineException {
        return manager.getIssueById(Integer.parseInt(name));
    }
}
