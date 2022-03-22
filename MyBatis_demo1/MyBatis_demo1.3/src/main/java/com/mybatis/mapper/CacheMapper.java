package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    //通过id获取emp对象
    Emp getEmpByEid(@Param("eid") Integer eid);
}
