package com.mybatis.mapper;

import com.mybatis.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
     * 通过实体类型传递参数添加用户
     * @param user
     * @return
     */
    int insertUser(User user);
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

    /**
     * 查询指定姓名的用户
     * @param name
     * @return
     */
    List<User> selectUser(String name);

    /**
     * 登录验证
     * @param email
     * @param password
     * @return
     */
    List<User> checkLogin(String email,String password);

    /**
     * 根据map集合传值
     * @param map
     * @return
     */
    List<User> checkLoginByMap(Map<String,Object> map);

    /**
     * 使用@Param标识参数
     * @param username
     * @param password
     * @return
     */
    User CheckLoginByParam(@Param("username") String username, @Param("password") String password);
}
