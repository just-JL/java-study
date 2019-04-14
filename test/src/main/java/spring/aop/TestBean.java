package spring.aop;

/**
 * @author:jiliang
 * @Date:2019/4/14
 * @Time:13:06
 */
public class TestBean {
    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test(){
        System.out.println("test");
    }
}
