package designPattern.factory.framework;

/**
 * author:jiliang
 * Date:2019/3/9
 * Time:14:53
 */
public abstract class Factory {
    
    public final Product create(String owner){
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract void registerProduct(Product p);

    protected abstract Product createProduct(String owner);
}
