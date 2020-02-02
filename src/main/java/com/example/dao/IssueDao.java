package com.example.dao;

import com.example.domain.*;
import com.taskadapter.redmineapi.*;

public interface IssueDao {
    Issue findByName(String name) throws RedmineException;
}
