package concurrency.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo {
//    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static AtomicInteger i = new AtomicInteger();
    private static AtomicInteger j = new AtomicInteger();
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 15; i++) {
            executorService.submit(new DateUtil("2019-11-25 09:00:" + i % 60));
        }
    }

    static class DateUtil implements Runnable {

        private String date;
        public DateUtil(String date) {
            this.date = date;
        }

        private static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>();
        private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

        @Override
        public void run() {
            if (sdf.get() == null) {
                sdf.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                threadLocal.set("aa");
                try {
                    System.out.println("===>" + sdf.hashCode() + "~~" + threadLocal.get());
                    Date date = sdf.get().parse(this.date);
                    System.out.println(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                sdf.set(new SimpleDateFormat("yyyy-MM-dd"));
                threadLocal.set("bb");
                try {
                    System.out.println("--->" + sdf.hashCode() + "~~" + threadLocal.get());
                    Date date = sdf.get().parse(this.date);
                    System.out.println(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

//            try {
//                System.out.println("--->" + sdf.hashCode());
//                Date date = sdf.parse(this.date);
//                System.out.println(date);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
        }
    }
}
