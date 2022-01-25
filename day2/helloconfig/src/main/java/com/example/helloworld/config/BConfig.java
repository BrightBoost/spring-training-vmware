package com.example.helloworld.config;

import com.example.helloworld.Ingredient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("non-vegetarian")
public class BConfig {
    @Bean
    public Ingredient createIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("non-vegetarian chicken and rice");
        return ingredient;
    }

//    @Bean
//    @Primary
//    public Ingredient createIngredient2() {
//        Ingredient ingredient = new Ingredient();
//        ingredient.setName("2 non-vegetarian chicken and rice");
//        return ingredient;
//    }
}
