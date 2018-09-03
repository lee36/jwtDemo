package com.lee.mapper;


import com.lee.model.User;
import com.lee.provider.UserUpdateProvider;
import org.apache.ibatis.annotations.*;

import javax.naming.Name;

public interface UserMapper {
    @Insert("insert into user(username,password) values(#{username},#{password})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    public int addUser(User user);
    @UpdateProvider(type = UserUpdateProvider.class,method = "update")
    public int update(User user);
}
