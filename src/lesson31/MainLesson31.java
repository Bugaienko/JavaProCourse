package lesson31;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 *  JavaPro. Lesson #31
 *
 * @author Sergii Bugaienko
 * @version 02.03.2023
 */

public class MainLesson31 {
    public static void main(String[] args) {
        // get Class object #1
        String s = "Java";
        Class stringClass = s.getClass();

        // get Class object #2
        Class strClass = String.class;
        Class intClass = int.class;
        Class voidClass = void.class;


        //output
        System.out.println(stringClass.getName());
        System.out.println(stringClass.getSimpleName());
        System.out.println(strClass.getName());
        System.out.println(intClass.getName());
        System.out.println(voidClass.getName());
        System.out.println();

        Class catClass = Cat.class;
        System.out.println(catClass.getName());
        System.out.println("super class " + catClass.getSuperclass().getName());
        int mod = catClass.getModifiers();
        if (Modifier.isPublic(mod)) {
            System.out.println("Public");
        }

        if (Modifier.isAbstract(mod)) {
            System.out.println("Abstract");
        }

        if (Modifier.isFinal(mod)) {
            System.out.println("Final");
        }

        System.out.println("public Fields class Cat");
        Field[] fields = catClass.getFields();
        for (Field f: fields) {
            System.out.println(f.getName() + " : " + f.getType());
        }

        System.out.println("declare Fields class");
        Field[] fieldsDecl = catClass.getDeclaredFields();
        for (Field f: fieldsDecl) {
            System.out.println(f.getName() + " : " + f.getType());
        }



    }
}
