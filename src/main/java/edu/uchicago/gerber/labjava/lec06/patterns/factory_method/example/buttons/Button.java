package edu.uchicago.gerber.labjava.lec06.patterns.factory_method.example.buttons;

/**
 * EN: Common interface for all buttons.
 *
 * RU: Общий интерфейс для всех продуктов.
 */
public interface Button {
    void render();
    void onClick();
}
