package com.example.helloworld.config;

import com.example.helloworld.Ingredient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("vegetarian")
public class AConfig {
    @Bean
    public Ingredient createIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("vegetarian chicken and rice");
        return ingredient;
    }
}
