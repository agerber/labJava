package lec06.glab.notepad;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/3/13
 * Time: 8:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClipboardAndFileUtil {

    private static Clipboard clp = Toolkit.getDefaultToolkit().getSystemClipboard();

    public static void copy(String strCopy) {
        StringSelection sel = new StringSelection(strCopy);
        clp.setContents(sel, null);
    }

    //http://www.javapractices.com/topic/TopicAction.do?Id=82
    public static String patse() {
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        //odd: the Object param of getContents is not currently used
        Transferable contents = clipboard.getContents(null);
        boolean hasTransferableText =
                (contents != null) &&
                        contents.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (hasTransferableText) {
            try {
                result = (String) contents.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException ex) {
                System.out.println(ex);
                ex.printStackTrace();
            }
        }
        return result;
    }


    //http://stackoverflow.com/questions/14589386/how-to-save-file-using-jfilechooser-in-java
    public static void save(String strContent) {

        //String sb = "TEST CONTENT";
        JFileChooser chooser = new JFileChooser();
        //http://stackoverflow.com/questions/15954770/starting-a-jfilechooser-at-a-specified-directory-and-only-showing-files-of-a-spe
        chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return false;
                }
            }
            @Override
            public String getDescription() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        //chooser.setCurrentDirectory(new File("/home/me/Documents"));
        int nUserFeedback = chooser.showSaveDialog(null);
        //BufferedWriter out
        if (nUserFeedback == JFileChooser.APPROVE_OPTION) {
            //try with resources Java7
            try (FileWriter fstream = new FileWriter(chooser.getSelectedFile() + ".txt");
                 BufferedWriter out = new BufferedWriter(fstream)) {
                    out.write(strContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


//    public static void open() {
//
//
//        JFileChooser chooser = new JFileChooser();
//
//
//
//        //chooser.setCurrentDirectory(new File("/home/me/Documents"));
//        int nUserFeedback = chooser.showSaveDialog(null);
//        //BufferedWriter out
//        if (nUserFeedback == JFileChooser.APPROVE_OPTION) {
//            //try with resources Java7
//            try (FileWriter fstream = new FileWriter(chooser.getSelectedFile() + ".txt");
//                 BufferedWriter out = new BufferedWriter(fstream)) {
//                out.write(strContent);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}










