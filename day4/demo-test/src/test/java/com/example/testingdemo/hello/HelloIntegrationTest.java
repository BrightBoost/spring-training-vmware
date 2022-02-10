package com.example.testingdemo.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

@SpringBootTest (properties = "spring.jpa.hibernate.ddl-auto=create-drop")
@AutoConfigureMockMvc
public class HelloIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private HelloRepository helloRepository;

    private Hello hello;

    @BeforeEach
    public void setup() {
        hello = new Hello();
        hello.setDescription("hello integration test");
        hello.setLd(LocalDate.now());
    }

    @Test
    void postHelloTestRepository() throws Exception {
        mockMvc.perform(post("/hello/post")
                    .content(objectMapper.writeValueAsString(hello))
                    .contentType("application/json"))
                .andExpect(status().isOk());

        Hello h = helloRepository.findById(1L).get();
        assertEquals(hello.getDescription(), h.getDescription());
    }
}
