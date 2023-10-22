package com.yhz.se.Service;

import com.yhz.se.bean.Deposit;
import com.yhz.se.bean.Loan;

import java.util.List;

public interface RateCalculatorService {
    List<Deposit> getAllDeposit();
    int insertDeposit(Deposit deposit);
    int updateDeposit(Deposit deposit);
    int deleteDeposit(Deposit deposit);

    List<Loan> getAllLoan();
    int insertLoan(Loan loan);
    int updateLoan(Loan loan);
    int deleteLoan(Loan loan);
}
