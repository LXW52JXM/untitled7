package com.mybatis.mapper;

import com.mybatis.model.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    /**
     * 根据用户id查找详细信息
     * @param eid
     * @return
     */
    Emp getEmpAndDept(@Param("eid")Integer eid);
}
