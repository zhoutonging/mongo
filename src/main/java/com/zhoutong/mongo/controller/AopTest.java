package com.zhoutong.mongo.controller;

import com.zhoutong.mongo.common.Action;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AopTest {

    @GetMapping("helloAop")
    @Action
    public String  helloAop(){
        return "Hello Spring";
    }

}
