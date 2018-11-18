package lec07.glab.notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;


public class ClipboardAndFileUtil {

    private static Clipboard clp = Toolkit.getDefaultToolkit().getSystemClipboard();

    public static void copy(String strCopy) {
        StringSelection sel = new StringSelection(strCopy);
        clp.setContents(sel, null);
    }

    //http://www.javapractices.com/topic/TopicAction.do?Id=82
    public static String paste() {
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
                return "*.txt";
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


    public static String open() {
        StringBuilder stringBuilder = new StringBuilder();
        JFileChooser chooser = new JFileChooser();
        //http://stackoverflow.com/questions/15954770/starting-a-jfilechooser-at-a-specified-directory-and-only-showing-files-of-a-spe
        chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isFile()) {
                    return true;
                } else {
                    return false;
                }
            }
            @Override
            public String getDescription() {
                return "*.txt";
            }
        });

        int nUserFeedback = chooser.showOpenDialog(null);
        if (nUserFeedback == JFileChooser.APPROVE_OPTION) {
            //try with resources Java7
           File file = chooser.getSelectedFile();

            try(BufferedReader reader  = new BufferedReader(new FileReader(file)))
             {
               	  String lineFromFile = "";
                	  while((lineFromFile = reader.readLine()) != null){
                          stringBuilder.append(lineFromFile);
                   	  }
                	}catch(IOException exception){
                	  System.out.println("Error while reading file");
                	}
             }
          return stringBuilder.toString();

    }
}










