package com.demo1.Mapper;

import com.demo1.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from users where id=#{id} and password=#{password}")
    User getUserByIdAndPassword(int id, String password);
}
