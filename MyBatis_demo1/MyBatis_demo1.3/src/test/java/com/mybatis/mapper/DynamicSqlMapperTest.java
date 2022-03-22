package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DynamicSqlMapperTest {

    @Test
    public void getEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<Emp> longjian = mapper.getEmpByCondition(new Emp(null, null, null, "男", null, null));
        System.out.println(longjian);
    }
    @Test
    public void getEmpByConditionInChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<Emp> emp = mapper.getEmpByConditionInChoose(new Emp(null, null, null, "", null, null));
        System.out.println(emp);
    }
    @Test
    public void deleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        int i = mapper.deleteMoreByArray(new Integer[]{8, 9});
        System.out.println(i);
    }
}