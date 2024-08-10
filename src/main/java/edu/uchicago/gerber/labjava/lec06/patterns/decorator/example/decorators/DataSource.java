package edu.uchicago.gerber.labjava.lec06.patterns.decorator.example.decorators;

public interface DataSource {
    void writeData(String data);

    String readData();
}
