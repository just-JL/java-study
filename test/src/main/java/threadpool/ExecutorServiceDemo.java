package threadpool;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * @author jiliang
 * @date 2018/9/12 20:01
 **/
public class ExecutorServiceDemo {

    public static void main(String[] args) {
        // 创建一个线程池对象，控制要创建几个线程对象。
        ThreadFactory namedThreadFactory = new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        NotThreadSafe notThreadSafe = new NotThreadSafe();
        NotThreadSafe notThreadSafe1 = new NotThreadSafe();

        // 可以执行Runnable对象或者Callable对象代表的线程
        pool.submit(new MyRunnable(notThreadSafe));
        pool.submit(new MyRunnable(notThreadSafe1));
//        pool.execute(new MyRunnable());

        //结束线程池
        pool.shutdown();
    }

    static class MyRunnable implements Runnable {
        NotThreadSafe notThreadSafe = null;

        public MyRunnable(NotThreadSafe notThreadSafe) {
            this.notThreadSafe = notThreadSafe;
        }

        public void run() {
//            for (int x = 0; x < 10; x++) {
//                System.out.println(Thread.currentThread().getName() + ":" + x);
//            }
            notThreadSafe.add(Thread.currentThread().getName() + "_");
            System.out.println(notThreadSafe.toString());
        }
    }
}

