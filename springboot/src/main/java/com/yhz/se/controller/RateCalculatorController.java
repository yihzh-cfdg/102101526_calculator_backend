package com.yhz.se.controller;

import com.yhz.se.Service.RateCalculatorService;
import com.yhz.se.bean.Deposit;
import com.yhz.se.bean.Loan;
import com.yhz.se.bean.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/rate")
public class RateCalculatorController {
    @Autowired
    RateCalculatorService rateCalculatorService;
    @ResponseBody
    @GetMapping("/getDeposit")
    public List<Deposit> sendAllDeposit()
    {
        List<Deposit> a = rateCalculatorService.getAllDeposit();
       return a;
    }
    @ResponseBody
    @GetMapping("/getLoan")
    public List<Loan> sendAllLoan()
    {
        return rateCalculatorService.getAllLoan();
    }
    @PostMapping("/updateLoan")
    public Result<String> setLoan(@RequestBody Loan loan)
    {
        int res = rateCalculatorService.updateLoan(loan);
        return Result.success("Success set "+ res);
    }
    @PostMapping("/updateDeposit")
    public Result<String> setDeposit(@RequestBody Deposit deposit)
    {
        int res = rateCalculatorService.updateDeposit(deposit);
        return Result.success("Success set "+ res);
    }
    @PostMapping("/delLoan")
    public Result<String> delLoan(@RequestBody Loan loan)
    {
        int res = rateCalculatorService.deleteLoan(loan);
        return Result.success("Success del "+ res);
    }
    @PostMapping("/delDeposit")
    public Result<String> delDeposit(@RequestBody Deposit deposit)
    {
        int res = rateCalculatorService.deleteDeposit(deposit);
        return Result.success("Success del "+ res);
    }
    @ResponseBody
    @PostMapping("/insertDeposit")
    public Result<String> insertDeposit(@RequestBody Deposit deposit)
    {
        int res = rateCalculatorService.insertDeposit(deposit);
        return Result.success("Success insert "+ res);
    }

    @ResponseBody
    @PostMapping("/insertLoan")
    public Result<String> insertDeposit(@RequestBody Loan loan)
    {
        int res = rateCalculatorService.insertLoan(loan);
        return Result.success("Success insert "+ res);
    }
}
