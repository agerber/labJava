package edu.uchicago.gerber.labjava.lec10.patterns.observer.example.listeners;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}
