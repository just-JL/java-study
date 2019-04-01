package designpattern.abstractfactory.concrete;

import designpattern.abstractfactory.framework.Keyboard;
import designpattern.abstractfactory.framework.Mouse;
import designpattern.abstractfactory.framework.PcFactory;

/**
 * author:jiliang
 * Date:2019/3/13
 * Time:22:03
 */
public class DellFactory extends PcFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard createKeyBoard() {
        return new DellKeyboard();
    }
}
