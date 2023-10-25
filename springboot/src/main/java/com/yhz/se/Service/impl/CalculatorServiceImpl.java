package com.yhz.se.Service.impl;

import com.yhz.se.bean.History;
import com.yhz.se.bean.ResultData;
import com.yhz.se.mapper.HistoryMapper;
import com.yhz.se.Service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.openjdk.nashorn.internal.objects.Global.Infinity;


@Service("calculatorService")
public class CalculatorServiceImpl implements CalculatorService {
    @Autowired
    private HistoryMapper historyMapper;

    @Deprecated
    @Override
    public Double funcHandler(ResultData resultData) {

        String op = resultData.getOp();
        Double val = resultData.getVal(), exp = 0.0;
        BigDecimal ans = new BigDecimal(0);
        ans = ans.setScale(10, RoundingMode.HALF_UP);
        if ("pi".equals(op)) {
            exp = Math.PI;
        } else if ("e".equals(op)) {
            exp = Math.E;
        } else if ("x2".equals(op)) {
            exp = val * val;
        } else if ("sin".equals(op)) {
            exp = Math.sin(Math.toDegrees(val));
        } else if ("1/x".equals(op)) {
            exp = 1 / val;
        } else if ("abs".equals(op)) {
            if (val > 0) {
                exp = val;
            } else {
                exp = -val;
            }
        } else if ("exp".equals(op)) {
            exp = Math.exp(val);
        } else if ("sqrt".equals(op)) {
            exp = Math.sqrt(val);
        } else if ("cos".equals(op)) {
            exp = Math.cos(Math.toDegrees(val));
        } else if ("fact".equals(op)) {
            if (val <= 20) {
                exp = fact[(int) Math.round(val)];
            } else {
                exp = Infinity;
            }
        } else if ("10x".equals(op)) {
            exp = Math.pow(10.0, val);
        } else if ("tan".equals(op)) {
            exp = Math.tan(Math.toDegrees(val));
        } else if ("asin".equals(op)) {
            exp = Math.asin(Math.toDegrees(val));
        } else if ("log".equals(op)) {
            exp = Math.log10(val);
        } else if ("acos".equals(op)) {
            exp = Math.acos(Math.toDegrees(val));
        } else if ("ln".equals(op)) {
            exp = Math.log(val);
        } else if ("atan".equals(op)) {
            exp = Math.atan(Math.toDegrees(val));
        }
        ans = BigDecimal.valueOf(exp);
        return Double.valueOf(ans.toString());
    }

    @Override
    public List<History> getHistory() {
        return historyMapper.selectTop10();
    }

    @Override
    public int setHistory(History history) {
        return historyMapper.insert(history);
    }

    @Deprecated
    private final Double[] fact = {1.0, 1.0, 2.0, 6.0, 24.0, 120.0, 720.0, 5040.0, 40320.0, 362880.0, 3628800.0, 39916800.0,
            479001600.0, 6227020800.0, 87178291200.0, 1307674368000.0, 20922789888000.0, 355687428096000.0,
            6402373705728000.0, 121645100408832000.0, 2432902008176640000.0};
}
