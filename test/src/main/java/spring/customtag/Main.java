package spring.customtag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:jiliang
 * @Date:2019/4/5
 * @Time:14:17
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("customtag.xml");
        User user = (User) bf.getBean("testbean");
        System.out.println(user.getUserName() + "," + user.getEmail());
    }
}
