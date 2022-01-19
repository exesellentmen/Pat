package com.pavel.patterns.services.spring.dependency.injection.xml.container.services.engine;

import org.springframework.stereotype.Component;

@Component
public class Engine implements EngineInterface {
    @Override
    public void launch() {
        System.out.println("Двигатель: Заработал!");
    }
}
