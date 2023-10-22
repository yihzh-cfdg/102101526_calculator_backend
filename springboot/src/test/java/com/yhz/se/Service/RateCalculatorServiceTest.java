package com.yhz.se.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RateCalculatorServiceTest {
    @Autowired
    RateCalculatorService rateCalculatorServiceImpl;
    @Test
    void getAllLoan() {
        System.out.println("OK");
    }
}