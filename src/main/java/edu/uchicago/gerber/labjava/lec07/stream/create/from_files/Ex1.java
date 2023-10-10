package edu.uchicago.gerber.labjava.lec07.stream.create.from_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
/*from ww  w . ja  v a  2  s  . com*/
public class Ex1 {
    public static void main(String[] args) {
        Path path = Paths.get("./Ex1.java");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
