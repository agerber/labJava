package edu.uchicago.gerber.labjava.lec10.patterns.observer.example;

import edu.uchicago.gerber.labjava.lec10.patterns.observer.example.editor.Editor;
import edu.uchicago.gerber.labjava.lec10.patterns.observer.example.listeners.EmailNotificationListener;
import edu.uchicago.gerber.labjava.lec10.patterns.observer.example.listeners.LogOpenListener;

public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
