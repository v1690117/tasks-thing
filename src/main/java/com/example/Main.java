package com.example;

import com.example.domain.*;
import com.example.service.*;
import com.taskadapter.redmineapi.*;
import org.springframework.context.annotation.*;

@ComponentScan
@Configuration
public class Main {
    public static void main(String[] args) throws RedmineException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        IssueService service = ctx.getBean("issueService", IssueService.class);
        Issue issue = service.getByName("4364");
        System.out.println(issue);
    }
}
