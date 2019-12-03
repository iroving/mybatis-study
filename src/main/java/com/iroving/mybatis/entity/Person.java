package com.iroving.mybatis.entity;

import lombok.Data;

@Data
public class Person extends Student {
    private String name;
    private String sex;
    private Integer age;
    private Integer id;

}
