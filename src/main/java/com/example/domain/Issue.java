package com.example.domain;

public class Issue {
    private String id;
    private String title;
    private String assignee;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", assignee='" + assignee + '\'' +
                '}';
    }
}
