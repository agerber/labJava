package edu.uchicago.gerber.labjava.lec06.patterns.builder.example.builders;

import edu.uchicago.gerber.labjava.lec06.patterns.builder.example.cars.CarType;
import edu.uchicago.gerber.labjava.lec06.patterns.builder.example.components.Engine;
import edu.uchicago.gerber.labjava.lec06.patterns.builder.example.components.GPSNavigator;
import edu.uchicago.gerber.labjava.lec06.patterns.builder.example.components.Transmission;
import edu.uchicago.gerber.labjava.lec06.patterns.builder.example.components.TripComputer;

/**
 * EN: Builder interface defines all possible ways to configure a product.
 *
 * RU: Интерфейс Строителя объявляет все возможные этапы и шаги конфигурации
 * продукта.
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
