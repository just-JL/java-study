package collection;

import java.util.AbstractQueue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * author:jiliang
 * Date:2019/3/11
 * Time:21:33
 */
public class Queue {

    public static ArrayBlockingQueue arrayBlockingQueue1 = new ArrayBlockingQueue(3);
    public static ArrayBlockingQueue arrayBlockingQueue2 = new ArrayBlockingQueue(3);

    public static void main(String[] args){
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

        System.out.println((Human)arrayBlockingQueue2.peek());
        System.out.println((Human)arrayBlockingQueue2.element());
        System.out.println(((Human)arrayBlockingQueue2.peek()).getName());
//        System.out.println(((Human)arrayBlockingQueue2.peek()).getName());
        System.out.println(((Human)arrayBlockingQueue2.element()).getName());



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
