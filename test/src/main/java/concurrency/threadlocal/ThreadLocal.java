package concurrency.threadlocal;

/**
 * @author jiliang
 * @date 2018/9/17 23:19
 **/
public class ThreadLocal {
    java.lang.ThreadLocal<Long> longLocal = new java.lang.ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return Thread.currentThread().getId();
        };
    };
    java.lang.ThreadLocal<String> stringLocal = new java.lang.ThreadLocal<String>(){;
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        };
    };

//    java.lang.ThreadLocal<Long> longLocal = new java.lang.ThreadLocal<Long>();
//    java.lang.ThreadLocal<String> stringLocal = new java.lang.ThreadLocal<String>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocal test = new ThreadLocal();

        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());


        Thread thread1 = new Thread(){
            @Override
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
