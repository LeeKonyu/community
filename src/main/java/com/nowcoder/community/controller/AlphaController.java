package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    /**
     * 加了ResponseBody之后，返回的内容会作为返回体（Request Body）给浏览器，
     * 而不会通过视图解析器解析成视图
     * @return
     */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello SpringBoot";
    }

    @Autowired
    private AlphaService alphaService;
    @RequestMapping("/select")
    @ResponseBody
    public String select(){
        return alphaService.select();
    }

    @RequestMapping(path = "student/{id}")
    @ResponseBody
    public String getStudents(@PathVariable("id") int id, @RequestParam(name = "name", defaultValue = "张三") String name){
        System.out.println(id);
        System.out.println(name);
        return "我是学生";
    }

    @RequestMapping(path = "/student")
    @ResponseBody
    public String getStudent(String id, String name){
        System.out.println(id);
        System.out.println(name);
        return "student from get success";
    }

    //响应HTML数据
    @RequestMapping(path = "/teacher")
    public ModelAndView getTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "张三");
        modelAndView.addObject("age", 20);
        modelAndView.setViewName("demo/view");
        return modelAndView;
    }

    @RequestMapping(path = "/school")
    public String getSchool(Model model){
        model.addAttribute( "name", "南京大学");
        model.addAttribute( "age", "121");
        return "demo/view";
    }

    @RequestMapping(path = "/emp")
    @ResponseBody
    public Map<String, Object> getEmp(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 20);
        map.put("sex", "男");
        return map;
    }
}
