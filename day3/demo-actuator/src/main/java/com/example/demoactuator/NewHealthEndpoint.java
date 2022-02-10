package com.example.demoactuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NewHealthEndpoint implements HealthIndicator {
    @Override
    public Health health() {
        Health.Builder health = Health.up();
        Random r = new Random();
        if(r.nextBoolean()) {
            health = Health.down();
        }

        return health.build();
    }
}
