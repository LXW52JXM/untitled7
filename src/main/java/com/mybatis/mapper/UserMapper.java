package com.mybatis.mapper;

import com.mybatis.model.User;

import java.util.List;

/**
 * 用户接口
 */
public interface UserMapper {
    /**
     * 添加用户
     * @return
     */
    int insertUser();

    /**
     * 修改用户
     * @return
     */
    int updateUser();

    /**
     * 查询全部用户
     * @return
     */
    List<User> selectAll();
}
