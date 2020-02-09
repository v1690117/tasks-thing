package com.example.connector;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@PropertySource("classpath:test.properties") // todo fix temp decision
@Service
public class RedmineManager {
    private final com.taskadapter.redmineapi.IssueManager manager;

    public RedmineManager(@Value("${redmine.uri}") final String uri, @Value("${redmine.key}") final String accessKey) { // todo and this
        com.taskadapter.redmineapi.RedmineManager rmgr = RedmineManagerFactory.createWithApiKey(uri, accessKey);
        manager = rmgr.getIssueManager();
    }

    public com.taskadapter.redmineapi.bean.Issue getIssueById(final String name) throws RedmineException {
        return manager.getIssueById(Integer.parseInt(name));
    }
}
