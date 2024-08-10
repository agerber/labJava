package edu.uchicago.gerber.labjava.lec06.patterns.mediator.example.components;

import edu.uchicago.gerber.labjava.lec06.patterns.mediator.example.mediator.Mediator;

/**
 * EN: Common component interface.
 *
 * RU: Общий интерфейс компонентов.
 */
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
