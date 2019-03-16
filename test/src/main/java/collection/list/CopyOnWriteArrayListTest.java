package collection.list;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author:jiliang
 * @Date:2019/3/16
 * @Time:16:39
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList();

        list.add(1);
        list.add(2);

        System.out.println(list.get(1));
    }
}
