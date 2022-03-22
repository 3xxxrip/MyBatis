package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

public class CacheMapperTest {

    @Test
    public void getEmpByEid() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpByEid(1);
        //手动清空一级缓存
        sqlSession.clearCache();
        System.out.println(emp1);
        Emp emp2 = mapper.getEmpByEid(1);

        System.out.println(emp2);
    }
}