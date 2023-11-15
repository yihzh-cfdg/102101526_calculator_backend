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
@Schema(name = "History", description = "历史记录")
public class History {
    @Schema(name = "hno", description = "历史记录编号")
    public Integer hno;
    @Schema(name = "exps", description = "历史记录表达式")
    public String exps;
}
