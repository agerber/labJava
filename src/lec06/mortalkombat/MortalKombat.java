


package lec06.mortalkombat;

import java.awt.*;
import java.awt.event.*;
import java.awt.color.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.image.renderable.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.awt.image.RescaleOp;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Timer;



import javax.swing.SwingConstants;

import edu.uchicago.cs.java.lec06.blackjack.Card;

public class MortalKombat {
	//the dimension of the image panel
	public static final int WIDTH = 525; 
	public static final int HEIGHT = 392;
	
	private JFrame frm;
	private JPanel pan;
	private JTextField txtStatus;
	private JMenuBar mbr;
	private JMenu menPlay;
	private JMenuItem mniExit;
	
	private BufferedImage bufImg;
	
	private Boxable boxPuncher;
	private Boxable  boxPunchee;

	
	private int nAlpha;
	private int nTime;
	private Timer tim;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MortalKombat window = new MortalKombat();
					window.frm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MortalKombat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	


	//method found on stackoverflow.com, re-implemented here
	private  BufferedImage getTranslucentImage(BufferedImage bufParam, int nAlpha) {
		BufferedImage bufRet = new BufferedImage(bufParam.getWidth(), bufParam.getHeight(), BufferedImage.TYPE_INT_ARGB);
		int  nRed, nGreen, nBlue, nClr;
		Color col;
		for(int nX = 0; nX < bufParam.getWidth(); nX++){
			for(int nY = 0; nY < bufParam.getHeight(); nY++){
		
				
					  //bit mask
				      nClr = bufParam.getRGB(nX, nY);
				      nRed = (nClr & 0x00ff0000) >> 16;
				      nGreen = (nClr & 0x0000ff00) >> 8;
				      nBlue = nClr & 0x000000ff;
				
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
	
		boxPuncher = new SuperHero("mortal.jpg","sco.wav", "Get over here!", 600, Boxable.ACC_SCORP, Boxable.POW_SCORP, "Scorpion");
		boxPunchee = new SuperHero("freez.jpg", "sub.wav", "Better than a Frigidaire!", 600, Boxable.ACC_FREEZ, Boxable.POW_FREEZ, "SubZero");
		frm.setTitle("MortalKombat");
		frm.setBounds(100, 100, 553, 545);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.getContentPane().setLayout(null);
		
		//this object is now type-anonymous. It extends JPanel and we've 
		//defined some constants and overrode it's paintComponent() method
		pan = new JPanel(){
		

			
			@Override
			 public void paintComponent(Graphics g) {

				 bufImg =  ((SuperHero)boxPuncher).getBimMortal();
				// bufImg =  scaleImage(bufImg, WIDTH, HEIGHT, new Color(0,0,0));
				 bufImg = getTranslucentImage(bufImg, nAlpha);
				 
				 g.drawImage(bufImg, 0, 0, null);

		     }
		};
		
		//this class is now type anonymous. and we use reflection to test this. 
       // System.out.println( pan.getClass().getName());
		
		
		pan.setBounds(10, 11, 525, 392);
		pan.repaint();
		

		
		frm.getContentPane().add(pan);
		
		txtStatus = new JTextField();
		txtStatus.setFont(new Font("Impact", Font.PLAIN, 26));
		txtStatus.setHorizontalAlignment(SwingConstants.LEFT);
		txtStatus.setEditable(false);
		txtStatus.setBounds(10, 414, 525, 72);
		frm.getContentPane().add(txtStatus);
		txtStatus.setColumns(10);
		
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
		
		
	    //every three milliseconds
		tim = new Timer(40,

		new ActionListener() {

			public void actionPerformed(ActionEvent evn) {
				
			
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
					    	 txtStatus.setText(Boxable.SOUNDS[Boxable.RAN.nextInt(Boxable.SOUNDS.length)] + " " + ((SuperHero)boxPuncher).getName() + " " + boxPuncher.healthStatus() + " versus "  + 
					    			 ((SuperHero)boxPunchee).getName() + " " + boxPunchee.healthStatus()); 	
					    }
					    
					
					}
					//swap
					Boxable boxTemp = boxPuncher;
					boxPuncher = boxPunchee;
					boxPunchee = boxTemp;
					
					nTime = 0;
					nAlpha = 0;
				}
				
			
				pan.repaint();
				
			}

			private void playStrikeSound() {
				Mortal mor = (Mortal)boxPuncher;
				mor.playSound(mor.getSoundPath());
			}
		}

		);
		
		tim.start();
		
		

	}
	
	

	

	
	
}//end class



