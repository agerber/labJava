package edu.uchicago.gerber.labjava.lec06.patterns.factory_method.example.factory;

import edu.uchicago.gerber.labjava.lec06.patterns.factory_method.example.buttons.Button;
import edu.uchicago.gerber.labjava.lec06.patterns.factory_method.example.buttons.HtmlButton;

/**
 * EN: HTML Dialog will produce HTML buttons.
 *
 * RU: HTML-диалог.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
