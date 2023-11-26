package com.word.Service;

import com.word.Mapper.UserMapper;
import com.word.Pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    final
    UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(User user) {
        return userMapper.getUserByIdAndPassword(user.getId(), user.getPassword());
    }
}
