package com.example.springmvc.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springmvc.entity.Profession;
import com.example.springmvc.mapper.ProfessionMapper;
import com.example.springmvc.service.IProfessionService;
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
public class ProfessionServiceImpl extends ServiceImpl<ProfessionMapper, Profession> implements IProfessionService {

}
