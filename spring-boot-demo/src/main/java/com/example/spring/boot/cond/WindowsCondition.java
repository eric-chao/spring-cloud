package com.example.spring.boot.cond;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 获取ioc使用的BeanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();

        // 获取累加载器
        ClassLoader classLoader = conditionContext.getClassLoader();

        // 获取当前环境信息
        Environment environment = conditionContext.getEnvironment();

        // 获取bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        // 获取当前操作系统
        String property = environment.getProperty("os.name");

        // 包含windows则说明是windows系统，返回true
        if (property.contains("Windows")) {
            return true;
        }

        return false;
    }
}
