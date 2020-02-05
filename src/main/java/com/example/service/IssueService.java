package com.example.service;

import com.example.domain.*;
import com.taskadapter.redmineapi.*;
import org.gitlab4j.api.*;

public interface IssueService {
    Issue getByName(String name) throws RedmineException, GitLabApiException;
}
