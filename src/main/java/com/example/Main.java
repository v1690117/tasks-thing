package com.example;

import com.example.domain.Issue;
import com.example.service.IssueService;
import com.taskadapter.redmineapi.RedmineException;
import org.gitlab4j.api.GitLabApiException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class Main {
    public static void main(String[] args) throws RedmineException, GitLabApiException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        IssueService rmService = ctx.getBean("redmineIssueService", IssueService.class);
        IssueService glService = ctx.getBean("gitlabIssueService", IssueService.class);
        Issue rmIssue = rmService.getByName("4364");
        Issue glIssue = glService.getByName("1");
        System.out.println(rmIssue);
        System.out.println(glIssue);
    }
}
