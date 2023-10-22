package com.yhz.se.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deposit {
    private Integer dno;
    private Double rate;
    private String month;
    private Double realtime;
}
