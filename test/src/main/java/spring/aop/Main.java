package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:jiliang
 * @Date:2019/4/14
 * @Time:13:25
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("aspectTest.xml");
        TestBean bean = (TestBean) bf.getBean("test");
        bean.test();
    }
}
