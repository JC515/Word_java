package com.word.Controller;

import com.word.Pojo.Response;
import com.word.Pojo.User;
import com.word.Service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {
    final
    UserServiceImpl userServiceImpl;

    public LoginController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/login")
    public Response<String> login(@RequestBody User user) {
        log.info("{}:{}", user.getId(), user.getPassword());
        if (userServiceImpl.login(user) != null) {
            log.info("{}成功登录", user.getId());
            return new Response<>(1, "ok", "success");
        } else {
            log.info("{}登录失败", user.getId());
            return new Response<>(0, "error", "fail");
        }
    }

    @GetMapping("/get")
    public Response<User> getUserById(@RequestParam("id") String id) {
        log.info("get user by id:{}", id);
        User user = userServiceImpl.getUserById(id);
        if (user != null) {
            log.info("get user by id:{} success", id);
            return new Response<>(1, "ok", user);
        } else {
            log.info("get user by id:{} fail", id);
            return new Response<>(0, "error", null);
        }
    }
}
