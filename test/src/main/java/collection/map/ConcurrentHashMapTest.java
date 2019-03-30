package collection.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:jiliang
 * @Date:2019/3/16
 * @Time:18:01
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap();
        for (int i = 0; i < 10000; i++){
            concurrentHashMap.put(i, "aa");
        }
    }
}
