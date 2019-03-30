/**
 * @author:jiliang
 * @Date:2019/3/16
 * @Time:22:36
 */
public class SynchronizedDemo {

    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static void method() {
    }
}
