package com.yhz.se.Service;

import com.yhz.se.bean.History;
import com.yhz.se.bean.ResultData;

import java.util.List;

public interface CalculatorService {
    @Deprecated
    Double funcHandler(ResultData resultData);
    List<History> getHistory();
    int setHistory(History history);
}
