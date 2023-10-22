package com.yhz.se.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Deprecated
@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class ResultData {
    private String op;
    private Double val;
}
