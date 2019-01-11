package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * author:jiliang
 * Date:2019/1/10
 * Time:19:29
 */
@Retention(RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface PersonName {

    String value() default "";
}
