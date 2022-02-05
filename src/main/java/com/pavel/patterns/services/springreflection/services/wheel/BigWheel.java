package com.pavel.patterns.services.springreflection.services.wheel;

import org.springframework.stereotype.Component;

@Component
public class BigWheel implements WheelInterface {
    @Override
    public void run() {
        System.out.println("БОЛЬШИЕ Колеса: двигаются!");
    }
}
