package com.yhz.se.controller;

import com.yhz.se.bean.History;
import com.yhz.se.Service.CalculatorService;
import com.yhz.se.bean.ResultData;
import com.yhz.se.bean.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "CalculatorController", description = "计算器")
@RestController
@CrossOrigin
@RequestMapping("/api/cal")
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @Operation(summary = "获取结果", description = "用于获取计算结果")
    @Deprecated
    @PostMapping("/getResult")
    public Double funcHandler(@Parameter(description = "传入数据") @RequestBody ResultData data){
        return calculatorService.funcHandler(data);
    }
    @Operation(summary = "设置历史记录", description = "用于设置历史记录")
    @Parameters({
            @Parameter(name = "history", description = "传入一条历史记录")
    })
    @PostMapping("/setHistory")
    public Result<String> setHistory(@RequestBody History history){
        int res = calculatorService.setHistory(history);
        return Result.success("Success Insert " + res);
    }
    @Operation(summary = "获取历史记录", description = "用于获取历史记录")
    @ResponseBody
    @GetMapping("/getHistory")
    public List<History> sendHistory(){
        return calculatorService.getHistory();
    }
}
