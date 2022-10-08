package com.mybatis.mapper;

import com.mybatis.model.User;
import org.apache.ibatis.annotations.MapKey;
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

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 查询数据条数
     * @return
     */
    int selectCount();

    /**
     * 查询所有用户信息为map集合
     * @return
     * 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，
     * 并且最终要以一个map的方式返回数据，此时需要通过@MapKey注解设置map集合的键，值是每条数据所对应的map集合
     * (不加@MapKey注解，要用List<Map<String, Object>> getAllUserToMap();)
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

    /**
     * 根据id批量删除
     * @param ids
     * @return
     */
    int deleteMore(@Param("ids") String ids);
}
