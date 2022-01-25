package com.example.helloworld;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dish {
    private Ingredient ingredient;

    public Ingredient getIngredient() {
        return ingredient;
    }

    @Autowired
    //@Qualifier("createIngredient")
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @PostConstruct
    public void showDish() {
        System.out.println(this.getIngredient().getName());
    }
}
