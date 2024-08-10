package edu.uchicago.gerber.labjava.lec06.patterns.builder.example.builders;

import edu.uchicago.gerber.labjava.lec06.patterns.builder.example.cars.Car;
import edu.uchicago.gerber.labjava.lec06.patterns.builder.example.cars.CarType;
import edu.uchicago.gerber.labjava.lec06.patterns.builder.example.components.Engine;
import edu.uchicago.gerber.labjava.lec06.patterns.builder.example.components.GPSNavigator;
import edu.uchicago.gerber.labjava.lec06.patterns.builder.example.components.Transmission;
import edu.uchicago.gerber.labjava.lec06.patterns.builder.example.components.TripComputer;

/**
 * EN: Concrete builders implement steps defined in the common interface.
 *
 * RU: Конкретные строители реализуют шаги, объявленные в общем интерфейсе.
 */
public class CarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car getResult() {
        return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
