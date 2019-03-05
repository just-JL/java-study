package designPattern.event;

/**
 * author:jiliang
 * Date:2018/12/26
 * Time:10:13
 */
public class TestDemo {
    DemoSource ds;
    public TestDemo(){
        try{
            ds = new DemoSource();
            //将监听器在事件源对象中登记：
            DemoListener1 listener1 = new DemoListener1();
            ds.addDemoListener(listener1);
            ds.addDemoListener(new DemoListener() {
                @Override
                public void handleEvent(DemoEvent event) {
                    System.out.println("Method come from 匿名类...");
                }
            });
            ds.notifyDemoEvent();//触发事件、通知监听器
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new TestDemo();
    }
}

