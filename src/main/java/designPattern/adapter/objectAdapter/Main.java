package designPattern.adapter.objectAdapter;

import designPattern.adapter.classAdapter.Print;
import designPattern.adapter.classAdapter.PrintBanner;

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
