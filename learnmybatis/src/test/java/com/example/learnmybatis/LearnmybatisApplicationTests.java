package com.example.learnmybatis;

import com.example.learnmybatis.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnmybatisApplicationTests {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init () {
        try {

            // 通过 Resources 工具类将 mybatis-config.xml 配置文件读入 Reader。
            Reader reader = Resources.getResourceAsReader ("mybatis-config.xml") ;

            // SqlSessionFactory 就包含了所有的属性配置和执行 SQL 的信息。
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            reader.close();

        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    @Test
    public void contextLoads() {

        // 使用SqlSessionFactory，获取一个SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            // 找到CountryMapper.xml中id="selectAll"的方法，执行SQL查询
            List<Country> countryList = sqlSession.selectList("selectAll");
            printCountryList(countryList);
        } finally {
            // 不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }

}
