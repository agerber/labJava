package edu.uchicago.gerber.labjava.lec03.singagain;

public class Chipmunk implements Singable {


    @Override
    public String sing() {
        return "ME ********************************************";
    }

    @Override
    public String dance() {
        return " (\\__/)  .~    ~. ))\n" +
                " /O O  ./      .'\n" +
                "{O__,   \\    {\n" +
                "  / .  . )    \\\n" +
                "  |-| '-' \\    }\n" +
                " .(   _(   )_.'\n" +
                "'---.~_ _ _&";
    }
}
