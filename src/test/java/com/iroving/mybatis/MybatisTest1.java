package com.iroving.mybatis;

import com.iroving.mybatis.entity.Person;
import com.iroving.mybatis.entity.Student;
import com.iroving.mybatis.dao.StudentMapper;
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

    /**
     * 直接通过sql的id来执行sql
     */
    @Test
    public void demo1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Object selectOne = session.selectOne("com.iroving.mybatis.dao.StudentMapper.selectBlog", 1);
            log.info(selectOne+"");
        }


//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            BlogMapper mapper = session.getMapper(Student.class);
//            Blog blog = mapper.selectBlog(101);
//        }
    }

    /**
     * 这个是通过代理类的方式来获取mapper，然后通过接口来进行调用
     * @throws IOException
     */
    @Test
    public void demo2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Person person = mapper.selectBlog(1);
            Person person2 = mapper.selectBlog2(1);
            log.info(person.toString());
            log.info(person.toString());
        }
    }
}
