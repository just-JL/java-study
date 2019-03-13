package com.example.demo.eventbus;

import com.google.common.eventbus.EventBus;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * author:jiliang
 * Date:2019/3/13
 * Time:9:20
 */
public class CookieContainer {
    private EventBus eventBus;
    private AtomicInteger numberOfCookie = new AtomicInteger();

    public CookieContainer(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void setNumberOfCookie(int intenger) {
        numberOfCookie.set(intenger);
    }

    public void getACookie() {
        if (numberOfCookie.get() == 0) {
            long start = System.currentTimeMillis();
            eventBus.post(new EmptyEvent());
            System.out.println("Publishing event time: " + (System.currentTimeMillis() - start) + " ms");
            return;
        }
        numberOfCookie.decrementAndGet();
        System.out.println("retrieve a cookie");
    }
}
