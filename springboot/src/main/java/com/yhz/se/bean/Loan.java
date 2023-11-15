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
@Schema(name = "Loan", description = "贷款")
public class Loan {
    @Schema(name = "lno", description = "贷款编号")
    private Integer lno;
    @Schema(name = "rate", description = "利率")
    private Double rate;
    @Schema(name = "month", description = "贷款月份")
    private String month;
    @Schema(name = "realtime", description = "实际贷款时间")
    private Double realtime;
}
