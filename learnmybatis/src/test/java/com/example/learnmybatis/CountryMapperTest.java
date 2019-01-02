package com.example.learnmybatis;

import com.example.learnmybatis.model.Country;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class CountryMapperTest extends BaseMapperTest {

    @Test
    public void testSelectAll() {

        SqlSession sqlSession = getSqlSession();

        try {
            // 找到CountryMapper.xml中id="selectAll"的方法，执行SQL查询
            // selectAll 方法不唯一，所以需要带上namespace
            List<Country> countryList = sqlSession.selectList("com.example.learnmybatis.mapper.CountryMapper.selectAll");
            printCountryList(countryList);
        } finally {
            // 不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n",
                    country.getId(),
                    country.getCountryname(),
                    country.getCountrycode());
        }
    }

}
