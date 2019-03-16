package collection.queue.blocking;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * author:jiliang
 * Date:2019/3/12
 * Time:23:25
 */
public class LinkedBlockingDequeTest {

    public static void main(String[] args) throws Exception{
        //这是一个只能一端出一端入的单向队列结构，是有FIFO特性的，并且是通过两个ReentrantLock和两个Condition来实现的
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();

        linkedBlockingDeque.offer(1);
        linkedBlockingDeque.offer("jl");

        System.out.println(linkedBlockingDeque.toString());
        linkedBlockingDeque.offerFirst("2");
        System.out.println(linkedBlockingDeque.toString());
        linkedBlockingDeque.takeLast();
        System.out.println(linkedBlockingDeque.toString());

    }
}
