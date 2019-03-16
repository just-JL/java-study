![1182892-20171122100317930-842768608](https://images2017.cnblogs.com/blog/1182892/201711/1182892-20171122100317930-842768608.png)

# Queue

## 基本方法

add        增加一个元素               如果队列已满，则抛出一个IIIegaISlabEepeplian异常
remove     移除并返回队列头部的元素     如果队列为空，则抛出一个NoSuchElementException异常
element    返回队列头部的元素           如果队列为空，则抛出一个NoSuchElementException异常
offer      添加一个元素并返回true       如果队列已满，则返回false
poll       移除并返问队列头部的元素      如果队列为空，则返回null
peek       返回队列头部的元素           如果队列为空，则返回null
put        添加一个元素                如果队列满，则阻塞
take       移除并返回队列头部的元素     如果队列为空，则阻塞

## 基础元素

**AbstractQueue**：add、remove、element、clear、addAll

**BlockingQueue**：add、offer、put、take、poll、remove

**TransferQueue extends BlockingQueue**：tryTransfer、transfer



**ReentrantLock**



**链表**

https://blog.csdn.net/jianyuerensheng/article/details/51200274

数组链表的优缺点： 
数组占用空间小，链表元素还要包涵上一元素和下一个元素的的信息 
数组的访问速度快，因为内存是连续的 
数组内部元素可以随机访问，而链表依赖于上一个元素的信息

链表的插入删除操作由于数组，因为内存不连续，只需要更改元素的前后节点信息就行了，并不需要更改元素内存地址，而数组的连续内存想要插入和删除的话就要移动所有的内存地址 
链表的内存利用率高于数组，链表内存是分散的一个元素占用一块空间，数组元素少于内存空间的话，会有部分的内存浪费； 
链表的扩展性强，数组的创建完成内存大小就确定了，满了就没法扩展只能再次创建新的数组，而链表可以随意的增加扩展

效率：数组查询效率高，链表增，删效率高
https://blog.csdn.net/zhaobo012387/article/details/60869259 

**cas**

https://blog.csdn.net/u013309870/article/details/77658224（参考jvm内存模型）

## 阻塞队列

**ArrayBlockingQueue**：AbstractQueue、BlockingQueue

**LinkedBlockingQueue**：AbstractQueue、BlockingQueue

**LinkedBlockingDeque**：AbstractQueue、BlockingQueue

**LinkedTransferQueue**：AbstractQueue、TransferQueue

**PriorityBlockingQueue**：AbstractQueue、BlockingQueue

**SynchronousQueue**：AbstractQueue、BlockingQueue（使用cas保证安全性，其余阻塞队列均使用了ReentrantLock）

**DelayQueue**：AbstractQueue、BlockingQueue、Delayed



LinkedTransferQueue：https://kkewwei.github.io/elasticsearch_learning/2018/12/15/LinkedTransferQueue%E5%8E%9F%E7%90%86%E8%A7%A3%E8%AF%BB/

LinkedTransferQueue不仅实现了普通BlockingQueue的功能, 另一个优点就是: 当有消费者等待数据时, 生产者可以直接将数据交给消费者而不是再进入队列。 与LinkedBlockingQueue相比, LinkedBlockingQueue在take和put操作时, 都是通过lock来控制, 当高并发操作take和put操作, 锁的获取和释放都是比较影响性能的。 而LinkedTransferQueue对这种使用进行了改进, 当生产者存放数据时, 发现有消费者等待消费数据, 生产者可以调用transfer直接将数据交给消费者, 而不用通过阻塞队列来传递数据, 减少了锁的释放与获取。



DelayQueue：https://www.cnblogs.com/wxgblogs/p/5464867.html

DelayQueue是一个无界阻塞队列，只有在延迟期满时才能从中提取元素。该队列的头部是延迟期满后保存时间最长的Delayed 元素。

　　DelayQueue阻塞队列在我们系统开发中也常常会用到，例如：缓存系统的设计，缓存中的对象，超过了空闲时间，需要从缓存中移出；任务调度系统，能够准确的把握任务的执行时间。我们可能需要通过线程处理很多时间上要求很严格的数据，如果使用普通的线程，我们就需要遍历所有的对象，一个一个的检 查看数据是否过期等，首先这样在执行上的效率不会太高，其次就是这种设计的风格也大大的影响了数据的精度。一个需要12:00点执行的任务可能12:01 才执行,这样对数据要求很高的系统有更大的弊端。由此我们可以使用DelayQueue。

## 非阻塞队列

**ConcurrentLinkedQueue**：AbstractQueue、Queue

**PriorityQueue**：AbstractQueue



PriorityQueue：https://www.cnblogs.com/Elliott-Su-Faith-change-our-life/p/7472265.html

**优先队列的作用是能保证每次取出的元素都是队列中权值最小的**（Java的优先队列每次取最小元素，C++的优先队列每次取最大元素）。这里牵涉到了大小关系，**元素大小的评判可以通过元素本身的自然顺序（natural ordering），也可以通过构造时传入的比较器**（*Comparator*，类似于C++的仿函数）。

Java中*PriorityQueue*实现了*Queue*接口，不允许放入`null`元素；其通过堆实现，具体说是通过完全二叉树（*complete binary tree*）实现的**小顶堆**（任意一个非叶子节点的权值，都不大于其左右子节点的权值），也就意味着可以通过数组来作为*PriorityQueue*的底层实现

# Set

Set集合其实是对Map集合的封装，Map集合存储的是键值对，那么我们将值隐藏，不向外界暴露，这样就形成了Set集合

```
public boolean add(E e) {
    return map.put(e, PRESENT)==null;
}
```

# List

copyOnWrite容器即写时复制的容器。通俗的理解是当我们往一个容器添加元素的时候，不直接往当前容器添加，而是先将当前容器进行Copy，复制出一个新的容器，然后新的容器里添加元素，添加完元素之后，再将原容器的引用指向新的容器。这样做的好处是我们可以对CopyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器

**CopyOnWriteArrayList**：https://www.cnblogs.com/dolphin0520/p/3938914.html

**Vector**：https://blog.csdn.net/qq_19431333/article/details/54908404（相较于ArrayList，使用了synchronized）

**Stack**：https://www.cnblogs.com/sker/p/5768212.html（LIFO，继承Vector，并对其进行了扩展）

![](https://images2015.cnblogs.com/blog/949433/201608/949433-20160813160328953-775148669.png)



# Map

## 基础元素

**哈希表**：根据设定的*Hash函数* - H(key)H(key) 和处理冲突的方法，将一组关键字**映象** 到一个**有限的连续的地址集**（区间）上，并以关键字在地址集中的**象** 作为记录在表中的**存储位置**，这样的映射表便称为**Hash表**。

**红黑树**：

红黑树(Red-Black Tree，简称R-B Tree)，它一种特殊的二叉查找树。
红黑树是特殊的二叉查找树，意味着它满足二叉查找树的特征：任意一个节点所包含的键值，大于等于左孩子的键值，小于等于右孩子的键值。
除了具备该特性之外，红黑树还包括许多额外的信息。

红黑树的每个节点上都有存储位表示节点的颜色，颜色是红(Red)或黑(Black)。
红黑树的特性:
(1) 每个节点或者是黑色，或者是红色。
(2) 根节点是黑色。
(3) 每个叶子节点是黑色。 [注意：这里叶子节点，是指为空的叶子节点！]
(4) 如果一个节点是红色的，则它的子节点必须是黑色的。
(5) 从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。

关于它的特性，需要注意的是：
第一，特性(3)中的叶子节点，是只为空(NIL或null)的节点。
第二，特性(5)，确保没有一条路径会比其他路径长出俩倍。因而，红黑树是相对是接近平衡的二叉树。

红黑树示意图如下：

[![img](https://images0.cnblogs.com/i/497634/201403/251730074203156.jpg)](https://images0.cnblogs.com/i/497634/201403/251730074203156.jpg)

## map

HashMap不保证数据有序，LinkedHashMap保证数据可以保持插入顺序，而如果我们希望Map可以保持key的大小顺序的时候，我们就需要利用TreeMap了



**HashMap**：https://blog.csdn.net/tuke_tuke/article/details/51588156（数组、单向链表、红黑树）

**LinkedHashMap**：https://blog.csdn.net/blingfeng/article/details/79974169（双向链表、红黑树）

**TreeMap**：http://www.importnew.com/19074.html（红黑树）

**HashTable**：https://www.jianshu.com/p/f7563d16426e（数组、单向链表、线程安全、建议根据情况使用HashMap或ConcurrentHashMap替换）

**ConcurrentHashMap**：https://www.cnblogs.com/nullzx/p/8647220.html（

- put方法做了以下几点事情：

  1）如果没有初始化就先调用initTable()方法来进行初始化过程2）如果没有hash冲突就尝试CAS方式插入

  3）如果还在进行扩容操作就先帮助其它线程进一起行扩容

  4）如果存在hash冲突，就加锁来保证put操作的线程安全。

  有意思的是，ConcurrentHashMap中并没有使用ReentrantLock，而是直接使用了synchronized关键字对槽加锁。个人猜测，这样做的原因是避免创建过多的锁对象。如果桶的长度是1024（别问我为啥是这个值，我只是考虑到了它是2的整数次幂，如果你联想到了其它不宜公开讨论的内容，请告诉我地址），那么我们就需要在每个桶的位置上分配一把锁，也就要1024把锁，考虑到每次扩容后都还要重新创建所有的锁对象，这显然是不划算的。

  添加结点操作完成后会调用addCount方法，在addCount方法中会去判断是否需要扩容操作。如果容量超过阀值了，就由这个线程发起扩容操作。如果已经处于扩容状态（sizeCtl < -1），根据剩余迁移的数据和已参加到扩容中的线程数来判断是否需要当前线程来帮助扩容。

- get方法没加锁原因：https://juejin.im/entry/5b98b89bf265da0abd35034c（value值加了volatile，与Node<k,v>加volatile没关系，其是为了扩容时的可见性）

- 1.8为什么放弃分段锁，使用synchronized（1、锁粒度变小，concurrentLevel（并发数）是可增长的  2、ReentrantLock是api级别，优化空间小，synchronized是jvm直接支持的）

  https://my.oschina.net/dabiaoge/blog/1613180

）

**WeakHashMap**：https://blog.csdn.net/u012129558/article/details/51980883（key为弱引用）

https://blog.csdn.net/kaka0509/article/details/73459419（使用场景：tomcat的jvm分代）

































