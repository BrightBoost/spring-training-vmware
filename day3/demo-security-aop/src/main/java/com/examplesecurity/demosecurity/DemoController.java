package com.examplesecurity.demosecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    public DemoService demoService;

    @GetMapping("/user")
    public String doSomeStuff() {
        String currentUserName = "empty";
        //get name out of security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        return "Good morning " + currentUserName;
    }

    @GetMapping("/open")
    public String doSomeOpenStuff() {

        demoService.doServiceStuff();
        return "Good morning everyone!";
    }

    @GetMapping("/admin")
    public String doSomeAdminStuff() {
        return "Good morning everyone!";
    }
}
