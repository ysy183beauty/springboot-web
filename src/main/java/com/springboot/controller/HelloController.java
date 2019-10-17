package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //classpath:/templates/success.html
        map.put("hello","<h1>您好</h1>");
        map.put("users", Arrays.asList("zhansan","lisi","wangwu","dingliu"));
        return "success";
    }
}
