package org.lzw.base.listener;

import org.lzw.base.event.MyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyListener implements ApplicationListener<ApplicationEvent> {


    @Override
    //当容器中发布事件后，方法会触发
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到spring内部事件 "+ event);

        if(event.getClass().equals(MyEvent.class)){
            System.out.println("收到自定义事件 "+ event);
        }
    }
}
