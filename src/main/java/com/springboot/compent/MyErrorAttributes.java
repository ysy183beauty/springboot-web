package com.springboot.compent;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class MyErrorAttributes extends DefaultErrorAttributes {
    //返回页面和json都可以获取到字段信息
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","yangge");
        //获取自定义异常数据信息
        Map<String,Object> data= (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext",data);
        return map;
    }
}
