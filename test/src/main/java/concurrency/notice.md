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

## 3.2 volatile

[彻底理解volatile](https://juejin.im/post/5ae9b41b518825670b33e6c4#heading-3)

### 3.2.1 实现原理

在生成汇编代码时会在volatile修饰的共享变量进行写操作的时候会多出**Lock前缀的指令**，作用如下：

1. 将当前处理器缓存行的数据写回系统内存；
2. 这个写回内存的操作会使得其他CPU里缓存了该内存地址的数据无效

### 3.2.2 volatile的内存语义实现

为了性能优化，JMM在不改变正确语义的前提下，会允许编译器和处理器对指令序列进行重排序，那如果想阻止重排序要怎么办了？答案是可以添加**内存屏障**。

![](https://user-gold-cdn.xitu.io/2018/5/2/16320e796e1471c0?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

**StoreStore屏障**：禁止上面的普通写和下面的volatile写重排序；

**StoreLoad屏障**：防止上面的volatile写与下面可能有的volatile读/写重排序

**LoadLoad屏障**：禁止下面所有的普通读操作和上面的volatile读重排序

**LoadStore屏障**：禁止下面所有的普通写操作和上面的volatile读重排序

![](https://user-gold-cdn.xitu.io/2018/5/2/16320e796e03b351?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

![](https://user-gold-cdn.xitu.io/2018/5/2/16320e799b76d34c?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

### 3.2.3 为什么不能保证原子性

详见：[为什么volatile不能保证原子性](https://www.cnblogs.com/rainwang/p/4398488.html)

**volatile可以保证可见性和有序性，但不能保证原子性。**

原因：

例如你让一个volatile的integer自增（i++），其实要分成3步：1）读取volatile变量值到local； 2）增加变量的值；3）把local的值写回，让其它的线程可见。这3步的jvm指令为：

```
mov        0xc(%r10),%r8d ; Load
inc        %r8d           ; Increment
mov    %r8d,``0xc``(%r10) ; Store
lock addl $``0x0``,(%rsp) ; StoreLoad Barrier
```

从Load到store到内存屏障，一共4步，其中最后一步jvm让这个最新的变量的值在所有线程可见，也就是最后一步让所有的CPU内核都获得了最新的值，但**中间的几步（从Load到Store）**是不安全的，中间如果其他的CPU修改了值将会丢失。所以为了保证原子性，需要对**Increment**，加锁(synchronized或lock)或使用原子类**AtomicXXX**。

## 3.3 final

[你以为你真的了解final吗](https://juejin.im/post/5ae9b82c6fb9a07ac3634941)

[final和线程安全](http://www.cnblogs.com/mianlaoshu/articles/3648403.html)

看了还是不了解~~，只是对成员变量（static修饰的类变量、实例变量）、局部变量，final的基础使用加深了印象。

硬着头皮总结几点：

- 当构造函数结束时，final类型的值是被保证其他线程访问该对象时，它们的值是可见的，若没有用final修饰，则会进行重排序。
- 在构造函数，不能让这个被构造的对象被其他线程可见，也就是说该对象引用不能在构造函数中“逸出”。

>Q：如何不使用任何锁，任何线程安全的容器怎么实现线程安全
>
>A：使用volatile和cas 或其他？（思路：参考线程安全容器底层实现？）

# 四、Lock体系

从整体上来看concurrent包的整体实现图如下图所示：

![](https://user-gold-cdn.xitu.io/2018/5/3/163260cff7cb847c?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

## 4.1 AQS

[深入理解AbstractQueuedSynchronizer(AQS)](https://juejin.im/post/5aeb07ab6fb9a07ac36350c8#heading-3)

使用的数据结构是：具有**头结点的双向链表**

AQS的核心包括了这些方面:

**同步队列，独占式锁的获取和释放，共享锁的获取和释放以及可中断锁，超时等待锁获取这些特性的实现**。

### 4.1.1 同步队列

1. 节点的数据结构，即AQS的静态内部类Node,节点的等待状态等信息；
2. 同步队列是一个双向队列，AQS通过持有头尾指针管理同步队列；

节点的入队出队对应着锁的获取和释放两个操作：获取锁失败进行入队操作，获取锁成功进行出队操作

### 4.1.2 独占锁

#### 4.1.2.1 独占锁获取（acquire方法）

1. 在当前线程是第一个加入同步队列时，调用compareAndSetHead(new Node())方法，完成链式队列的头结点的初始化；
2. 自旋不断尝试CAS尾插入节点直至成功为止。
3. 如果先驱节点是头结点的并且成功获得同步状态的时候（if (p == head && tryAcquire(arg))），当前节点所指向的线程能够获取锁，否则线程进入等待状态等待获取独占式锁

![](https://user-gold-cdn.xitu.io/2018/5/3/163261637c891cc2?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

#### 4.1.2.2 独占锁释放（release()方法）

​	首先获取头节点的后继节点，当后继节点的时候会调用LookSupport.unpark()方法，该方法会唤醒该节点的后继节点所包装的线程。因此，**每一次锁释放后就会唤醒队列中该节点的后继节点所引用的线程，从而进一步可以佐证获得锁的过程是一个FIFO（先进先出）的过程**

#### 4.1.2.3 可中断式获取锁（acquireInterruptibly方法）， 超时等待式获取锁（tryAcquireNanos()方法）

略

### 4.1.3 共享锁

#### 4.1.3.1 共享锁获取

略

#### 4.1.3.2 共享锁释放

略

#### 4.1.3.3 可中断（acquireSharedInterruptibly()方法），超时等待（tryAcquireSharedNanos()方法）

略

## 4.2 ReentrantLock

[彻底理解ReentrantLock](https://juejin.im/post/5aeb0a8b518825673a2066f0)

​	ReentrantLock重入锁，是实现Lock接口的一个类，也是在实际编程中使用频率很高的一个锁，**支持重入性，表示能够对共享资源能够重复加锁，即当前线程获取该锁再次获取不会被阻塞**。在java关键字synchronized隐式支持重入性，synchronized通过获取自增，释放自减的方式实现重入。与此同时，ReentrantLock还支持**公平锁和非公平锁**两种方式。

1. 重入性的实现原理；

   ```java
   final boolean nonfairTryAcquire(int acquires) {
       final Thread current = Thread.currentThread();
       int c = getState();
       //1. 如果该锁未被任何线程占有，该锁能被当前线程获取
   	if (c == 0) {
           if (compareAndSetState(0, acquires)) {
               setExclusiveOwnerThread(current);
               return true;
           }
       }
   	//2.若被占有，检查占有线程是否是当前线程
       else if (current == getExclusiveOwnerThread()) {
   		// 3. 再次获取，计数加一
           int nextc = c + acquires;
           if (nextc < 0) // overflow
               throw new Error("Maximum lock count exceeded");
           setState(nextc);
           return true;
       }
       return false;
   }
   
   ```

2.  公平锁和非公平锁。

   **公平锁每次都是从同步队列中的第一个节点获取到锁，而非公平性锁则不一定，有可能刚释放锁的线程能再次获取到锁**。

   > ​	a.公平锁每次获取到锁为同步队列中的第一个节点，**保证请求资源时间上的绝对顺序**，而非公平锁有可能刚释放锁的线程下次继续获取该锁，则有可能导致其他线程永远无法获取到锁，**造成“饥饿”现象**。
   >
   > ​	b.公平锁为了保证时间上的绝对顺序，需要频繁的上下文切换，而非公平锁会降低一定的上下文切换，降低性能开销。因此，ReentrantLock默认选择的是非公平锁，则是为了减少一部分上下文切换，**保证了系统更大的吞吐量**。













































