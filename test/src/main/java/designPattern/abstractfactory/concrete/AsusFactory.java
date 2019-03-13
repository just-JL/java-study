package designPattern.abstractfactory.concrete;

import designPattern.abstractfactory.framework.Keyboard;
import designPattern.abstractfactory.framework.Mouse;
import designPattern.abstractfactory.framework.PcFactory;

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
