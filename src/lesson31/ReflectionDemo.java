package lesson31;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Sergii Bugaienko
 */

public class ReflectionDemo {
    public static void main(String[] args) {
        Cat cat = new Cat("Vasya", 5);
        System.out.println(cat);

        try {
            Field field = cat.getClass().getField("name");
            field.set(cat, "Barsik");
            Field field1 = cat.getClass().getDeclaredField("account");
            field1.setAccessible(true);
            field1.set(cat, "Hello");
            System.out.println(cat);

            //TODO Вызов метода объекта класса
            Method method = cat.getClass().getMethod("voice");
            method.invoke(cat);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
