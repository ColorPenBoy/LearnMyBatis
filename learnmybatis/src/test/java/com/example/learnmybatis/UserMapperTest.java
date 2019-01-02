package com.example.learnmybatis;

import com.example.learnmybatis.mapper.UserMapper;
import com.example.learnmybatis.model.SysRole;
import com.example.learnmybatis.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserMapperTest extends BaseMapperTest {
    @Test
    public void testSelectById() {
        //获取 sqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取 UserMapper 接 口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class); //调用 selectByid 方法，查询 id = 1 的用户
            SysUser user = userMapper.selectById(Long.parseLong( "1"));

            // user 不为空
            Assert.assertNotNull(user);
            //userName = admin
            Assert.assertEquals("admin", user.getUserName());
        } finally {
            // 不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }


    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class); //调用 selectAll 方法查询所有用户
            List<SysUser> userList = userMapper.selectAll();

            // 结采不为空
            Assert.assertNotNull(userList); //用户数量大于 0 个
            Assert.assertTrue(userList.size() > 0);
        } finally {
            // 不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserId() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class); //调用 selectAll 方法查询所有用户
            List<SysRole> userList = userMapper.selectRolesByUserId(Long.parseLong( "1"));

            // 结采不为空
            Assert.assertNotNull(userList); //用户数量大于 0 个
            Assert.assertTrue(userList.size() > 0);
        } finally {
            // 不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }
}