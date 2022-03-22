package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


public class EmpMapperTest {
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = build.openSession(true);
            private EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);


    public EmpMapperTest() throws IOException {

    }

    @Test
    public void countByExample() {

    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExample() {
    //        List<Emp> emps = mapper.selectByExample(null);
    //        System.out.println(emps);
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEidBetween(3, 6);
        Integer[] x ={1,2};
        List<Integer> integers = Arrays.asList(x);
        empExample.or().andAgeIn(integers);
        List<Emp> emps = mapper.selectByExample(empExample);
        System.out.println(emps);
    }

    @Test
    public void selectByPrimaryKey() {
    }
    //选择性修改和普通修改不同的地方是，只会选择性修改只会修改你写的值不为null的字段

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}