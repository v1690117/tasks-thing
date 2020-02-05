package com.example.dao;

import com.example.domain.*;
import com.taskadapter.redmineapi.*;
import org.gitlab4j.api.*;

public interface IssueDao {
    Issue findByName(String name) throws RedmineException, GitLabApiException;
}
