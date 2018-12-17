package com.example.spring.boot.config;

import com.example.spring.boot.cond.LinuxCondition;
import com.example.spring.boot.cond.WindowsCondition;
import com.example.spring.boot.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name = "bill")
    @Conditional({WindowsCondition.class})
    public Person person1() {
        return new Person("Bill Gates", 62);
    }

    @Bean(name = "linus")
    @Conditional({LinuxCondition.class})
    public Person person2() {
        return new Person("Linus", 48);
    }
}
