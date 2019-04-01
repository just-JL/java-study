package designpattern.adapter.classAdapter;

/**
 * author:jiliang
 * Date:2019/2/26
 * Time:19:32
 */
public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("hi");
        p.printWeak();
        p.printStrong();
    }
}
