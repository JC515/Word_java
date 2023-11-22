package com.demo1.Service;

import com.demo1.Pojo.Word;

import java.util.List;

public interface WordService {
    List<Word> getWordToPage(Integer index, Integer size);
    public List<Word> getWord();
}
