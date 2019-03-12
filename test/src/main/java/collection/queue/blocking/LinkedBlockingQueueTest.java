package collection.queue.blocking;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * author:jiliang
 * Date:2019/3/12
 * Time:21:22
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        //容量是没有上限的（说的不准确，在不指定时容量为Integer.MAX_VALUE，不要然的话在put时怎么会受阻呢），
        // 但是也可以选择指定其最大容量，它是基于链表的队列，此队列按 FIFO（先进先出）排序元素
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

        linkedBlockingQueue.add(1);
        linkedBlockingQueue.add("jj");

        System.out.println(linkedBlockingQueue.toString());

        linkedBlockingQueue.poll();

        System.out.println(linkedBlockingQueue.toString());

    }
}
