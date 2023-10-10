package edu.uchicago.gerber.labjava.lec03.sing;

public class Chipmunk implements Singable {

    @Override
    public String sing() {
        return "MI *********************************************************";
    }

    @Override
    public String dance() {
        return "(\\__/)  .~    ~. ))\n" +
                " /O O  ./      .'\n" +
                "{O__,   \\    {\n" +
                "  / .  . )    \\\n" +
                "  |-| '-' \\    }\n" +
                " .(   _(   )_.'\n" +
                "'---.~_ _ _&";
    }
}
