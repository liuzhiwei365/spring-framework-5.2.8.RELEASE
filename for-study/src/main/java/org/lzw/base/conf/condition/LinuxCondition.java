package org.lzw.base.conf.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        ClassLoader classLoader = context.getClassLoader();
        Environment environment = context.getEnvironment();
        BeanDefinitionRegistry registry = context.getRegistry(); //bean 定义注册类

        String property = environment.getProperty("os.name");

        System.out.println(property);
        return property.contains("Mac OS X");

    }
}
