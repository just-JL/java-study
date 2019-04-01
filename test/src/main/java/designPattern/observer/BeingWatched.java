package designpattern.observer;

/**
 * author:jiliang
 * Date:2018/12/26
 * Time:9:32
 */
class BeingWatched extends java.util.Observable {
    void counter(int period) {
        for(; period>=0; period-- ) {
            setChanged();
            notifyObservers(new Integer(period));
            try {
                Thread.sleep(100);
            } catch( InterruptedException e) {
                System.out.println("Sleep interrupeted" );
            }
        }
    }
};
