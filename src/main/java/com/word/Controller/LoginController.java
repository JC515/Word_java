package com.word.Controller;

import com.word.Pojo.Response;
import com.word.Pojo.User;
import com.word.Service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {
    final
    UserServiceImpl userServiceImpl;

    public LoginController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping
    public Response<String> login(@RequestBody User user) {
        if (userServiceImpl.login(user) != null) {
            log.info("{}成功登录", user.getId());
            return new Response<>(1, "ok", "success");
        } else {
            log.info("{}登录失败", user.getId());
            return new Response<>(0, "error", "fail");
        }
    }
}