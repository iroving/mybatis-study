package com.iroving.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class MybatisTest1 {
    @Test
    public void demo1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Object selectOne = session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
            log.info(selectOne.toString());
        }


//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            BlogMapper mapper = session.getMapper(BlogMapper.class);
//            Blog blog = mapper.selectBlog(101);
//        }
    }
}
