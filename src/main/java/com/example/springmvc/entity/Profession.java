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
@TableName("profession")
@EqualsAndHashCode(callSuper = false)
public class Profession implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;


}
