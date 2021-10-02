package com.radu.Lab_1.builder;

import com.radu.Lab_1.entity.Car;

public class OldCarBuilder implements CarBuilder{
    private final Car car;

    public OldCarBuilder() {
        this.car = new Car();
    }

    public Car getCar() {
        return car;
    }

    @Override
    public void buildEngine() {
        car.setEngine("Old Engine");
    }

    @Override
    public void buildWheels() {
        car.setWheels("Old Wheels");
    }

    @Override
    public void buildRoofs() {
        car.setRoof("Old Roof");
    }

    @Override
    public void buildBody() {
        car.setBody("Old Body");
    }
}
