package com.pavel.patterns.services.dependency.injection.container.services.engine;

public class Engine implements EngineInterface {
    @Override
    public void launch() {
        System.out.println("Двигатель: Заработал!");
    }
}
