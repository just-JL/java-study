package designPattern.adapter.classAdapter;

/**
 * author:jiliang
 * Date:2019/2/26
 * Time:19:06
 */
public class Banner {

    private String str;

    public Banner (String str){
        this.str = str;
    }

    public void showWithParen(){
        System.out.println("(" + str + ")");
    }

    public void showWithAster(){
        System.out.println("*" + str + "*");
    }
}
