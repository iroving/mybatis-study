package com.iroving.mybatis.dao;

import com.iroving.mybatis.entity.Person;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
    public Person selectBlog(Integer id);

    @Select("select * from person where id=#{a}")
    public Person selectBlog2(Integer id);

}
