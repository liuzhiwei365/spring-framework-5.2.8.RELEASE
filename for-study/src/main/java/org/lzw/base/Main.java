package org.lzw.base;


import org.lzw.base.conf.aspect.MyCalcTool;
import org.lzw.base.context.MyAnnotationConfigApplicationContext;
import org.lzw.base.event.MyEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
       // ClassPathXmlApplicationContext  ct =
       //        new ClassPathXmlApplicationContext("beans.xml");


        AnnotationConfigApplicationContext at
                = new MyAnnotationConfigApplicationContext(org.lzw.base.conf.MainConfig.class);

        String[] beanDefinitionNames = at.getBeanDefinitionNames();

        Arrays.stream(beanDefinitionNames).forEach(System.out::println);

        Object calc= at.getBean("calc");

        int add = ((MyCalcTool) calc).aadd();

        System.out.println(add);

        at.publishEvent(new MyEvent("事件"));

        //容器关闭也可以发布事件
        at.close();
    }

}
