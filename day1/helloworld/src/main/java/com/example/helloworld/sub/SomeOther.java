package com.example.helloworld.sub;

import com.example.helloworld.Another;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeOther {
    @Autowired
    public Another another;
}
