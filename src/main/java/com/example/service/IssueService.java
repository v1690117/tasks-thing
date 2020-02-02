package com.example.service;

import com.example.domain.*;
import com.taskadapter.redmineapi.*;

public interface IssueService {
    Issue getByName(String name) throws RedmineException;
}
