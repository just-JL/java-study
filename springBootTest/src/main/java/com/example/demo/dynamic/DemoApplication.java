package com.example.demo.dynamic;

import com.example.demo.dynamic.compile.impl.JdkCompiler;
import com.example.demo.dynamic.compile.model.JavaSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);

        //读取jar包同级目录文件
        File file = new File(args[0]);
//        File file = new File("C:\\Users\\jiliang\\Desktop\\TestPenWrite.java");
        String str = file2String(file);
        System.out.println(str);
        Class<?> clazz = null;
        JavaSource javaSource = new JavaSource(str);

        JdkCompiler jdkCompiler = new JdkCompiler();
        clazz = jdkCompiler.compile(javaSource);

        System.out.println("=====" + clazz.getName() + "=====");
        System.out.println(clazz.newInstance().toString());

        Method method = clazz.getDeclaredMethod("write", String.class);
        method.invoke(clazz.newInstance(), "xixi");


    }

    private static String jsonRead(File file) {
        Scanner scanner = null;
        StringBuilder buffer = new StringBuilder();
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }
        } catch (Exception e) {

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return buffer.toString();
    }

    private static String file2String(File file) {
        StringBuffer sb = new StringBuffer();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(fileReader);

            LineNumberReader reader = new LineNumberReader(bufReader);

            String line;

            try {
                while ((line = reader.readLine()) != null) {

                    sb.append(line).append(System.getProperty("line.separator"));

                }
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return sb.toString();

//        StringBuffer fileData = new StringBuffer();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            char[] buf = new char[1024];
//            int numRead = 0;
//            while ((numRead = reader.read(buf)) != -1) {
//                String readData = String.valueOf(buf, 0, numRead);
//                fileData.append(readData);
//            }
//            //缓冲区使用完必须关掉
//            reader.close();
//        } catch (Exception e) {
//
//        }
//        return fileData.toString();

    }
}
