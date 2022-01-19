package com.pavel.patterns.services.spring.dependency.injection.xml.container.services.wheel;

import org.springframework.stereotype.Component;

@Component
public class BigWheel implements WheelInterface {
    @Override
    public void run() {
        System.out.println("БОЛЬШИЕ Колеса: двигаются!");
    }
}
