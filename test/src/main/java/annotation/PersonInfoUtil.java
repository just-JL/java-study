package annotation;

import java.lang.reflect.Field;

/**
 * author:jiliang
 * Date:2019/1/10
 * Time:19:43
 */
public class PersonInfoUtil {

    public static void getPersonInfo(Class<?> clazz){

        String strPersonName = "人名：";
        String strPersonDesc = "评价：";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){
            if (field.isAnnotationPresent(PersonName.class)){
                PersonName personName = (PersonName) field.getAnnotation(PersonName.class);
                strPersonName += personName.value();
                System.out.println(strPersonName);
            }
            else if(field.isAnnotationPresent(PersonDesc.class)){
                PersonDesc personDesc = (PersonDesc) field.getAnnotation(PersonDesc.class);
                strPersonDesc += personDesc.desc();
                System.out.println(strPersonDesc);
            }
        }
    }

    public static void main(String[] args) {
        PersonInfoUtil.getPersonInfo(Person.class);
    }
}
