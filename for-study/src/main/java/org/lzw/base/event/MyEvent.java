package org.lzw.base.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    private static final long serialVersionUID = 7099057708183571652L;

    public MyEvent(Object source) {
        super(source);
    }
}
