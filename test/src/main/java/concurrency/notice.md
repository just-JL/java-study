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

## 2.1 JMM

![](https://user-gold-cdn.xitu.io/2018/4/30/16315b2410a9e3eb?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

## 2.2 重排序

![](https://user-gold-cdn.xitu.io/2018/4/30/16315b2b7b2a63e9?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

## 2.3 happens-before

- 程序顺序规则：一个线程中的每个操作，happens-before于该线程中的任意后续操作。

- 监视器锁规则：对一个锁的解锁，happens-before于随后对这个锁的加锁。

- volatile变量规则：对一个volatile域的写，happens-before于任意后续对这个volatile域的读。

- 传递性：如果A happens-before B，且B happens-before C，那么A happens-before C。

- start()规则：如果线程A执行操作ThreadB.start()（启动线程B），那么A线程的ThreadB.start()操作happens-before于线程B中的任意操作。

- join()规则：如果线程A执行操作ThreadB.join()并成功返回，那么线程B中的任意操作happens-before于线程A从ThreadB.join()操作成功返回。

- 程序中断规则：对线程interrupted()方法的调用先行于被中断线程的代码检测到中断时间的发生。

- 对象finalize规则：一个对象的初始化完成（构造函数执行结束）先行于发生它的finalize()方法的开始。

# 三、并发关键字

## 3.1 synchronized

[synchronized简介与优化](https://juejin.im/post/5ae6dc04f265da0ba351d3ff#heading-14)

### 3.1.1 实现

![](https://user-gold-cdn.xitu.io/2018/4/30/16315cc79aaac173?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

### 3.1.2 对象锁（monitor）机制

```java
public class SynchronizedDemo {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static void method() {
    }
}

```

``javac``后使用``javap -v SynchronizedDemo.class``，查看字节码文件。

![](https://user-gold-cdn.xitu.io/2018/4/30/16315cce259af0d2?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

执行同步代码块后首先要先执行**monitorenter**指令，退出的时候**monitorexit**指令。执行静态同步方法的时候就只有一条monitorexit指令，并没有monitorenter获取锁的指令。这就是**锁的重入性**，即在同一锁程中，线程不需要再次获取同一把锁。Synchronized先天具有重入性。**每个对象拥有一个计数器，当线程获取该对象锁后，计数器就会加一，释放锁后就会将计数器减一**。

### 3.1.3 优化

[优化](https://www.cnblogs.com/paddix/p/5405678.html)

问题：synchronized在同一时刻只有一个线程能够获得对象的监视器（monitor），从而进入到同步代码块或者同步方法之中，即表现为**互斥性（排它性）**。这种方式肯定效率低下，每次只能通过一个线程。

方案：使用轻量级锁和偏向锁对synchronized进行优化，减少获得锁和释放锁所带来的性能消耗

| 锁       | 优点                                                         | 缺点                                             | 适用场景                             |
| -------- | ------------------------------------------------------------ | ------------------------------------------------ | ------------------------------------ |
| 偏向锁   | 加锁和解锁不需要额外的消耗，和执行非同步方法比仅存在纳秒级的差距。 | 如果线程间存在锁竞争，会带来额外的锁撤销的消耗。 | 适用于只有一个线程访问同步块场景。   |
| 轻量级锁 | 竞争的线程不会阻塞，提高了程序的响应速度。                   | 如果始终得不到锁竞争的线程使用自旋会消耗CPU。    | 追求响应时间。同步块执行速度非常快。 |
| 重量级锁 | 线程竞争不使用自旋，不会消耗CPU。                            | 线程阻塞，响应时间缓慢。                         | 追求吞吐量。同步块执行速度较长。     |

> 锁的状态总共有四种：无锁状态、偏向锁、轻量级锁和重量级锁。随着锁的竞争，锁可以从偏向锁升级到轻量级锁，再升级的重量级锁（但是锁的升级是单向的，也就是说只能从低到高升级，不会出现锁的降级）。JDK 1.6中默认是开启偏向锁和轻量级锁的，我们也可以通过-XX:-UseBiasedLocking来禁用偏向锁































