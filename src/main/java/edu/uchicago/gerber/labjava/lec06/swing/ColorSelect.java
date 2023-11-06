package edu.uchicago.gerber.labjava.lec06.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorSelect  {

	private JFrame frame;
	private JPanel panelColor;
	private JPanel panelSlider;
	private JSlider sliderGreen;
	private JSlider sliderRed;
	private JSlider sliderBlue;
	private JLabel labelRed;
	private JLabel labelGreen;
	private JLabel labelBlue;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;

	//private ChangeListener changeListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColorSelect window = new ColorSelect();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ColorSelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelColor = new JPanel();
		frame.getContentPane().add(panelColor, BorderLayout.CENTER);
		
		panelSlider = new JPanel();
		frame.getContentPane().add(panelSlider, BorderLayout.SOUTH);
		panelSlider.setLayout(new GridLayout(3, 2, 0, 0));
		
		labelRed = new JLabel("Red");
		panelSlider.add(labelRed);

//		changeListener = new ChangeListener() {
//			@Override
//			public void stateChanged(ChangeEvent e) {
//				setPanelColor();
//			}
//		};
		
		sliderRed = new JSlider(0,255,1);
		sliderRed.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				setPanelColor();
			}
		});

		panelSlider.add(sliderRed);
		
		labelGreen = new JLabel("Green");
		panelSlider.add(labelGreen);
		
		sliderGreen = new JSlider(0,255,57);

		sliderGreen.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				setPanelColor();
			}
		});

		panelSlider.add(sliderGreen);
		
		labelBlue = new JLabel("Blue");

		panelSlider.add(labelBlue);
		
		sliderBlue = new JSlider(0,255,168);

		sliderBlue.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				setPanelColor();
			}
		});

		panelSlider.add(sliderBlue);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		menu = new JMenu("File");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(menuItem);
		
		setPanelColor();
		
	}
	
	// ===============================================
	// ==OUR METHOD
	// ===============================================
	private void setPanelColor(){
		
		panelColor.setBackground(new Color(sliderRed.getValue(),
				sliderGreen.getValue(),
				sliderBlue.getValue()));
		
	}

//	@Override
//	public void stateChanged(ChangeEvent e) {
//		setPanelColor();
//
//
//
//	}


//	@Override
//	public void stateChanged(ChangeEvent e) {
//		setPanelColor();
//	}
}
