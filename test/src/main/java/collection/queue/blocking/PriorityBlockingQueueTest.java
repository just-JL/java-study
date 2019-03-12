package collection.queue.blocking;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * author:jiliang
 * Date:2019/3/12
 * Time:21:45
 */
public class PriorityBlockingQueueTest {

    public static void main(String[] args) {
        //是一个带优先级的 队列，而不是先进先出队列。元素按优先级顺序被移除，该队列也没有上限
        // （看了一下源码，PriorityBlockingQueue是对 PriorityQueue的再次包装，是基于堆数据结构的，
        // 而PriorityQueue是没有容量限制的，与ArrayList一样，所以在优先阻塞 队列上put时是不会受阻的。
        // 虽然此队列逻辑上是无界的，但是由于资源被耗尽，所以试图执行添加操作可能会导致 OutOfMemoryError），
        // 但是如果队列为空，那么取元素的操作take就会阻塞，所以它的检索操作take是受阻的。另外，加入该队列中的元素要具有比较能力
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();

        priorityBlockingQueue.add(1);
//        priorityBlockingQueue.add("jj");

        for (int i=0; i<11; i++){
            priorityBlockingQueue.add(i);
        }

        System.out.println(priorityBlockingQueue.toString());

        for (int i=0; i<11; i++){
            priorityBlockingQueue.poll();
        }
        System.out.println(priorityBlockingQueue.toString());

    }
}
