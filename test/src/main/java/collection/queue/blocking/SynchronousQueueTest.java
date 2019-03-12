package collection.queue.blocking;

import java.util.concurrent.SynchronousQueue;

/**
 * author:jiliang
 * Date:2019/3/12
 * Time:22:18
 */
public class SynchronousQueueTest {

    public static void main(String[] args) throws Exception{
        //不像ArrayBlockingQueue或LinkedListBlockingQueue，SynchronousQueue内部并没有数据缓存空间，
        // 你不能调用peek()方法来看队列中是否有数据元素，因为数据元素只有当你试着取走的时候才可能存在，
        // 不取走而只想偷窥一下是不行的，当然遍历这个队列的操作也是不允许的。
        // 队列头元素是第一个排队要插入数据的线程，而不是要交换的数据。
        // 数据是在配对的生产者和消费者线程之间直接传递的，并不会将数据缓冲数据到队列中。
        // 可以这样来理解：生产者和消费者互相等待对方，握手，然后一起离开
        final SynchronousQueue synchronousQueue = new SynchronousQueue();

//        synchronousQueue.add(1);
//        synchronousQueue.add("jl");

//        synchronousQueue.put(1);

//        System.out.println(synchronousQueue.toString());

//        System.out.println(synchronousQueue.take());


        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread start");
                try {
                    synchronousQueue.put(1);
                } catch (InterruptedException e) {
                }
                System.out.println("put thread end");
            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread start");
                try {
                    System.out.println("take from putThread: " + synchronousQueue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread end");
            }
        });

        putThread.start();
        Thread.sleep(1000);
        takeThread.start();
    }

}
