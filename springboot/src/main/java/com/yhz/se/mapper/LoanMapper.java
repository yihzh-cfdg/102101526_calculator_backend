package com.yhz.se.mapper;

import com.yhz.se.bean.Loan;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LoanMapper {
    @Select("SELECT * FROM loan")
    List<Loan> selectAll();
    @Delete("DELETE FROM loan WHERE lno=#{lno}")
    int deleteById(int lno);
    @Insert("INSERT INTO loan VALUES(null, #{month},#{rate},#{realtime})")
    int insert(Loan loan);
    @Update("UPDATE loan SET month=#{month},rate=#{rate},realtime=#{realtime} WHERE lno=#{lno}")
    int updateById(Loan loan);

}
