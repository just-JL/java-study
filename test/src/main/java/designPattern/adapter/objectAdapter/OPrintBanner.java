package designpattern.adapter.objectAdapter;


import designpattern.adapter.classAdapter.Banner;

/**
 * author:jiliang
 * Date:2019/2/26
 * Time:19:29
 */
public class OPrintBanner extends OPrint {
    private Banner banner;
    public OPrintBanner(String str) {
        this.banner = new Banner(str);
    }

    @Override
    public void oprintWeak() {
        banner.showWithParen();
    }

    @Override
    public void oprintStrong() {
        banner.showWithAster();
    }
}
