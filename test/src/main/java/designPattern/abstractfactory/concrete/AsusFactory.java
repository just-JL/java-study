package designpattern.abstractfactory.concrete;

import designpattern.abstractfactory.framework.Keyboard;
import designpattern.abstractfactory.framework.Mouse;
import designpattern.abstractfactory.framework.PcFactory;

/**
 * author:jiliang
 * Date:2019/3/13
 * Time:22:05
 */
public class AsusFactory extends PcFactory {
    @Override
    public Mouse createMouse() {
        return new AsusMouse();
    }

    @Override
    public Keyboard createKeyBoard() {
        return new AsusKeyboard();
    }
}
