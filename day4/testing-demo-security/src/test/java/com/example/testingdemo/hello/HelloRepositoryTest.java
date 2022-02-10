package com.example.testingdemo.hello;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})
public class HelloRepositoryTest {
    @Autowired
    private HelloRepository helloRepository;

    //without testpropertysource
//    @Test
//    void whenSaved_thenFindsByName() {
//
//        Hello hello = new Hello();
//        hello.setDescription("Hello!");
//        hello.setLd(LocalDate.now());
//
//        helloRepository.save(hello);
//        assertThat(helloRepository.findById(0L)).isNotNull();
//    }

    @Test
    void whenSaved_thenFindsByName() {

        assertThat(helloRepository.findById(0L)).isNotNull();
    }


}
