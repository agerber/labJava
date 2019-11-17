package lec05.glab.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorSelect implements ChangeListener {

	private JFrame frm;
	private JPanel panColor;
	private JPanel panControl;
	private JSlider sldGreen;
	private JSlider sldRed;
	private JSlider sldBlue;
	private JLabel lblRed;
	private JLabel lblGreen;
	private JLabel lblBlue;
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
	public ColorSelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm = new JFrame();
		frm.setBounds(100, 100, 450, 476);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panColor = new JPanel();
		frm.getContentPane().add(panColor, BorderLayout.CENTER);
		
		panControl = new JPanel();
		frm.getContentPane().add(panControl, BorderLayout.SOUTH);
		panControl.setLayout(new GridLayout(3, 2, 0, 0));
		
		lblRed = new JLabel("Red");
		panControl.add(lblRed);

//		changeListener = new ChangeListener() {
//			@Override
//			public void stateChanged(ChangeEvent e) {
//				setPanelColor();
//			}
//		};
		
		sldRed = new JSlider(0,255,1);
		sldRed.addChangeListener(this);

		panControl.add(sldRed);
		
		lblGreen = new JLabel("Green");
		panControl.add(lblGreen);
		
		sldGreen = new JSlider(0,255,57);

		sldGreen.addChangeListener(this);

		panControl.add(sldGreen);
		
		lblBlue = new JLabel("Blue");
		//lblBlue.setForeground(new Color(0, 0, 255));
		panControl.add(lblBlue);
		
		sldBlue = new JSlider(0,255,168);
		sldBlue.addChangeListener(this);

		panControl.add(sldBlue);
		
		menuBar = new JMenuBar();
		frm.setJMenuBar(menuBar);
		
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
		
		panColor.setBackground(new Color(sldRed.getValue(), sldGreen.getValue(), sldBlue.getValue()));
		
	}


	/**
	 * Invoked when the target of the listener has changed its state.
	 *
	 * @param e a ChangeEvent object
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		setPanelColor();
	}
}
