package designPattern.chain;

/**
 * @author:jiliang
 * @Date:2019/3/17
 * @Time:20:18
 */
public class Trouble {

    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Trouble{" +
                "number=" + number +
                '}';
    }
}
