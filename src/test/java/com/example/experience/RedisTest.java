package com.example.experience;

import com.example.springmvc.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);

    ValueOperations<String,Object> valueOperations = applicationContext.getBean(ValueOperations.class);

    @Test
    public void redisTest(){
        applicationContext.refresh();
        log.info("-----------------:{}",valueOperations.toString());
        valueOperations.set("name","张三");
    }

}
