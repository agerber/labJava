package edu.uchicago.gerber.labjava.lec10.patterns.builder.example.components;

import edu.uchicago.gerber.labjava.lec10.patterns.builder.example.cars.Car;

/**
 * EN: Just another feature of a car.
 *
 * RU: Одна из фишек автомобиля.
 */
public class TripComputer {

    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuelLevel() {
        System.out.println("Fuel level: " + car.getFuel());
    }

    public void showStatus() {
        if (this.car.getEngine().isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
    }
}
