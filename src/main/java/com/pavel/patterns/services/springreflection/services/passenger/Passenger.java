package com.pavel.patterns.services.springreflection.services.passenger;

import org.springframework.stereotype.Component;

@Component
public class Passenger implements PassengerInterface {
    @Override
    public void manage() {
        System.out.println("Водитель: Начал управлять!");
    }
}
