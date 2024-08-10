package edu.uchicago.gerber.labjava.lec06.patterns.memento.example.history;

import edu.uchicago.gerber.labjava.lec06.patterns.memento.example.editor.Editor;

public class Memento {
    private String backup;
    private Editor editor;

    public Memento(Editor editor) {
        this.editor = editor;
        this.backup = editor.backup();
    }

    public void restore() {
        editor.restore(backup);
    }
}
