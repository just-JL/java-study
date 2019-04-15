package org.apache.dubbo.demo.provider;

import org.apache.dubbo.demo.DemoService;

/**
 * @author:jiliang
 * @Date:2019/4/15
 * @Time:16:46
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
