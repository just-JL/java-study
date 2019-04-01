package designpattern.adapter.classAdapter;

/**
 * author:jiliang
 * Date:2019/2/26
 * Time:19:29
 */
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String str) {
        super(str);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
