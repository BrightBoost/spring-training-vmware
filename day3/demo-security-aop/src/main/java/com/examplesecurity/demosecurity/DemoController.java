package com.examplesecurity.demosecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DemoController {
    public static List<String> list = new ArrayList<>(Arrays.asList("maria", "user", "admin"));
    public List<User> users = new ArrayList<>();

    @Autowired
    public DemoService demoService;

    @Secured("ROLE_USER")
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

    @Secured("ROLE_USER")
    //this will remove all non matches from the list
    @PostFilter("filterObject == authentication.name")
    @GetMapping("/getuser")
    public List<String> getSomeStuff() {
        System.out.println(list);
       return list;
    }

    @Secured("ROLE_USER")
    //this will remove all non matches from the list
    @PostFilter("filterObject.name == authentication.name")
    @GetMapping("/getuserobject")
    public List<User> getSomeStuffObjects() {
        User user = new User();
        user.setName("user");
        user.setStreetName("blabla1");

        User user1 = new User();
        user1.setName("admin");
        user1.setStreetName("blabla2");

        users.add(user);
        users.add(user1);

        return users;
    }

    @GetMapping("/open")
    public String doSomeOpenStuff() {

        demoService.doServiceStuff();
        return "Good morning everyone!";
    }

    //@Secured("ROLE_ADMIN")
    @PostAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String doSomeAdminStuff() {
        System.out.println("Just logging some stuff");
        return "Good morning admin!";
    }
}
