package designpattern.abstractfactory;

import designpattern.abstractfactory.concrete.AsusFactory;
import designpattern.abstractfactory.concrete.DellFactory;
import designpattern.abstractfactory.framework.Keyboard;
import designpattern.abstractfactory.framework.Mouse;

/**
 * author:jiliang
 * Date:2019/3/13
 * Time:22:12
 */
public class Client {

    public static void main(String[] args) {

        DellFactory dellFactory = new DellFactory();
        Mouse dellMouse = dellFactory.createMouse();
        Keyboard dellKeyboard = dellFactory.createKeyBoard();
        dellMouse.produceMouse();
        dellKeyboard.produceKeyboard();

        AsusFactory asusFactory = new AsusFactory();
        Mouse asusMouse = asusFactory.createMouse();
        Keyboard asusKeyboard = asusFactory.createKeyBoard();
        asusMouse.produceMouse();
        asusKeyboard.produceKeyboard();
    }
}
