package com.example.learnmybatis.mapper;

import com.example.learnmybatis.model.Country;

import java.util.List;

public interface CountryMapper {
    /**
     * 查询全部用户
     */
    List<Country> selectAll();
}
