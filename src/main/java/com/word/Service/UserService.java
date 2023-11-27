package com.word.Service;

import com.word.Pojo.User;


public interface UserService {
    User login(User user);

    User getUserById(String id);
}
