package com.example.testingdemo.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;

    public void addHello(Hello hello){
        helloRepository.save(hello);
    }

    public List<Hello> getAllHellos(){
        return helloRepository.findAll();
    }

    public Hello getById(long id){
        return helloRepository.findById(id).get();
    }
}
