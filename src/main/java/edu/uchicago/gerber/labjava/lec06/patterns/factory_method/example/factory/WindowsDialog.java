package edu.uchicago.gerber.labjava.lec06.patterns.factory_method.example.factory;

import edu.uchicago.gerber.labjava.lec06.patterns.factory_method.example.buttons.Button;
import edu.uchicago.gerber.labjava.lec06.patterns.factory_method.example.buttons.WindowsButton;

/**
 * EN: Windows Dialog will produce Windows buttons.
 *
 * RU: Диалог на элементах операционной системы.
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
