package collection.queue.blocking;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * author:jiliang
 * Date:2019/3/12
 * Time:21:57
 */
public class DelayQueueTest {

    public static void main(String[] args) {
        //（基于PriorityQueue来实现的）是一个存放Delayed 元素的无界阻塞队列，只有在延迟期满时才能从中提取元素。
        // 该队列的头部是延迟期满后保存时间最长的 Delayed 元素。如果延迟都还没有期满，则队列没有头部，并且poll将返回null。
        // 当一个元素的 getDelay(TimeUnit.NANOSECONDS) 方法返回一个小于或等于零的值时，则出现期满，poll就以移除这个元素了。
        // 此队列不允许使用 null 元素
        //https://www.cnblogs.com/shamo89/p/7055039.html
        DelayQueue delayQueue = new DelayQueue();

        delayQueue.add(new Delayed() {
            @Override
            public long getDelay(TimeUnit unit) {
                return 0;
            }

            @Override
            public int compareTo(Delayed o) {
                return 0;
            }
        });

        System.out.println(delayQueue.toString());

    }
}
