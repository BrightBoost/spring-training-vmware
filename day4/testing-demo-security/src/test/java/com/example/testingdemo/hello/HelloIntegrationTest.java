package com.example.testingdemo.hello;

import com.example.testingdemo.SecurityConfigTest;
import com.example.testingdemo.TestingDemoApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ContextConfiguration(classes = { SecurityConfigTest.class, TestingDemoApplication.class})
@AutoConfigureMockMvc
public class HelloIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private HelloRepository helloRepository;


    @WithMockUser
    @Test
    void postHelloAllLayers() throws Exception {
        Hello hello = new Hello();
        hello.setDescription("integration hello");
        hello.setLd(LocalDate.now());

        mockMvc.perform(post("/hello/post")
                        .content(objectMapper.writeValueAsString(hello))
                        .contentType("application/json"))
                .andExpect(status().isOk());

        Hello hello1 = helloRepository.findById(1L).get();

        assertThat(hello1.getDescription().equals("integration hello"));
    }

}
