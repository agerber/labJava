package edu.uchicago.gerber.labjava.lec10.glab.serialize_xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/28/13
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
//example found here: http://stackoverflow.com/questions/4602210/xmlencoder-in-java-for-serialization
public class SerialDriver {


    private static final String FILENAME = "highscore.xml";


    public static void main(String[] args) {

        createFileIfNotExist(FILENAME);

        Scanner scan = new Scanner(System.in);

        String strUser, strName, strScore;

        outer:
        while (true) {
            System.out.println("press a for add high-score, p for print high-scores descending, or x for print xml, or q to quit:");

            strUser = scan.nextLine();
            strUser = strUser.toLowerCase();
            try {
                switch (strUser) {
                    case "a":
                        System.out.println("What is your name?");
                        strName = scan.nextLine();
                        System.out.println("What is your score?");
                        strScore = scan.nextLine();
                        HighScores highScores = getHighScores();
                        highScores.add(new HighScore(strName, strScore));
                        writeHighScores(highScores);
                        break;
                    case "p":
                        HighScore[] highScoresArray = getSortedHighScores(getHighScores());
                        for (HighScore highScore : highScoresArray) {
                            System.out.println(highScore);
                        }
                        System.out.println();
                        break;
                    case "x":
                        printXml();
                        break;
                    case "q":
                        break outer;
                    default:

                }
            } catch (IOException e) {
                System.out.println("There's been an error: " + e.getMessage());
                continue outer;
            }

        }
        System.out.println("Thanks for playing.");


    }

    private static void createFileIfNotExist(String strFileName) {
        String strCurrentDir = System.getProperty("user.dir");
        File highScoreFile = new File(strCurrentDir + "/" + strFileName);
        if (!highScoreFile.exists()) {
            try {
                writeHighScores(new HighScores());
            } catch (FileNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    private static void writeHighScores(HighScores highScores) throws FileNotFoundException {

        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream(FILENAME)));
        encoder.writeObject(highScores);
        encoder.close();

    }

    private static void printXml() throws IOException {

        String strRet = "";
        BufferedReader br = new BufferedReader(new FileReader(new File(FILENAME)));
        String strLine = "";

        while ((strLine = br.readLine()) != null) {
            strRet += strLine + "\n";
        }
        System.out.println(strRet);
    }

    private static HighScores getHighScores() throws FileNotFoundException {

        XMLDecoder decoder = new XMLDecoder(new FileInputStream(FILENAME));
        HighScores listFromFile = null;
        try {
            listFromFile = (HighScores) decoder.readObject();
        } catch (ArrayIndexOutOfBoundsException e) {
            listFromFile = new HighScores();
        } finally {
            decoder.close();
        }


        return listFromFile;
    }

    private static HighScore[] getSortedHighScores(HighScores highScores) {
        HighScore[] highScoresArray = highScores.toArray(new HighScore[highScores.size()]);
        Arrays.sort(highScoresArray);
        return highScoresArray;
    }
}



