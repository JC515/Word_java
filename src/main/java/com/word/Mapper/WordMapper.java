package com.word.Mapper;

import com.word.Pojo.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WordMapper {
    @Select("select * from cet4 limit #{startIndex}, #{size}")
    List<Word> getWordToPage(Integer startIndex, Integer size);

    @Select("Select * from cet4")
    List<Word> list();
}