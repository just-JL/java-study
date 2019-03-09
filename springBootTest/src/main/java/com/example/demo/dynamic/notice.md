从otter扒下来的动态编译外部java文件，并加载执行的代码

![1552108814445](https://github.com/aBlackAnt/images/blob/master/1552108814445.png?raw=true)

**存在的问题：**

如果需要编译的外部类有父类或实现了接口，本地main方法执行ok，但在打成jar包执行时会异常，提示父类或接口找不到，原因未明。

