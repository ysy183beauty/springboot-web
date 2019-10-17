package com.springboot.controller;

import com.springboot.dao.EmployeeDao;
import com.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    //查询所有员工列表
    @GetMapping("/emps")
    public String list(Model model){
        //获取所有的员工信息
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        //路径classpath:/templates/xxx.html
      return "/emp/list";
    }
}
