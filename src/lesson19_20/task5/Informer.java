package lesson19_20.task5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public abstract class Informer {
    public static void printInfo(Class aClass) {
        System.out.println(nameInfo(aClass));
        System.out.println(packageInfo(aClass));
        System.out.println(superClassInfo(aClass));
        System.out.println(interfacesInfo(aClass));
        System.out.println(fieldsInfo(aClass));
        System.out.println(constructorsInfo(aClass));
        System.out.println(methodsInfo(aClass));
    }

    public static String nameInfo(Class c) {
        return "Класс: " + c.getSimpleName() + "\n";
    }

    public static String packageInfo(Class c) {
        return "Пакет: " + c.getPackage().getName() + "\n";
    }

    public static String fieldsInfo(Class c) {
        StringBuilder sb = new StringBuilder("Поля:\n");
        for (Field field : c.getDeclaredFields()) {
            sb.append(String.format("%s %s %s\n",
                    Modifier.toString(field.getModifiers()),
                    field.getType().getSimpleName(),
                    field.getName()
            ));
        }
        return sb.toString();
    }

    public static String constructorsInfo(Class c) {
        StringBuilder sb = new StringBuilder("Конструкторы:\n");
        for (Constructor constructor : c.getDeclaredConstructors()) {
            List<String> parTypeList = new ArrayList<>();
            for (Class aClass : constructor.getParameterTypes()) {
                parTypeList.add(aClass.getSimpleName());
            }
            sb.append(String.format("%s %s(",
                    Modifier.toString(constructor.getModifiers()),
                    constructor.getDeclaringClass().getSimpleName()
            ));
            sb.append(String.join(", ", parTypeList));
            sb.append(")\n");
        }
        return sb.toString();
    }

    public static String methodsInfo(Class c) {
        StringBuilder sb = new StringBuilder("Методы:\n");
        for (Method method : c.getDeclaredMethods()) {
            List<String> parTypeList = new ArrayList<>();
            for (Class aClass : method.getParameterTypes()) {
                parTypeList.add(aClass.getSimpleName());
            }
            sb.append(String.format("%s %s %s(",
                    Modifier.toString(method.getModifiers()),
                    method.getReturnType().getSimpleName(),
                    method.getName()
            ));
            sb.append(String.join(", ", parTypeList));
            sb.append(")\n");
        }
        return sb.toString();
    }

    public static String superClassInfo(Class c) {
        return "Суперкласс: " + c.getSuperclass().getCanonicalName() + "\n";
    }

    public static String interfacesInfo(Class c) {
        StringBuilder sb = new StringBuilder("Реализованные интерфейсы:\n");
        Class[] interfaces = c.getInterfaces();
        if (interfaces.length == 0) {
            return sb.toString() + "Нет\n";
        }
        for (Class aClass : c.getInterfaces()) {
            sb.append(aClass.getSimpleName());
            sb.append("\n");
        }
        return sb.toString();
    }
}
