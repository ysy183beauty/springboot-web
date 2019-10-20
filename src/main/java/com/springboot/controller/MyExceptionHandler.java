package com.springboot.controller;

import com.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    //浏览器和其他客户端都返回json格式的数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handlerException(Exception e){
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","userNotExist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        map.put("code","userNotExist");
        map.put("message",e.getMessage());
        //传入我们自己的错误代码，4xxx,5xxx
        request.setAttribute("javax.servlet.error.status_code",500);//为了能够就进入自己设置的错误界面
        //设置自定义的数据信息
        request.setAttribute("ext",map);
        //下面代码是为了自适应(浏览器和其他客户端访问自动识别)
        return "forward:/error";
    }
}
