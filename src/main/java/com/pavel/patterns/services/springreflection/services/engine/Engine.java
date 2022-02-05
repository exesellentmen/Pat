package com.pavel.patterns.services.springreflection.services.engine;

import org.springframework.stereotype.Component;

@Component
public class Engine implements EngineInterface {
    @Override
    public void launch() {
        System.out.println("Двигатель: Заработал!");
    }
}
