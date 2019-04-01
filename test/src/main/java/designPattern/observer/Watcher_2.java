package designpattern.observer;

/**
 * author:jiliang
 * Date:2018/12/26
 * Time:9:31
 */
class Watcher_2 implements java.util.Observer {
    @Override
    public void update(java.util.Observable obj, Object arg) {
        System.out.println("Update() Watcher_2 called, count is "
                + ((Integer) arg).intValue());
    }
}
