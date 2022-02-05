package com.pavel.patterns.services.dependency.injection.container;

import com.pavel.patterns.services.dependency.injection.container.dicontainer.context.ApplicationContext;
import com.pavel.patterns.services.dependency.injection.container.dicontainer.factory.BeanFactory;
import com.pavel.patterns.services.dependency.injection.container.dicontainer.postprocessor.BeanPostProcessor;
import com.pavel.patterns.services.dependency.injection.container.services.car.Car;
import com.pavel.patterns.services.dependency.injection.container.services.car.CarInterface;
import com.pavel.patterns.services.dependency.injection.container.services.engine.Engine;
import com.pavel.patterns.services.dependency.injection.container.services.engine.EngineInterface;
import com.pavel.patterns.services.dependency.injection.container.services.passenger.Passenger;
import com.pavel.patterns.services.dependency.injection.container.services.passenger.PassengerInterface;
import com.pavel.patterns.services.dependency.injection.container.services.wheel.Wheel;
import com.pavel.patterns.services.spring.dependency.injection.xml.container.services.wheel.WheelInterface;
import org.reflections.Reflections;

import java.lang.reflect.Field;

public class DIApplication {

    public ApplicationContext run(){
        ApplicationContext applicationContext = new ApplicationContext();
        BeanFactory beanFactory = new BeanFactory(applicationContext);
        applicationContext.setBeanFactory(beanFactory);

        return applicationContext;
    }


    public static void main(String[] args) {


        DIApplication diApplication = new DIApplication();
        ApplicationContext applicationContext = diApplication.run();

        CarInterface car = applicationContext.getBean(Car.class);
        car.move();



        // Использование рефлексии
        Reflections reflections = new Reflections("com.pavel.patterns.services");

        System.out.println("Получение всех реализаций интерфейса");
        System.out.println(reflections.getSubTypesOf(WheelInterface.class));


        // Java Reflection API

        System.out.println();
        System.out.println();
        System.out.println("Использование Java Reflection API");
        System.out.println(Car.class.getDeclaredMethods().length); // количество методов
        System.out.println(Car.class.getDeclaredFields());

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



//        System.out.println("Пробуем работать");
//
//        EngineInterface engine = new Engine();
//        WheelInterface wheel = new Wheel();
//        PassengerInterface passenger = new Passenger();
//
//        Car car = new Car(engine,wheel);
//        car.addPassenger(passenger);
//        car.addPassenger(new Passenger());
//
//        CarInterface carq = car;
//
//        carq.move();





    }
}

