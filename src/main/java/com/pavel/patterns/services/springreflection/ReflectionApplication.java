package com.pavel.patterns.services.springreflection;


import com.pavel.patterns.services.springreflection.di.SpringConfig;
import com.pavel.patterns.services.springreflection.services.car.Car;
import com.pavel.patterns.services.springreflection.services.car.CarInterface;
import com.pavel.patterns.services.springreflection.services.wheel.Wheel;
import com.pavel.patterns.services.springreflection.services.wheel.WheelInterface;
import org.reflections.Reflections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ReflectionApplication {

    public static void main(String[] args) {

        //Подготовка DI
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // Получаем машину
        CarInterface car = context.getBean(Car.class);

        car.move();


        //Примеры рефлексии

        // Использование объекта Reflections
        Reflections reflections = new Reflections("com.pavel.patterns.services.springreflection.services");

        // Выводим все реализации интерфейса WheelInterface
        System.out.println(reflections.getSubTypesOf(WheelInterface.class));

        //Использование Java Reflection API
        System.out.println(Car.class.getDeclaredMethods().length); // количество методов
        System.out.println(CarInterface.class.getDeclaredFields());




        // Работа со свойствами объекта
        Field[] fields = car.getClass().getDeclaredFields();

        for (Field field : fields){
            field.setAccessible(true); // делаем доступным поле private
            System.out.println("");System.out.println("Поле:");
            System.out.println(field.getName()); // Название поля
            System.out.println(field.getType()); // Тип поля
            try {
                System.out.println(field.get(car)); // Получаем значение поля
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }



        //Внедрение зависимости через рефлексию

//        Car.class.getConstructors().



        System.out.println(Car.class.getConstructors());

        System.out.println();System.out.println();System.out.println();

        System.out.println(reflections.getConstructorsWithSignature(Car.class));

    }
}
