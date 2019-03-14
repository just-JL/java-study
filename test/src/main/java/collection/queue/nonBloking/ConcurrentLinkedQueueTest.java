package collection.queue.nonBloking;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:jiliang
 * @Date:2019/3/14
 * @Time:21:31
 */
public class ConcurrentLinkedQueueTest {

    public static int threadCount = 100000;

    //ConcurrentLinkedQueue是一个基于链接节点的无界线程安全队列，它采用先进先出的规则对节点进行排序，
    // 当我们添加一个元素的时候，它会添加到队列的尾部；当我们获取一个元素时，它会返回队列头部的元素
    //https://blog.csdn.net/sunxianghuang/article/details/52046150
    public static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();

    public static void main(String[] agrs) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int x=0;x<threadCount;x++){
            executorService.submit(new Offer());
            executorService.submit(new Poll());
        }
        executorService.shutdown();
    }

    static class Offer implements Runnable {
        @Override
        public void run() {
            //使用isEmpty()性能更好
            if(queue.isEmpty()){
//            if(queue.size()==0){
                String ele = new Random().nextInt(Integer.MAX_VALUE)+"";
                queue.offer(ele);
                System.out.println("入队元素为"+ele);
            }
        }

    }

    static class Poll implements Runnable {
        @Override
        public void run() {
            if(!queue.isEmpty()){
                String ele = queue.poll();
                System.out.println("出队元素为"+ele);
            }
        }

    }
}
