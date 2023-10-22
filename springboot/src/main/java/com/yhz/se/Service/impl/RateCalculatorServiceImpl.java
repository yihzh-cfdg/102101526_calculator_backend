package com.yhz.se.Service.impl;

import com.yhz.se.bean.Deposit;
import com.yhz.se.bean.Loan;
import com.yhz.se.mapper.DepositMapper;
import com.yhz.se.mapper.LoanMapper;
import com.yhz.se.Service.RateCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateCalculatorServiceImpl implements RateCalculatorService {
    @Autowired
    private DepositMapper depositMapper;
    @Autowired
    private LoanMapper loanMapper;
    @Override
    public List<Deposit> getAllDeposit() {
        return depositMapper.selectAll();
    }
    @Override
    public List<Loan> getAllLoan() {
        return loanMapper.selectAll();
    }
    @Override
    public int insertDeposit(Deposit deposit) {
        return depositMapper.insert(deposit);
    }
    @Override
    public int updateDeposit(Deposit deposit) {
        return depositMapper.updateById(deposit);
    }
    @Override
    public int deleteDeposit(Deposit deposit) {
        return depositMapper.deleteById(deposit.getDno());
    }
    @Override
    public int insertLoan(Loan loan) {
        return loanMapper.insert(loan);
    }
    @Override
    public int updateLoan(Loan loan) {
        return loanMapper.updateById(loan);
    }
    @Override
    public int deleteLoan(Loan loan) {
        return loanMapper.deleteById(loan.getLno());
    }
}
