package com.example.helloworld;

import org.springframework.stereotype.Component;

@Component
public class Ingredient {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
