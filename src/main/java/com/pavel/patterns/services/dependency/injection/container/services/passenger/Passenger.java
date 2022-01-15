package com.pavel.patterns.services.dependency.injection.container.services.passenger;

public class Passenger implements PassengerInterface {
    @Override
    public void manage() {
        System.out.println("Водитель: Начал управлять!");
    }
}
