package designPattern.factory.idcard;

import designPattern.factory.framework.Product;

/**
 * author:jiliang
 * Date:2019/3/9
 * Time:14:56
 */
public class IDCard extends Product {
    private String owner;
    private int number;

    IDCard(String owner, int number){
        System.out.println("制作" + owner + "的ID卡，卡号为" + number);
        this.owner = owner;
        this.number = number;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡, 卡号为" + number);
    }

    public String getOwner(){
        return owner;
    }

    public int getNumber() {
        return number;
    }
}
