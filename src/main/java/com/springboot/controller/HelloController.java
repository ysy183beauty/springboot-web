package com.springboot.controller;

import com.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
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

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
       if("aaa".equals(user)){
           throw new  UserNotExistException();
       }
       return "Hello world";
    }
}
