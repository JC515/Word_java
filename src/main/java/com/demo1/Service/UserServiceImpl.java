package com.demo1.Service;

import com.demo1.Mapper.UserMapper;
import com.demo1.Pojo.User;
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
