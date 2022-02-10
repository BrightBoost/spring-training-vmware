package com.example.testingdemo.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.hasSize;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Hello> list;

    @BeforeEach
    public void setup() {
        list = new ArrayList<>();
        Hello hello = new Hello(1, "Hi1!", LocalDate.now());
        Hello hello1 = new Hello(2, "Hi2!", LocalDate.now());
        Hello hello2 = new Hello(3, "Hi3!", LocalDate.now());

        list.add(hello);
        list.add(hello1);
        list.add(hello2);
    }
    // get one specific hello
    @Test
    public void whenGetWithValidId_thenReturnHello() throws Exception {
        when(helloService.getById(1)).thenReturn(list.get(0));

        mockMvc.perform(get("/hello/get/{id}", 1))
                .andExpect(jsonPath("$.description").value("Hi1!"));

    }

    // get all helloes
    @Test
    public void whenGetAll_thenReturnHellos() throws Exception {

        when(helloService.getAllHellos()).thenReturn(list);

        mockMvc.perform(get("/hello/get"))
                .andExpect(jsonPath("$", hasSize(3)));

    }

    // post hello
    @Test
    public void whenPostWithValidHello_thenReturnOk() throws Exception {
        mockMvc.perform(post("/hello/post")
                .content(objectMapper.writeValueAsString(list.get(0)))
                .contentType("application/json"))
                .andExpect(status().isOk());
    }
}
