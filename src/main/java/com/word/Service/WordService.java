package com.word.Service;

import com.word.Pojo.Word;

import java.util.List;

public interface WordService {
    List<Word> getWordToPage(Integer index, Integer size);
    List<Word> getWord();
}
