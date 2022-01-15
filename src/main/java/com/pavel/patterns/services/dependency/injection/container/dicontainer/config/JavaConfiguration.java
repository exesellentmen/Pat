package com.pavel.patterns.services.dependency.injection.container.dicontainer.config;

import com.pavel.patterns.services.dependency.injection.container.services.car.Car;
import com.pavel.patterns.services.dependency.injection.container.services.car.CarInterface;

import java.util.Map;

public class JavaConfiguration implements Configuration {
    @Override
    public String getPackageToScan() {
        return "com.pavel.patterns.services.dependency.injection.container.services";
    }

    //Добавляем конфигурацию для определения реализаций к интерфейсам
    @Override
    public Map<Class, Class> getInterfaceToImplementations() {
        return Map.of(CarInterface.class, Car.class
        );
    }
}
