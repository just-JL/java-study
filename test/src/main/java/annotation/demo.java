package annotation;

import org.apache.rocketmq.remoting.annotation.CFNotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * author:jiliang
 * Date:2019/1/16
 * Time:20:14
 */
public class demo {
    public static void main(String[] args) throws NoSuchFieldException {
        Person person = new Person();
        person.setName("jiliang");

        Field field = Person.class.getDeclaredField("name");
        if (field.isAnnotationPresent(CFNotNull.class)){
            Annotation annotation = field.getAnnotation(CFNotNull.class);

            if(annotation == null){
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }
        }
        if (field.isAnnotationPresent(PersonName.class)){
            Annotation annotation = field.getAnnotation(CFNotNull.class);

            if(annotation == null){
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }
        }

    }
}
