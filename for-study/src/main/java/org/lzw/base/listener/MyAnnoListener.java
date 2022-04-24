package org.lzw.base.listener;

import org.lzw.base.event.MyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class MyAnnoListener {


    @EventListener(classes = MyEvent.class)
    public void listen(ApplicationEvent  e){
        System.out.println(" 注解监听 "+ e);
    }


}
