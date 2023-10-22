package com.yhz.se.test1.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HistoryMapperTest {
    @Autowired
    HistoryMapper historyMapper;
    @Test
    void selectTop10() {
        System.out.println(historyMapper.selectTop10());
    }
}