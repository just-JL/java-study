package collection.map;

import java.util.LinkedHashMap;

/**
 * @author:jiliang
 * @Date:2019/3/16
 * @Time:18:01
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();

        linkedHashMap.put(1,"a");
        linkedHashMap.put(3,"a");
        linkedHashMap.put(2,"a");

        System.out.println(linkedHashMap.toString());
    }
}
