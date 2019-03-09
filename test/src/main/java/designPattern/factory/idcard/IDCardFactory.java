package designPattern.factory.idcard;

import designPattern.factory.framework.Factory;
import designPattern.factory.framework.Product;
import designPattern.factory.idcard.IDCard;

import java.util.ArrayList;
import java.util.List;

/**
 * author:jiliang
 * Date:2019/3/9
 * Time:14:59
 */
public class IDCardFactory extends Factory {
    private List owners = new ArrayList();
    private int number = 100;
    @Override
    protected void registerProduct(Product p) {
        owners.add(((IDCard)p).getOwner());
    }

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner, number++);
    }

    public List getOwners(){
        return owners;
    }
}
