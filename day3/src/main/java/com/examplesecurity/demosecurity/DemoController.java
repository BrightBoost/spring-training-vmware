package com.examplesecurity.demosecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/user")
    public String doSomeStuff() {
        return "Good morning VMWare!";
    }

    @GetMapping("/open")
    public String doSomeOpenStuff() {
        return "Good morning everyone!";
    }

    @GetMapping("/admin")
    public String doSomeAdminStuff() {
        return "Good morning everyone!";
    }
}
