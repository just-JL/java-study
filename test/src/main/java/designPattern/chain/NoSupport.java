package designpattern.chain;

/**
 * @author:jiliang
 * @Date:2019/3/17
 * @Time:20:27
 */
public class NoSupport extends Support {
    public NoSupport(String name){
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
