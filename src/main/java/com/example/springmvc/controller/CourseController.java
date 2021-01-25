package com.example.springmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luren
 * @since 2020-11-02
 */
@RestController
@RequestMapping("/experience/course")
public class CourseController {

    @Autowired
    private ValueOperations valueOperations;

    @GetMapping
    public void test(){
        valueOperations.set("name","张三");
    }

}
