package edu.uchicago.gerber.labjava.lec06.patterns.facade.example;

import edu.uchicago.gerber.labjava.lec06.patterns.facade.example.facade.VideoConversionFacade;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        // ...
    }
}
