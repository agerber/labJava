package edu.uchicago.gerber.labjava.lec10.patterns.command.example.commands;

import edu.uchicago.gerber.labjava.lec10.patterns.command.example.editor.Editor;

public abstract class Command {
    public Editor editor;
    private String backup;

    Command(Editor editor) {
        this.editor = editor;
    }

    void backup() {
        backup = editor.textField.getText();
    }

    public void undo() {
        editor.textField.setText(backup);
    }

    public abstract boolean execute();
}
