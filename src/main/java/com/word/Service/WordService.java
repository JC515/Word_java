package com.word.Service;

import com.word.Pojo.Word;
import com.word.Pojo.WordHistory;

import java.util.List;

public interface WordService {
    List<Word> getWordToPage(Integer index, Integer size);

    List<Word> getWord();

    WordHistory getHistory(String userId);

    void updateHistory(WordHistory history);
}
