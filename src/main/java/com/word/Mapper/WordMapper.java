package com.word.Mapper;

import com.word.Pojo.Word;
import com.word.Pojo.WordHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface WordMapper {

    @Select("Select * from cet4")
    List<Word> list();

    @Select("SELECT * FROM user_learning_history WHERE user_id = #{userId}")
    WordHistory getHistory(String userId);

    @Select("UPDATE user_learning_history SET word_id = #{wordId}, learning_date = #{learningDate} WHERE user_id = #{userId}")
    void updateHistory(WordHistory history);

    @Update("UPDATE cet4 SET is_learned = #{isLearned} WHERE id = #{wordId}")
    boolean setWordLearned(int wordId, int isLearned);
}

