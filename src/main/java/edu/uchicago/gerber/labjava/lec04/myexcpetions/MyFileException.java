package edu.uchicago.gerber.labjava.lec04.myexcpetions;

import java.io.IOException;

public class MyFileException extends IOException {


    public MyFileException(Exception e) {
        super(e);

    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }
}
