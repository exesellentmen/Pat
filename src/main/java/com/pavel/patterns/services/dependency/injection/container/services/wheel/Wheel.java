package com.pavel.patterns.services.dependency.injection.container.services.wheel;

public class Wheel implements WheelInterface {
    @Override
    public void run() {
        System.out.println("Колеса: поехали!");
    }
}
