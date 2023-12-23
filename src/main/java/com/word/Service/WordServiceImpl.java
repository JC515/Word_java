package com.word.Service;

import com.word.Mapper.WordMapper;
import com.word.Pojo.Word;
import com.word.Pojo.WordHistory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class WordServiceImpl implements WordService {
    private final WordMapper wordMapper;

    public WordServiceImpl(WordMapper wordMapper) {
        this.wordMapper = wordMapper;
    }

    @Override
    public List<Word> getWord() {
        return wordMapper.list();
    }

    @Override
    public WordHistory getHistory(String userId) {
        return wordMapper.getHistory(userId);
    }

    @Override
    public void updateHistory(WordHistory history) {
        // 更新学习时间为系统当前时间
        history.setLearningDate(new Timestamp(new Date().getTime()));
        wordMapper.updateHistory(history);
    }

    @Override
    public boolean setWordLearned(int wordId, int isLearned) {
        return wordMapper.setWordLearned(wordId, isLearned);
    }
}
