package com.word.Controller;

import com.word.Pojo.Response;
import com.word.Pojo.Word;
import com.word.Pojo.WordHistory;
import com.word.Service.WordServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/word")//单词相关接口
public class WordController {
    private final WordServiceImpl wordServiceImpl;

    public WordController(WordServiceImpl wordServiceImpl) {
        this.wordServiceImpl = wordServiceImpl;
    }

    @GetMapping//获取所有单词
    public Response<List<Word>> getAllWord() {
        List<Word> wordList = wordServiceImpl.getWord();
        return new Response<>(1, "OK", wordList);
    }

    @GetMapping("/history")//获取用户历史记录
    public Response<WordHistory> getHistory(@RequestParam("id") String userId) {
        WordHistory history = wordServiceImpl.getHistory(userId);
        if (history == null) {
            return new Response<>(0, "无历史记录", null);
        } else {
            return new Response<>(1, "OK", history);
        }
    }

    @PostMapping("/history")//更新用户历史记录
    public Response<String> updateHistory(@RequestBody WordHistory history) {
        wordServiceImpl.updateHistory(history);
        return new Response<>(1, "OK", "历史记录更新完成");
    }

    @GetMapping("/updateIsLearned")//更新单词已学习的标志
    public Response<Boolean> setWordLearned(@RequestParam int wordId, @RequestParam int isLearned) {
        boolean learned = wordServiceImpl.setWordLearned(wordId, isLearned);
        return new Response<>(1, "OK", learned);
    }
}
