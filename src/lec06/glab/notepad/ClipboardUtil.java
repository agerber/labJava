package lec06.glab.notepad;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/3/13
 * Time: 8:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClipboardUtil {

   private static Clipboard clp = Toolkit.getDefaultToolkit().getSystemClipboard();

   public static void copy(String strCopy){
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
                result = (String)contents.getTransferData(DataFlavor.stringFlavor);
            }
            catch (UnsupportedFlavorException | IOException ex){
                System.out.println(ex);
                ex.printStackTrace();
            }
        }
        return result;
    }
}







