package edu.uchicago.gerber.labjava.lec06.glab.mortalkombat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/4/13
 * Time: 3:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class MortalKombatGui {
    private JPanel mPanel;
    private JPanel mInterior;

    public static final int WIDTH = 525;
    public static final int HEIGHT = 392;

    //TODO refactor these fields
    //private JFrame frm;
    //private JPanel pan;
    private JTextPane txtStatus;
    private JMenuBar mbr;
    private JMenu menPlay;
    private JMenuItem mniExit;

    private BufferedImage bufImg;

    private Boxable boxPuncher;
    private Boxable  boxPunchee;

    private Boxable boxDrawsFirstBlood;


    private int nAlpha;
    private int nTime;
    private Timer tim;
    private static JFrame frm;


    public static void main(String[] args) {
        frm = new JFrame("MortalKombatGui");

        frm.setContentPane(new MortalKombatGui().mPanel);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(500,500);
        frm.pack();
        frm.setVisible(true);
    }

    public MortalKombatGui() {
            initialize();

    }

    //method found on stackoverflow.com, re-implemented here
    private  BufferedImage getTranslucentImage(BufferedImage bufParam, int nAlpha) {
        BufferedImage bufRet = new BufferedImage(bufParam.getWidth(), bufParam.getHeight(), BufferedImage.TYPE_INT_ARGB);
        int  nRed, nGreen, nBlue, nColor;
        Color col;
        for(int nX = 0; nX < bufParam.getWidth(); nX++){
            for(int nY = 0; nY < bufParam.getHeight(); nY++){

                //bit mask
                nColor = bufParam.getRGB(nX, nY);
                nRed = (nColor & 0x00ff0000) >> 16;   //shift it over 16 bits (or 4 hex decimals)
                nGreen = (nColor & 0x0000ff00) >> 8;  //shift it over 8 bits (or 2 hex decimals)
                nBlue = nColor & 0x000000ff;

                //for each pixel, set the alpha-channel
                col = new Color(nRed, nGreen, nBlue, nAlpha );
                bufRet.setRGB(nX, nY, col.getRGB());

            }
        }

        return bufRet;

    }


    private void initialize() {

        frm = new JFrame();
        nAlpha = 0;
        nTime = 0;

        boxPuncher = new SuperHero("/src/edu.uchicago.gerber.labjava.lec06/glab/mortalkombat/imgs/mortal.jpg","/src/edu.uchicago.gerber.labjava.lec06/glab/mortalkombat/sounds/sco.wav", "Get over here!", 600, Boxable.ACC_SCORP, Boxable.POW_SCORP, "Scorpion:");
        boxPunchee = new SuperHero("/src/edu.uchicago.gerber.labjava.lec06/glab/mortalkombat/imgs/freez.jpg", "/src/edu.uchicago.gerber.labjava.lec06/glab/mortalkombat/sounds/sub.wav", "Better than a Frigidaire!", 600, Boxable.ACC_FREEZ, Boxable.POW_FREEZ, "SubZero::");
        frm.setTitle("MortalKombat");
        //frm.setBounds(100, 100, 553, 545);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.getContentPane().setLayout(null);
        boxDrawsFirstBlood = boxPuncher;



        mInterior = new JPanel(){

            @Override
            public void paintComponent(Graphics g) {

                bufImg =  ((SuperHero)boxPuncher).getBufferedImage();
                bufImg = getTranslucentImage(bufImg, nAlpha);
                g.drawImage(bufImg, 0, 0, null);

            }
        };
        frm.add(mInterior);


       // pan.setBounds(10, 11, 525, 392);
        mInterior.repaint();
        frm.getContentPane().add(mInterior);

        txtStatus = new JTextPane();
        txtStatus.setFont(new Font("Impact", Font.PLAIN, 26));
        txtStatus.setContentType("text/html");
        txtStatus.setEditable(false);
        txtStatus.setBounds(10, 414, 525, 72);
        frm.getContentPane().add(txtStatus);
        //txtStatus.setColumns(10);

        mbr = new JMenuBar();
        frm.setJMenuBar(mbr);

        menPlay = new JMenu("Play");
        mbr.add(menPlay);

        mniExit = new JMenuItem("Exit");
        mniExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        menPlay.add(mniExit);



        tim = new Timer(40,

                new ActionListener() {

                    public void actionPerformed(ActionEvent evn) {

                        StringBuilder stringBuilder = new StringBuilder();


                        //transition the alpha channel -- enemy approaching
                        if (nTime < 25){

                            nAlpha = 3;
                            nTime++;
                        }
                        //simulate strike -- alpha channel full-on
                        else if (nTime < 30 ){


                            nAlpha = 255;
                            nTime++;
                        }

                        else {

                            //strike
                            if (boxPuncher.punch(boxPunchee)){

                                //kill
                                if (boxPunchee.healthStatus() <= 0){
                                    playStrikeSound();
                                    //get the timer from the event
                                    ((Timer)evn.getSource()).stop();
                                    System.gc();

                                    txtStatus.setText(((SuperHero)boxPuncher).getInterview());
                                }
                                //keep fighting
                                else {

                                    playStrikeSound();
                                    stringBuilder.append("<html>");
                                    //make Scorpion first always
                                    if(boxDrawsFirstBlood == boxPuncher){

                                        stringBuilder.append(((SuperHero)boxPuncher).getName() + " " + healthMeter(boxPuncher.healthStatus()));
                                        stringBuilder.append("<br />");
                                        stringBuilder.append(((SuperHero)boxPunchee).getName() + " " + healthMeter(boxPunchee.healthStatus()));
                                        stringBuilder.append("</html>");
                                    } else {

                                        stringBuilder.append(((SuperHero)boxPunchee).getName() + " " + healthMeter(boxPunchee.healthStatus()));
                                        stringBuilder.append("<br />");
                                        stringBuilder.append(((SuperHero)boxPuncher).getName() + " " + healthMeter(boxPuncher.healthStatus()));
                                        stringBuilder.append("</html>");

                                    }

                                    txtStatus.setText(stringBuilder.toString());
                                }

                            }
                            //swap
                            Boxable boxTemp = boxPuncher;
                            boxPuncher = boxPunchee;
                            boxPunchee = boxTemp;

                            nTime = 0;
                            nAlpha = 0;
                        }


                        mInterior.repaint();

                    }

                    //methods of my anonymous inner class
                    private void playStrikeSound() {
                        Mortal mor = (Mortal)boxPuncher;
                        SoundImageUtils.playSound(mor.getSoundPath());
                    }

                    private String healthMeter(int nPoint){
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(" " + nPoint + " ");
                        for (int nC = 0; nC <nPoint/10 ; nC++) {
                            stringBuilder.append("#");
                        }
                        return stringBuilder.toString();
                    }
                }

        );

        tim.start();



    }






}
