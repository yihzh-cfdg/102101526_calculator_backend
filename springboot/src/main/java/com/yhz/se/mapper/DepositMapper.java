package com.yhz.se.mapper;

import com.yhz.se.bean.Deposit;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepositMapper {
    @Select("SELECT * FROM deposit")
    List<Deposit> selectAll();
    @Delete("DELETE FROM deposit WHERE dno=#{dno}")
    int deleteById(int dno);
    @Insert("INSERT INTO deposit VALUES(null, #{month},#{rate},#{realtime})")
    int insert(Deposit deposit);
    @Update("UPDATE deposit SET month=#{month},rate=#{rate},realtime=#{realtime} WHERE dno=#{dno}")
    int updateById(Deposit deposit);
}
