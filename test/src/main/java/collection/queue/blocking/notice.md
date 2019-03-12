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