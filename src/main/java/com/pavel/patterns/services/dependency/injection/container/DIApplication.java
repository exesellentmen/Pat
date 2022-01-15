package com.pavel.patterns.services.dependency.injection.container;

import com.pavel.patterns.services.dependency.injection.container.dicontainer.context.ApplicationContext;
import com.pavel.patterns.services.dependency.injection.container.dicontainer.factory.BeanFactory;
import com.pavel.patterns.services.dependency.injection.container.services.car.Car;
import com.pavel.patterns.services.dependency.injection.container.services.car.CarInterface;
import com.pavel.patterns.services.dependency.injection.container.services.engine.Engine;
import com.pavel.patterns.services.dependency.injection.container.services.engine.EngineInterface;
import com.pavel.patterns.services.dependency.injection.container.services.passenger.Passenger;
import com.pavel.patterns.services.dependency.injection.container.services.passenger.PassengerInterface;
import com.pavel.patterns.services.dependency.injection.container.services.wheel.Wheel;
import com.pavel.patterns.services.dependency.injection.container.services.wheel.WheelInterface;

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

