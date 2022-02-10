package com.example.testingdemo.hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Hello {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    private LocalDate ld;

    public Hello() {
    }

    public Hello(long id, String description, LocalDate ld) {
        this.id = id;
        this.description = description;
        this.ld = ld;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getLd() {
        return ld;
    }

    public void setLd(LocalDate ld) {
        this.ld = ld;
    }
}
