package annotation;

import lombok.Data;

/**
 * author:jiliang
 * Date:2019/1/10
 * Time:20:02
 */
@Data
public class Person {
    @PersonName("计亮")
    private String name;
    @PersonDesc(desc = "帅得很明显")
    private String desc;
}
