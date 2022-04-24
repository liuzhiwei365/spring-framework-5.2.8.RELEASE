package org.lzw.base.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.stream.Stream;

public class MyAnnotationConfigApplicationContext extends AnnotationConfigApplicationContext {

    public MyAnnotationConfigApplicationContext(Class<?>... componentClasses) {
        super(componentClasses);
    }

    @Override
    public void initPropertySources() {

        System.out.println(" 入口在prepareRefresh() 方法" );

        ConfigurableEnvironment env = getEnvironment();

        //系统属性 即 jvm 属性 ，不同于环境变量
        env.getSystemProperties().forEach((x,y)-> System.out.println(x+"------>   "+y));
    }
}
