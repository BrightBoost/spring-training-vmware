package com.example.testingdemo.hello;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(properties = "spring.jpa.hibernate.ddl-auto=validate")
public class HelloRepositoryTest {
    @Autowired
    private HelloRepository helloRepository;

    //without testpropertysource
//    @Test
//    void whenSaved_thenFindById() {
//        //create Hello object
//        Hello hello = new Hello(1, "hello", LocalDate.now());
//
//        //save it
//        helloRepository.save(hello);
//
//        //make sure that it exists
//        assertEquals("hello", helloRepository.findById(1L).get().getDescription());
//    }
//
    @Test
    void whenSaved_thenFindById() {
        assertEquals("hi", helloRepository.findById(1L).get().getDescription());
    }


}
