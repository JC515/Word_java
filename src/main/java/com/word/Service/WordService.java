package com.word.Service;

import com.word.Pojo.Word;
import com.word.Pojo.WordHistory;

import java.util.List;

public interface WordService {

    List<Word> getWord();

    WordHistory getHistory(String userId);

    void updateHistory(WordHistory history);

    boolean setWordLearned(int wordId, int isLearned);
}
