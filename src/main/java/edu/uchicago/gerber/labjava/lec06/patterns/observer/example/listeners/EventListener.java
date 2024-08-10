package edu.uchicago.gerber.labjava.lec06.patterns.observer.example.listeners;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}
