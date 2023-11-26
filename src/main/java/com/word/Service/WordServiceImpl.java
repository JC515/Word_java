package com.word.Service;

import com.word.Mapper.WordMapper;
import com.word.Pojo.Word;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {
    private final WordMapper wordMapper;

    public WordServiceImpl(WordMapper wordMapper) {
        this.wordMapper = wordMapper;
    }

    @Override
    public List<Word> getWordToPage(Integer index, Integer size) {
        PageHelper.startPage(index, size);
        List<Word> wordList = wordMapper.list();
        Page<Word> words = (Page<Word>) wordList;
        return words.getResult();
    }

    public List<Word> getWord() {
        return wordMapper.list();
    }
}
