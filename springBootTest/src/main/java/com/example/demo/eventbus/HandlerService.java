package com.example.demo.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * author:jiliang
 * Date:2019/3/13
 * Time:9:16
 */
public interface HandlerService {
    @Subscribe
    void handler(EmptyEvent emptyEvent);
}
