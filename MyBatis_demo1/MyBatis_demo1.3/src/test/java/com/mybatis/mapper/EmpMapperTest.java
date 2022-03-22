package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmpMapperTest {

    @Test
    public void getAllEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAdnDept = empMapper.getEmpAdnDept(1);
        System.out.println(empAdnDept);

    }
}