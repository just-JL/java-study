package collection.queue.blocking;

import java.util.AbstractQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * author:jiliang
 * Date:2019/3/11
 * Time:21:33
 */
public class ArrayBlockingQueueTest {

    public static ArrayBlockingQueue arrayBlockingQueue1 = new ArrayBlockingQueue(3);
    public static ArrayBlockingQueue arrayBlockingQueue2 = new ArrayBlockingQueue(3);

    public static void main(String[] args)throws Exception {
        //在构造时需要指定容量， 并可以选择是否需要公平性，如果公平参数被设置true，等待时间最长的线程会优先得到处理
        // （其实就是通过将ReentrantLock设置为true来 达到这种公平性的：即等待时间最长的线程会先操作）。
        // 通常，公平性会使你在性能上付出代价，只有在的确非常需要的时候再使用它。它是基于数组的阻塞循环队列，
        // 此队列按 FIFO（先进先出）原则对元素进行排序
//        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
//        for (int i=0; i<4; i++){
////            arrayBlockingQueue.add(i);
////            arrayBlockingQueue.offer(i);
//            arrayBlockingQueue1.offer(i);
//        }
//        System.out.println(arrayBlockingQueue.toString());
//
////        arrayBlockingQueue.remove();
////        System.out.println(arrayBlockingQueue.toString());
////        Thread.sleep(1000);
//
////        arrayBlockingQueue.poll();
////        System.out.println(arrayBlockingQueue.toString());
//
//
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
////                arrayBlockingQueue1.remove();
//                arrayBlockingQueue1.poll();
//            }
//        });
//
//        try {
//
//            thread1.start();
//        }
//        catch (Exception e){
//            e.getMessage();
//        }
//
////        Thread.sleep(1000);
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                arrayBlockingQueue1.remove(2);
//            }
//        });
//
//        thread2.start();
////        Thread.sleep(1000);
//
//        print(thread1);
//        print(thread2);

        arrayBlockingQueue2.offer(new Human("jl"));

//        System.out.println((Human)arrayBlockingQueue2.peek());
//        System.out.println((Human)arrayBlockingQueue2.element());
//        System.out.println(((Human)arrayBlockingQueue2.peek()).getName());
////        System.out.println(((Human)arrayBlockingQueue2.peek()).getName());
//        System.out.println(((Human)arrayBlockingQueue2.element()).getName());

        System.out.println(((Human)arrayBlockingQueue2.take()).getName());
        System.out.println((Human)arrayBlockingQueue2.peek());
//        System.out.println((Human)arrayBlockingQueue2.take());
        System.out.println((Human)arrayBlockingQueue2.poll());


    }

    static class Human {
        private String name;

        public Human(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }
    }

    public synchronized static void print(Thread thread){
        System.out.println(thread.getName() + "==>" + arrayBlockingQueue1.toString());
    }
}
