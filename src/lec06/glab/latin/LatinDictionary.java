package lec06.glab.latin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/4/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class LatinDictionary {
    private JPanel mValue;
    private JButton mButtonNew;
    private JButton mButtonSearch;
    private JList mList;
    private Map<String,String> mMap;

    public static void main(String[] args) {
        JFrame frame = new JFrame("LatinDictionary");
        frame.setContentPane(new LatinDictionary().mValue);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.pack();
        frame.setVisible(true);
    }

    public LatinDictionary() {

        //init
        mMap = new HashMap<>();

        //event listeners
        mButtonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                NewDef dialog = new NewDef(LatinDictionary.this);
                dialog.pack();
                dialog.setVisible(true);


            }
        });

    }

    public void setList(Map map){
        mMap.putAll(map);
        String strBuild = "";
        for (Object obj : mMap.keySet()) {
            strBuild += ((String)obj);
            strBuild += " : ";
            strBuild += ((String)mMap.get(obj)).toString();
            strBuild += "\n";
            mList.setListData(new String[] {strBuild});
        }

        mList.updateUI();

    }

    //used to set values
    public class Tuple {
        private String mLatin;
        private String mEnglish;

        public Tuple(String english, String latin) {
            mEnglish = english;
            mLatin = latin;
        }

        public String getEnglish() {
            return mEnglish;
        }

        public void setEnglish(String english) {
            mEnglish = english;
        }

        public String getLatin() {
            return mLatin;
        }

        public void setLatin(String latin) {
            mLatin = latin;
        }
    }
}
