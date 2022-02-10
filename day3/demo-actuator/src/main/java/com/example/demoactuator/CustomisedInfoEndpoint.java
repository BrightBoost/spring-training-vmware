package com.example.demoactuator;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)
public class CustomisedInfoEndpoint {
    @ReadOperation
    public Info getInfo(){
        return new Info();
    }

    class Info {
        public String day;
        public String month;

        public Info() {
            this.day = "Wednesday";
            this.month = "February";
        }

    }
}
