package com.lee.provider;

import com.lee.model.User;
import org.apache.ibatis.jdbc.SQL;

public class UserUpdateProvider {
    public String update(User user){
      return new SQL(){
          {
              UPDATE("user");
              if(user.getUsername()!=null){
                  SET("username=#{username}");
              }
              if(user.getPassword()!=null){
                  SET("password=#{password}");
              }
              WHERE("id=#{id}");

          }
      }.toString();
    }
}
