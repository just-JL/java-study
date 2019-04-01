package designpattern.adapter.objectAdapter;

/**
 * author:jiliang
 * Date:2019/2/26
 * Time:19:32
 */
public class Main {
    public static void main(String[] args) {
        OPrint p = new OPrintBanner("hi");
        p.oprintWeak();
        p.oprintStrong();
    }
}
