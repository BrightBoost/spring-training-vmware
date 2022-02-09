package com.examplesecurity.demosecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class CustomConfig extends WebSecurityConfigurerAdapter {

    //authentication logic
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(encoder.encode("secret"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(encoder.encode("supersecret"))
                .roles("USER", "ADMIN");
    }

    //authorization logic
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/open")
//                .permitAll()
//                .antMatchers("/admin")
//                .hasRole("ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }
}
