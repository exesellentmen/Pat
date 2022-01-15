package com.pavel.patterns.services.dependency.injection.container.services.car;

import com.pavel.patterns.services.dependency.injection.container.dicontainer.annotation.Inject;
import com.pavel.patterns.services.dependency.injection.container.services.engine.EngineInterface;
import com.pavel.patterns.services.dependency.injection.container.services.passenger.PassengerInterface;
import com.pavel.patterns.services.dependency.injection.container.services.wheel.WheelInterface;


public class Car implements CarInterface {

    @Inject
    private EngineInterface engine;

    @Inject
    private WheelInterface wheel;

    @Inject
    private PassengerInterface passenger;

    @Override
    public void move() {

        System.out.println("Запускаем машину");
        //Запускаем двигатель
        engine.launch();
        //Начинаем движение колесами
        wheel.run();
        //Начинаем управление Водителем
        passenger.manage();
    }

}
