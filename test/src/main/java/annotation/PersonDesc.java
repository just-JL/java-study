package annotation;

import java.lang.annotation.*;

/**
 * author:jiliang
 * Date:2019/1/10
 * Time:19:30
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface PersonDesc {

    String desc() default "是一个好人3_3";
}
