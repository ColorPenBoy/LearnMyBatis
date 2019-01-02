package com.example.learnmybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.Reader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init () {
        try {

            // 通过 Resources 工具类将 mybatis-config.xml 配置文件读入 Reader。
            Reader reader = org.apache.ibatis.io.Resources.getResourceAsReader ("mybatis-config.xml") ;

            // SqlSessionFactory 就包含了所有的属性配置和执行 SQL 的信息。
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            reader.close();

        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    public SqlSession getSqlSession() {
        // 使用SqlSessionFactory，获取一个SQLSession
        return sqlSessionFactory.openSession();
    }

}
