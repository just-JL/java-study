![1182892-20171122100317930-842768608](C:\Users\jiliang\Desktop\1182892-20171122100317930-842768608.png)

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