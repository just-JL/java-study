package designPattern.event;

import java.util.Enumeration;
import java.util.Vector;

/**
 * author:jiliang
 * Date:2018/12/26
 * Time:10:10
 */
public class DemoSource {
    private Vector repository = new Vector();//监听自己的监听器队列
    public DemoSource(){}
    public void addDemoListener(DemoListener dl) {
        repository.addElement(dl);
    }
    public void notifyDemoEvent() {//通知所有的监听器
        Enumeration e = repository.elements();
        while(e.hasMoreElements()) {
            DemoListener dl = (DemoListener)e.nextElement();
            dl.handleEvent(new DemoEvent(this));
        }
    }
}


