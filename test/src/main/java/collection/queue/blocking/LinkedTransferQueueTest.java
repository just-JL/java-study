package collection.queue.blocking;

/**
 * author:jiliang
 * Date:2019/3/12
 * Time:23:04
 */
public class LinkedTransferQueueTest {

    public static void main(String[] args) {
        //无界的阻塞队列LinkedTransferQueue，JDK7才提供了这个类,此队列也是基于链表的，对于所有给定的生产者都是先入先出的
//        TransferQueue<String> queue = new LinkedTransferQueue<String>();
//        Thread producer = new Thread(new Producer(queue));
//        producer.setDaemon(true); //设置为守护进程使得线程执行结束后程序自动结束运行
//        producer.start();
//        for (int i = 0; i < 10; i++) {
//            Thread consumer = new Thread(new Consumer(queue));
//            consumer.setDaemon(true);
//            consumer.start();
//            try {
//                // 消费者进程休眠一秒钟，以便生产者获得CPU，从而生产产品
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
