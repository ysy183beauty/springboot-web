package com.springboot.controller;

import com.springboot.dao.DepartmentDao;
import com.springboot.dao.EmployeeDao;
import com.springboot.entities.Department;
import com.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工列表
    @GetMapping("/emps")
    public String list(Model model){
        //获取所有的员工信息
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        //路径classpath:/templates/xxx.html
      return "/emp/list";
    }

    //添加页面信息
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "/emp/add";
    }

    //添加员工信息
    //springMVC 将属性与字段一一对应，基本要求：请求参数名字与java Bean属性名称一致
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //redirect:重定向一个新地址 /表示当前项目下
        //forward:表示转发到一个地址
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //修改员工信息
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
       //通过id查询员工信息
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //查询部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    //修改员工信息
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工信息
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
       employeeDao.delete(id);
       return "redirect:/emps";
    }
}
