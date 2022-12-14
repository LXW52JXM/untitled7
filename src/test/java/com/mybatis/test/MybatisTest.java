package com.mybatis.test;

import com.mybatis.mapper.EmpMapper;
import com.mybatis.mapper.UserMapper;
import com.mybatis.model.Emp;
import com.mybatis.model.User;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.*;


/**
 * 测试
 */
public class MybatisTest {

    @Test
    public void testMyBatis() throws IOException {
        /*
        // Class.forName("com.mysql.jdbc.Driver");
        //读取MyBatis的核心配置文件
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象（sql会话工厂构建器）
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sqlSession，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
         */

        //封装数据库连接类
        SqlSession sqlSession =SqlSessionUtils.getSqlSession();

        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        //int result = userMapper.insertUser();
        //int update = userMapper.updateUser();
        //List<User> ur=userMapper.selectAll();
        //List<User> us=userMapper.selectUser("李四");单个参数传递
        //List<User> login=userMapper.checkLogin("1254","123");
        //Map<String, Object> map=new HashMap<>();map参数传递
        //map.put("email","1254");
        //map.put("password","123");
        //List<User> login=userMapper.checkLoginByMap(map);
        //User user=new User(0,"Tom","123456",12,'男',"123@321.com");
        //int ins=userMapper.insertUser(user);
        //User ur=userMapper.CheckLoginByParam("Tom","123456");使用@Param标识参数
        //List<User> userList=userMapper.getUserByLike("三");模糊查询
        //int count= userMapper.selectCount();数据条数
        //Map<String,Object> map=userMapper.getAllUserToMap();@MapKey注解map集合
        //int deleteCount= userMapper.deleteMore("1,6,5");
        //Emp em=empMapper.getEmpAndDept(3);自定义映射
        Emp emp=new Emp(0,"张三",45,"",null,null);
        List<Emp> empList=empMapper.getEmpByCondition(emp);

        //手动提交事务
        //sqlSession.commit();

        //System.out.println("添加result:" + result);
        //System.out.println("修改update:" + update);
        //System.out.println("全部:" + ur);
        //System.out.println("单个:" + us);
        //System.out.println("两个："+login);
        //System.out.println("实体添加："+ins);
        //System.out.println("使用@Param标识参数:"+ur);
        //System.out.println("模糊查询："+userList);
        //System.out.println("数据条数："+count);
        //System.out.println("map集合："+map);
        //System.out.println("删除条数："+deleteCount);
        //System.out.println("自定义映射："+em);
        System.out.println("自定义sql结果："+empList);
    }
//    public void  testDelete
}
