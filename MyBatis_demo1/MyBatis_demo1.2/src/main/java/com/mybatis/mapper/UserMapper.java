package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询所有的用户信息
    List<User> findAllUsers();

    //根据id查询用户信息
    User getUserbyId(Integer id);

    //根据id查询用户信息
    User getUserbyParam(@Param(value = "username") String username, @Param("password") String password);

    //查询登录
    User checkLogin(String username,String password);

    //以map形式查询登录
    User checkLoginByMap(Map<String,Object>map);

    //添加用户信息
    int addUser(User user);

    //根据id查询用户信息，以map形式返回结果
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    //查询所有用户信息，以map形式返回结果
    //此时就可以将每条数据转化的map集合作为值，以某个字段的值作为键，就是数据库表中对应MapKey的值作为键，放在同一个map集合里面了
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

}
