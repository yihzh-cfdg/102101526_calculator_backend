package com.yhz.se.mapper;


import com.yhz.se.bean.History;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HistoryMapper{
    @Select("SELECT * FROM history ORDER BY hno DESC LIMIT 10;\n")
    List<History> selectTop10();

    @Delete("delete from history")
    int deleteAll();

    @Insert("insert into history values(null, #{exps}) ")
    int insert(History history);
}
