package com.yhz.se.controller;

import com.yhz.se.bean.History;
import com.yhz.se.Service.CalculatorService;
import com.yhz.se.bean.ResultData;
import com.yhz.se.bean.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cal")
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @Deprecated
    @PostMapping("/getResult")
    public Double funcHandler(@RequestBody ResultData data){
        return calculatorService.funcHandler(data);
    }

    @PostMapping("/setHistory")
    public Result<String> setHistory(@RequestBody History history){
        int res = calculatorService.setHistory(history);
        return Result.success("Success Insert " + res);
    }
    @ResponseBody
    @GetMapping("/getHistory")
    public List<History> sendHistory(){
        return calculatorService.getHistory();
    }
}
