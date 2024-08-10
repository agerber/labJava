package edu.uchicago.gerber.labjava.lec06.patterns.abstract_factory.example.factories;

import edu.uchicago.gerber.labjava.lec06.patterns.abstract_factory.example.buttons.Button;
import edu.uchicago.gerber.labjava.lec06.patterns.abstract_factory.example.buttons.MacOSButton;
import edu.uchicago.gerber.labjava.lec06.patterns.abstract_factory.example.checkboxes.Checkbox;
import edu.uchicago.gerber.labjava.lec06.patterns.abstract_factory.example.checkboxes.MacOSCheckbox;

/**
 * EN: Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 *
 * RU: Каждая конкретная фабрика знает и создаёт только продукты своей вариации.
 */
public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
