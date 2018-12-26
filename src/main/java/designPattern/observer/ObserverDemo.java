package designPattern.observer;

/**
 * author:jiliang
 * Date:2018/12/26
 * Time:9:32
 */
public class ObserverDemo {
    public static void main(String[] args) {
        BeingWatched beingWatched = new BeingWatched();//受查者
        Watcher watcher = new Watcher();//观察者
        Watcher_1 watcher_1 = new Watcher_1();//观察者
        Watcher_2 watcher_2 = new Watcher_2();//观察者

        beingWatched.addObserver(watcher_2);
        beingWatched.addObserver(watcher_1);
        beingWatched.addObserver(watcher);
        beingWatched.counter(10);
    }
}

