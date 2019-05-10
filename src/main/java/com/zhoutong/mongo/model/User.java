package com.zhoutong.mongo.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@ToString
public class User {

    @Id
    private String id;

    private String name;

    private Integer age;

    private Integer height;

    private Date birthday;


}
