package com.example.springmvc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author luren
 * @since 2020-11-02
 */
@Data
@TableName("student")
@EqualsAndHashCode(callSuper = false)
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Integer number;

    private Integer professionId;


}
