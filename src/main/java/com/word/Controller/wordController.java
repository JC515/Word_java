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
@RequestMapping("/word")
public class wordController {
    private final WordServiceImpl wordServiceImpl;

    public wordController(WordServiceImpl wordServiceImpl) {
        this.wordServiceImpl = wordServiceImpl;
    }

    @GetMapping
    public Response<List<Word>> getAllWord() {
        log.info("查询所有单词");
        List<Word> wordList = wordServiceImpl.getWord();
        return new Response<>(1, "OK", wordList);
    }

    @GetMapping("/page")
    public Response<List<Word>> getPage(@RequestParam(defaultValue = "1") Integer index, @RequestParam(defaultValue = "10") Integer size) {
        log.info("分页查询单词， 第 {} 页, 每页 {} 条", index, size);
        List<Word> wordList = wordServiceImpl.getWordToPage(index, size);
        return new Response<>(1, "OK", wordList);
    }

    @GetMapping("/history")
    public Response<WordHistory> getHistory(@RequestParam("id") String userId) {
        log.info("查询用户 {} 的历史记录", userId);
        WordHistory history = wordServiceImpl.getHistory(userId);
        if (history == null) {
            return new Response<>(0, "无历史记录", null);
        } else {
            return new Response<>(1, "OK", history);
        }
    }

    @PostMapping("/history")
    public Response<String> updateHistory(@RequestBody WordHistory history) {
        log.info("更新用户 {} 的历史记录", history.getUserId());
        log.info(history.toString());
        wordServiceImpl.updateHistory(history);
        return new Response<>(1, "OK", "历史记录更新完成");
    }
}
