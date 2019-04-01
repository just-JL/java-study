package designpattern.abstractfactory.concrete;

import designpattern.abstractfactory.framework.Keyboard;

/**
 * author:jiliang
 * Date:2019/3/13
 * Time:22:08
 */
public class DellKeyboard extends Keyboard {
    @Override
    public void produceKeyboard() {
        System.out.println("生产了戴尔键盘");
    }
}
