package concurrency.threadpool;

/**
 * @author jiliang
 * @date 2018/9/15 17:58
 **/
public class NotThreadSafe {
    StringBuilder builder = new StringBuilder();

    public void add(String text){
        this.builder.append(text);
    }

    @Override
    public String toString() {
        return "NotThreadSafe{" +
                "builder=" + builder +
                '}';
    }
}
