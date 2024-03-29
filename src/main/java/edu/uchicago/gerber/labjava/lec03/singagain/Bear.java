package edu.uchicago.gerber.labjava.lec03.singagain;

public class Bear implements Singable {

    @Override
    public String sing() {
        return "DO **********";
    }

    @Override
    public String dance() {
        return "      (\\\\  _                      ___\n" +
                "     .-\"`\"(\\\\                _.\"\"`   `\"-.\n" +
                "    /      ` `-._        _.-\"            `\\__\n" +
                "   6   6)        `-.__.-'                    `\",\n" +
                "  /                                         `;-`\n" +
                " /     ,                                     |\n" +
                "()    /  /`                                  |\n" +
                " `---`\"~``\\                                  |\n" +
                "           \\                                 |\n" +
                "            \\            \\      /           /\n" +
                "            /`,   ,      |     |           /\n" +
                "           /   \"-.|      |     |         /'\n" +
                "          /     / |     /,__   |       /`\\\n" +
                "     jgs /    /'  |    /    `\"'\\      (   \\\n" +
                "      __/   /'    |   |         `\\     \\   \\\n" +
                "      \\    /      |   |           `\\    \\   \\\n" +
                "       `-,/      /    |            /     |-\"`\n" +
                "                `\"\"\"^^^           `^^\"\"\"\"`";
    }
}
