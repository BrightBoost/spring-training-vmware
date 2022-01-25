package com.example.helloworld;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("hello")
public class HelloController {

    public static List<Hello> list = new ArrayList<>();

    //not sticking to naming conventions of api mappings
    @GetMapping("get")
    public Hello getHello() {
        return new Hello("Good morning");
    }

    //path variable
    @GetMapping("get/{name}")
    public String sayHi(@PathVariable String name) {
        return "Hi " + name;
    }

    //query parameter
    @GetMapping("getquery")
    public String sayHiQuery(@RequestParam String name) {
        return "Hi " + name;
    }

    //sending in a json body
    @PostMapping("post")
    public void createHello(@RequestBody Hello hello) {
       list.add(hello);
    }

    //return list
    @GetMapping("all")
    public List<Hello> getList(){
        return list;
    }


}
