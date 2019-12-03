package com.iroving.mybatis.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
    private String name;
    private String sex;
    private Integer age;
    private Integer id;
}
