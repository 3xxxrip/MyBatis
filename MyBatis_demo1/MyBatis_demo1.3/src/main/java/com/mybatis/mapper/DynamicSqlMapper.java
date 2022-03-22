package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSqlMapper {

    //多条件查询
    List<Emp> getEmpByCondition(Emp emp);

    //多条件查询choose，when，otherwise
    List<Emp> getEmpByConditionInChoose(Emp emp);

    //删除多条记录
    int deleteMoreByArray(@Param("eids") Integer[] eids);
}
