package com.yhz.se.test1.mapper;


import com.yhz.se.test1.bean.History;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HistoryMapper{
    @Select("SELECT * FROM history ORDER BY h_id DESC LIMIT 10;\n")
    List<History> selectTop10();

    @Delete("delete from history")
    void deleteAll();

    @Insert("insert into history values(null, #{exps}) ")
    void insert(History history);
}
