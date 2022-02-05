package com.pavel.patterns.services.springreflection.services.car;

import com.pavel.patterns.services.springreflection.services.engine.EngineInterface;
import com.pavel.patterns.services.springreflection.services.passenger.PassengerInterface;
import com.pavel.patterns.services.springreflection.services.wheel.WheelInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // Помечаем что это бин
public class Car implements CarInterface {


    private final EngineInterface engine;

    private WheelInterface wheel;

    private WheelInterface secondWheel;

    //Внедрение через поле
    @Autowired
    private PassengerInterface passenger;

    //Внедрение через конструктор
    @Autowired
    public Car(EngineInterface engine, @Qualifier("bigWheel") WheelInterface secondWheel){ // @Qualifier("bigWheel") - Если несколько реализаций, уточняем какую
        this.engine = engine;
        this.secondWheel = secondWheel;
    }

    //Внедрение через сеттер
    @Autowired
    public void setWheel(@Qualifier("wheel") WheelInterface wheel) {
        this.wheel = wheel;
    }



    @Override
    public void move() {

        System.out.println("Запускаем машину");
        //Запускаем двигатель
        engine.launch();
        //Начинаем движение колесами
        wheel.run();
        //Начинаем движение Большими колесами
        secondWheel.run();
        //Начинаем управление Водителем
        passenger.manage();
    }

}
