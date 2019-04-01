package designpattern.abstractfactory.concrete;

import designpattern.abstractfactory.framework.Mouse;

/**
 * author:jiliang
 * Date:2019/3/13
 * Time:22:09
 */
public class AsusMouse extends Mouse {
    @Override
    public void produceMouse() {
        System.out.println("生产了华硕键盘");
    }
}
