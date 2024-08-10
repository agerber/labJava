package edu.uchicago.gerber.labjava.lec06.patterns.abstract_factory.example.app;

import edu.uchicago.gerber.labjava.lec06.patterns.abstract_factory.example.buttons.Button;
import edu.uchicago.gerber.labjava.lec06.patterns.abstract_factory.example.checkboxes.Checkbox;
import edu.uchicago.gerber.labjava.lec06.patterns.abstract_factory.example.factories.GUIFactory;

/**
 * EN: Factory users don't care which concrete factory they use since they work
 * with factories and products through abstract interfaces.
 *
 * RU: Код, использующий фабрику, не волнует с какой конкретно фабрикой он
 * работает. Все получатели продуктов работают с продуктами через абстрактный
 * интерфейс.
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
