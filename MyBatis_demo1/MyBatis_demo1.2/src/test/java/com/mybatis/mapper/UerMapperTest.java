package com.mybatis.mapper;

import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UerMapperTest {

    @Test
    public void findAllUsers() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        System.out.println(mapper.findAllUsers());
//        System.out.println(mapper.getUserbyId(1));
        User longjian = mapper.getUserbyParam("longjian", "200105");
        if(longjian==null){
            System.out.println("登录失败");
        }else{
            System.out.println("登录成功");
        }
    }

    @Test
    public void checkLoginByMap() {
        Map<String, Object> map= new HashMap<>();
        map.put("username", "longjian");
        map.put("password", "200105");
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);
//        assert sqlSession != null;
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public void addUserTest() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);
//        assert sqlSession != null;
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.addUser(new User(null, "kyrie", "200105", "男", "2459095104@qq.com"));
        System.out.println(i);

    }
    @Test
    public void getUserByIdToMap() {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> userByIdToMap = mapper.getUserByIdToMap(1);
        System.out.println(userByIdToMap);
    }
    @Test
    public void getAllUserToMap() {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);

    }
}