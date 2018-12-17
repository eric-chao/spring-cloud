package com.example.spring.boot;

import com.example.spring.boot.config.BeanConfig;

import com.example.spring.boot.pojo.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class ConditionTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

    @Test
    public void test1() {

        Environment environment = applicationContext.getEnvironment();

        System.out.println("当前系统是： " + environment.getProperty("os.name"));
        Map<String, Person> map = applicationContext.getBeansOfType(Person.class);
        System.out.println(map);
    }

}
