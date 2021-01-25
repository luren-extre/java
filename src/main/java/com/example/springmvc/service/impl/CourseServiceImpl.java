package com.example.springmvc.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springmvc.entity.Course;
import com.example.springmvc.mapper.CourseMapper;
import com.example.springmvc.service.ICourseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luren
 * @since 2020-11-02
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

}
