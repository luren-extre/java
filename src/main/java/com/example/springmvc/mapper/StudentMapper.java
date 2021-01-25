package com.example.springmvc.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springmvc.entity.Student;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author luren
 * @since 2020-11-02
 */
@Component
public interface StudentMapper extends BaseMapper<Student> {

}
