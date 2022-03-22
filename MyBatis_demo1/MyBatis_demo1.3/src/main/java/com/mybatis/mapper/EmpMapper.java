package com.mybatis.mapper;

import com.mybatis.pojo.Dept;
import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    //查询所有的员工信息
    List<Emp> getAllEmp();

    //查询员工以及员工所对应的部门信息
    Emp getEmpAdnDept(@Param("id") Integer id);

    /*通过分步查询查询员工以及员工对应的部门信息
    * 1.首先查询员工信息
    * */
    Emp getEmpAndDeptByStepOne(@Param("id") Integer id);

    /*通过分步查询查询员工以及员工对应的部门信息
    * 2.根据员工对应id的查询部门信息
    * */
    Emp getEmpAndDeptByStepTwo(@Param("id") Integer id);

    Dept getEmpAndDeptByStepTwox(@Param("id") Integer id);
}
