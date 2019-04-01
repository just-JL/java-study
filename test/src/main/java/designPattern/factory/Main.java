package designpattern.factory;

import designpattern.factory.framework.Factory;
import designpattern.factory.framework.Product;
import designpattern.factory.idcard.IDCardFactory;

/**
 * author:jiliang
 * Date:2019/3/9
 * Time:15:03
 */
public class Main {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("jj");
        Product card2 = factory.create("ll");

//        IDCard idCard = new IDCard("a");

        card1.use();
        card2.use();
    }
}
