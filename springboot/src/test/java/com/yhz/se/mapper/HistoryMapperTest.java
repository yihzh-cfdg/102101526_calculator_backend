package com.yhz.se.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HistoryMapperTest {
    @Autowired
    private HistoryMapper historyMapper;
    @Test
    void selectTop10() {
        System.out.println(historyMapper.selectTop10());
    }
}