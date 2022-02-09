package com.example.demoactuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class CustomEndpoint {
    @ReadOperation //when there's a get to our endpoint
    public String customStuff() {
        return "custom blablabla";
    }

    //@WriteOperation //post
    //@DeleteOperation //delete
}
