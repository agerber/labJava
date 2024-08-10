package edu.uchicago.gerber.labjava.lec06.patterns.command.example.commands;

import edu.uchicago.gerber.labjava.lec06.patterns.command.example.editor.Editor;

public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
