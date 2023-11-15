package com.yhz.se.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Deposit", description = "存款")
public class Deposit {
    @Schema(name = "dno", description = "存款编号")
    private Integer dno;
    @Schema(name = "rate", description = "利率")
    private Double rate;
    @Schema(name = "month", description = "存款月份")
    private String month;
    @Schema(name = "realtime", description = "实际存款时间")
    private Double realtime;
}
