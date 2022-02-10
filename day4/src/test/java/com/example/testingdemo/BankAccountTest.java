package com.example.testingdemo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    public void setup() {
        bankAccount = new BankAccount("Jonas", 100, 0);
    }

    @Test
    public void depositTest() {
        bankAccount.deposit(100);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    public void withdrawMoreThanMinimumTest() {
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(101));
    }

    @AfterEach
    public void teardown() {
        System.out.println("clean up resources");
    }
}
