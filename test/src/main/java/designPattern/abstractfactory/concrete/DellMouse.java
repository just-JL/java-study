package designpattern.abstractfactory.concrete;

import designpattern.abstractfactory.framework.Mouse;

/**
 * author:jiliang
 * Date:2019/3/13
 * Time:22:05
 */
public class DellMouse extends Mouse {
    @Override
    public void produceMouse() {
        System.out.println("生产了戴尔鼠标");
    }
}
