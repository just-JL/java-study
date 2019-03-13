package com.example.demo.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * author:jiliang
 * Date:2019/3/13
 * Time:9:19
 */
public class CookieSeller implements HandlerService {

    public CookieSeller(EventBus eventBus) {
        eventBus.register(this);
    }

    @Override
    public void handler(EmptyEvent emptyEvent) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getClass().getName() + ":" + "receiving empty event");
    }
}
