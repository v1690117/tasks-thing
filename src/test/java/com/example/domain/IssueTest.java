package com.example.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class IssueTest {

    @Test
    public void testToString() {
        Issue issue = new Issue();
        issue.setId("1");
        issue.setTitle("test");
        issue.setAssignee("me");

        assertEquals("Issue{id='1', title='test', assignee='me'}", issue.toString());
    }
}