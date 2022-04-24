package org.lzw.base.conf;


import org.lzw.base.bean.Person;
import org.lzw.base.conf.aspect.MyCalcTool;
import org.lzw.base.conf.aspect.MyLogAspect;
import org.lzw.base.conf.condition.LinuxCondition;
import org.lzw.base.controller.BookController;
import org.lzw.base.listener.MyListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * ConfigurationClassPostProcessor  来处理配置类,
 * 实现了 BeanDefinitionRegistryPostProcessor,PriorityOrdered, ResourceLoaderAware, BeanClassLoaderAware, EnvironmentAware接口
 *
 * PriorityOrdered 说明 他是最优先调用的
 * */
@Configuration
@ComponentScan(value = "org.lzw",
        excludeFilters = {
            //@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}), //按照过滤注解
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {Person.class} // 按照类型过滤
              ) //自定义
        }
)
@EnableAspectJAutoProxy
/**@ImportResource它导入的是一个xml配置文件，然后通过解析xml文件的方式再把解析好的Bean信息导入到Spring容器内*/
@ImportResource(locations = "classpath:spring-beans.xml") //Spring提供这个注解主要是为了向下兼容，便于老项目进行迁移,比如dubbo
//@MapperScan("org.lzw.base.mapper") //  使用mybatis
public class MainConfig {


    /**	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE //多例
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON  //单例
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  //每次请求，一个对象
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION  //每个session，一个对象
     */
    @Scope("prototype") //多例
    @Lazy  //bean对象懒加载
    @Bean("p")
    public Person getPerson(){

        return new Person("lzw",29);
    }

    @Conditional({LinuxCondition.class})
    @Bean("bill")
    public Person getPerson2(){

        return new Person("bill",29);
    }


    @Bean("calc")
    public MyCalcTool myCalcTool(){
        return new MyCalcTool();
    }

    @Bean
    public MyLogAspect myLogAspect(){
        return new MyLogAspect();
    }


    @Bean
    public MyListener  myListener(){
        return new MyListener();
    }
}
