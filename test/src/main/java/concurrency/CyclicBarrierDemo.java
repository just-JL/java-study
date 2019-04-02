package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:jiliang
 * @Date:2019/3/30
 * @Time:22:21
 */
public class CyclicBarrierDemo {

    //指定必须有6个运动员到达才行
    private static CyclicBarrier barrier = new CyclicBarrier(6, new Runnable() {
        @Override
        public void run() {
            System.out.println("所有运动员入场，裁判员一声令下！！！！！");
        }
    });
    public static void main(String[] args) {
        System.out.println("运动员准备进场，全场欢呼............");

        ExecutorService service = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 6; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " 运动员，进场");
                        barrier.await();
                        System.out.println(Thread.currentThread().getName() + "  运动员出发");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
