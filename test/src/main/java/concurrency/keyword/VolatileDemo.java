package concurrency.keyword;

/**
 * @author:jiliang
 * @Date:2019/3/20
 * @Time:22:16
 */
public class VolatileDemo {

    //如果不加volatile，线程thread有可能会死循环
    //因为isOver=true不确定什么时候会写入主内存
    private static volatile boolean isOver = false;
//    private static volatile int i = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) {
                    System.out.println("aaa");
                };
//                i = 10;
//                System.out.println("====> " + i);
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                isOver = true;
////                int j = i;
////                System.out.println("----> " + j);
//            }
//        });
//        thread.start();
//        thread1.start();

    }
}
