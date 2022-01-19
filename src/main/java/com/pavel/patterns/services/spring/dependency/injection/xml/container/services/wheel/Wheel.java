package com.pavel.patterns.services.spring.dependency.injection.xml.container.services.wheel;

import org.springframework.stereotype.Component;

@Component
public class Wheel implements WheelInterface {
    @Override
    public void run() {
        System.out.println("Колеса: поехали!");
    }
}
