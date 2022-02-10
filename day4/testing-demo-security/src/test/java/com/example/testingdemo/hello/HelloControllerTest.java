package com.example.testingdemo.hello;

import com.example.testingdemo.SecurityConfigTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private HelloService helloService;

    @WithMockUser
    @Test
    public void whenPostWithValidInput_thenReturns200() throws Exception {
       Hello hello = new Hello();
       hello.setDescription("Hello!");
       hello.setLd(LocalDate.now());

        mockMvc.perform(post("/hello/post")
                .content(objectMapper.writeValueAsString(hello))
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @WithMockUser
    @Test
    public void whenGetAll_thenReturnsHellos() throws Exception {

        Hello hello = new Hello();
        hello.setDescription("Hello!");
        hello.setLd(LocalDate.now());

        Hello hello2 = new Hello();
        hello2.setDescription("Hello2!");
        hello2.setLd(LocalDate.now());

        List<Hello> list = new ArrayList<>();
        list.add(hello);
        list.add(hello2);

        when(helloService.getAllHellos()).thenReturn(list);

        mockMvc.perform(get("/hello/get"))
                .andExpect(jsonPath("$", hasSize(2)));

    }

    @WithMockUser
    @Test
    public void whenGetWithValidInput_thenReturnsHello() throws Exception {

        Hello hello = new Hello();
        hello.setDescription("Hello!");
        hello.setLd(LocalDate.now());

        when(helloService.getById(1)).thenReturn(hello);

        mockMvc.perform(get("/hello/get/{id}", 1))
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.description").value("Hello!"))
                .andExpect(jsonPath("$.ld").value(hello.getLd().toString()));

    }
}
