package designPattern.chain;

/**
 * @author:jiliang
 * @Date:2019/3/17
 * @Time:20:28
 */
public class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 == 1){
            return true;
        }
        else {
            return false;
        }
    }
}
