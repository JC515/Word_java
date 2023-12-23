package com.word.Controller;

import com.word.Pojo.Response;
import com.word.Pojo.User;
import com.word.Service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")//用户相关接口
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {
    final
    UserServiceImpl userServiceImpl;

    public LoginController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/login")//登录接口
    public Response<String> login(@RequestBody User user) {
        if (userServiceImpl.login(user) != null) {
            return new Response<>(1, "ok", "success");
        } else {
            return new Response<>(0, "error", "fail");
        }
    }

    @GetMapping("/get")//获取用户信息接口
    public Response<User> getUserById(@RequestParam("id") String id) {
        User user = userServiceImpl.getUserById(id);
        if (user != null) {
            return new Response<>(1, "ok", user);
        } else {
            return new Response<>(0, "error", null);
        }
    }
}
