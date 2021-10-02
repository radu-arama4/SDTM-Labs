package com.radu.Lab_1.builder;

import com.radu.Lab_1.entity.Car;

public class NewCarBuilder implements CarBuilder{
    private final Car car;

    public NewCarBuilder() {
        this.car = new Car();
    }

    public Car getCar() {
        return car;
    }

    @Override
    public void buildEngine() {
        car.setEngine("New Engine");
    }

    @Override
    public void buildWheels() {
        car.setWheels("New Wheels");
    }

    @Override
    public void buildRoofs() {
        car.setRoof("New Roof");
    }

    @Override
    public void buildBody() {
        car.setBody("New Body");
    }
}
