package com.example.learnmybatis.mapper;

import com.example.learnmybatis.model.SysRole;
import com.example.learnmybatis.model.SysUser;

import java.util.List;

public interface UserMapper {

    /**
     * 通过id查询用户
     */
    SysUser selectById(Long id);

    /**
     * 查询全部用户
     */
    List<SysUser> selectAll();

    /**
     * 根据用户id获取角色信息
     */
    List<SysRole> selectRolesByUserId(Long id);
}
