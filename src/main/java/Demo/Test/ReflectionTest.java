package Demo.Test;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by fx on 2017/12/7.
 */
public class ReflectionTest {





    public ReflectionTest() throws ClassNotFoundException {

        Class cla = Class.forName("javax.swing.JFrame");


        Method[] methods = cla.getDeclaredMethods();

        for (Method method:methods){
            System.out.println(method.toString());
        }
        System.out.println("**************");

        Field[] fields = cla.getDeclaredFields();

        for (Field field : fields){

            System.out.println(field.toString());
        }



    }

    public static  void  main(String[] args) throws ClassNotFoundException {
        new ReflectionTest();
    }
}
