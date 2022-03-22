package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.github.pagehelper.PageHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageHelperTest {
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
    SqlSession sqlSession = build.openSession(true);
    private EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

    public PageHelperTest() throws IOException {
    }

    @Test
    public void testPageHelp(){
        Page<Object> objects = PageHelper.startPage(2, 3);
        List<Emp> emps = mapper.selectByExample(null);
        PageInfo<Emp> empPageInfo = new PageInfo<>(emps, 5);

        for (Emp emp:emps
             ) {
            System.out.println(emp);
        }
        System.out.println(empPageInfo);
    }
}
