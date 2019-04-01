package designpattern.event;

/**
 * author:jiliang
 * Date:2018/12/26
 * Time:10:13
 */
public class DemoListener1 implements DemoListener {
    @Override
    public void handleEvent(DemoEvent de) {
        System.out.println("Inside listener1...");
        de.say();//回调
    }
}

