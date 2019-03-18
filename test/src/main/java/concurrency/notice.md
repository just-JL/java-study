# 一、基础知识

**线程生命周期**：

![](https://user-gold-cdn.xitu.io/2018/4/30/163159bceb956cb4?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

**yield**：

​	public static native void yield();这是一个静态方法，一旦执行，它会是当前线程让出CPU，但是，需要注意的是，让出的CPU并不是代表当前线程不再运行了，如果在下一次竞争中，又获得了CPU时间片当前线程依然会继续运行。另外，让出的时间片只会分配**给当前线程相同优先级**的线程。

​	sleep()和yield()方法，同样都是当前线程会交出处理器资源，而它们不同的是，sleep()交出来的时间片其他线程都可以去竞争，也就是说都有机会获得当前线程让出的时间片。而yield()方法只允许与当前线程具有相同优先级的线程能够获得释放出来的CPU时间片。

> 详见：[线程的状态转换以及基本操作](https://juejin.im/post/5ae6cf7a518825670960fcc2)

**销毁线程**：

```java
public class ThreadSafe extends Thread {
    public void run() { 
        while (!isInterrupted()){ //非阻塞过程中通过判断中断标志来退出
            try{
                Thread.sleep(5*1000);//阻塞过程捕获中断异常来退出
            }catch(InterruptedException e){
                e.printStackTrace();
                break;//捕获到异常之后，执行break跳出循环。
            }
        }
    } 
}
```

> 详见：[线程销毁三种方式](https://blog.csdn.net/xu__cg/article/details/52831127)

# 二、并发理论

> 详见：[Java内存模型以及happens-before规则](https://juejin.im/post/5ae6d309518825673123fd0e)

**JMM**：

![](https://user-gold-cdn.xitu.io/2018/4/30/16315b2410a9e3eb?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

**重排序**：

![](https://user-gold-cdn.xitu.io/2018/4/30/16315b2b7b2a63e9?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

**happens-before**：

- 程序顺序规则：一个线程中的每个操作，happens-before于该线程中的任意后续操作。

- 监视器锁规则：对一个锁的解锁，happens-before于随后对这个锁的加锁。

- volatile变量规则：对一个volatile域的写，happens-before于任意后续对这个volatile域的读。

- 传递性：如果A happens-before B，且B happens-before C，那么A happens-before C。

- start()规则：如果线程A执行操作ThreadB.start()（启动线程B），那么A线程的ThreadB.start()操作happens-before于线程B中的任意操作。

- join()规则：如果线程A执行操作ThreadB.join()并成功返回，那么线程B中的任意操作happens-before于线程A从ThreadB.join()操作成功返回。

- 程序中断规则：对线程interrupted()方法的调用先行于被中断线程的代码检测到中断时间的发生。

- 对象finalize规则：一个对象的初始化完成（构造函数执行结束）先行于发生它的finalize()方法的开始。

# 三、并发关键字







































