package designPattern.factory;

import designPattern.factory.framework.Product;
import designPattern.factory.idcard.IDCard;
import designPattern.factory.idcard.IDCardFactory;

/**
 * author:jiliang
 * Date:2019/3/9
 * Time:15:03
 */
public class Main {

    public static void main(String[] args) {
        IDCardFactory factory = new IDCardFactory();
        Product card1 = factory.create("jj");
        Product card2 = factory.create("ll");

//        IDCard idCard = new IDCard("a");

        card1.use();
        card2.use();

        System.out.println(factory.getOwners());
    }
}
