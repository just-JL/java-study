package designpattern.singleton;

/**
 * @author:jiliang
 * @Date:2019/4/1
 * @Time:21:41
 * @Description 饿汉式（静态代码块）[可用]
 * 将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。
 * 优缺点与singleton1相同
 */
public class Singleton2 {

    private static Singleton2 singleton2;

    private Singleton2(){}

    static{
        singleton2 = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return singleton2;
    }
}
