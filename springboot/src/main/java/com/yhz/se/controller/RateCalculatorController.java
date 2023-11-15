package com.yhz.se.controller;

import com.yhz.se.Service.RateCalculatorService;
import com.yhz.se.bean.Deposit;
import com.yhz.se.bean.Loan;
import com.yhz.se.bean.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "RateCalculatorController", description = "利率计算器")
@RestController
@CrossOrigin
@RequestMapping("/api/rate")
public class RateCalculatorController {
    @Autowired
    RateCalculatorService rateCalculatorService;
    @ResponseBody
    @GetMapping("/getDeposit")
    @Operation(summary = "获取存款利率", description = "用于获取存款利率")
    public List<Deposit> sendAllDeposit()
    {
        return rateCalculatorService.getAllDeposit();
    }
    @Operation(summary = "获取贷款利率", description = "用于获取贷款利率")
    @ResponseBody
    @GetMapping("/getLoan")
    public List<Loan> sendAllLoan()
    {
        return rateCalculatorService.getAllLoan();
    }

    @Operation(summary = "设置贷款利率")
    @Parameters({
            @Parameter(name = "loan", description = "传入一条贷款利率")
    })
    @PostMapping("/updateLoan")
    public Result<String> setLoan(@RequestBody Loan loan)
    {
        int res = rateCalculatorService.updateLoan(loan);
        return Result.success("Success set "+ res);
    }

    @Operation(summary = "设置存款利率")
    @Parameters({
            @Parameter(name = "deposit", description = "传入一条存款利率")
    })
    @PostMapping("/updateDeposit")
    public Result<String> setDeposit(@RequestBody Deposit deposit)
    {
        int res = rateCalculatorService.updateDeposit(deposit);
        return Result.success("Success set "+ res);
    }

    @Operation(summary = "删除存款利率")
    @Parameters({
            @Parameter(name = "deposit", description = "传入一条存款利率")
    })
    @PostMapping("/delLoan")
    public Result<String> delLoan(@RequestBody Loan loan)
    {
        int res = rateCalculatorService.deleteLoan(loan);
        return Result.success("Success del "+ res);
    }

    @Operation(summary = "删除贷款利率")
    @Parameters({
            @Parameter(name = "deposit", description = "传入一条贷款利率")
    })
    @PostMapping("/delDeposit")
    public Result<String> delDeposit(@RequestBody Deposit deposit)
    {
        int res = rateCalculatorService.deleteDeposit(deposit);
        return Result.success("Success del "+ res);
    }
    @Operation(summary = "插入存款利率")
    @Parameters({
            @Parameter(name = "deposit", description = "传入一条存款利率")
    })
    @ResponseBody
    @PostMapping("/insertDeposit")
    public Result<String> insertDeposit(@RequestBody Deposit deposit)
    {
        int res = rateCalculatorService.insertDeposit(deposit);
        return Result.success("Success insert "+ res);
    }

    @Operation(summary = "插入贷款利率")
    @Parameters({
            @Parameter(name = "loan", description = "传入一条贷款利率")
    })
    @ResponseBody
    @PostMapping("/insertLoan")
    public Result<String> insertDeposit(@RequestBody Loan loan)
    {
        int res = rateCalculatorService.insertLoan(loan);
        return Result.success("Success insert "+ res);
    }
}
