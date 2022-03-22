package com.myBatis.mapper;

import com.myBatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {
    //sqlSession默认不自动提交事务，如果想要自动提交事务，在获取sqlSession时在openSession()方法中传参true就是设置自动提交了

    @Test
    public void insertUser() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取sqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        //通过sqlSessionFactory对象获取sqlSession对象，这个session会话就类似于javaWeb中的会话一样，不过这个会话是位于java程序和数据库之间的回话
        //true设置自动提交事务
        SqlSession sqlSession = build.openSession(true);

        //获取mapper接口对象，getMapper这个方法底层用了Proxy类，就是代理类，传进去接口Class对象获取一个对应接口的实现类对象，也就是获取了代理类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
//        int i = mapper.insertUser();

        //测试修改功能
//        mapper.updateUser();

//        //测试查询功能
//        User user = mapper.querytUserById();
//        System.out.println(user);
        //提交事务
//        sqlSession.commit();

        //测试查询所有用户功能
        List<User> allUser = mapper.getAllUser();
        for (User user:allUser) {
            System.out.println(user);
        }
    }
}