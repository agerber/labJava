package lec10.glab.playsounds;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

//good source for sound samples
//http://www.therecordist.com/video-game-audio/game-audio-samples
public class MockGame {

	private JFrame frame;
	
	//private URL urlMock =	MockGame.class.getResource("./");


	private JButton button;
	private JButton button_1;
	private final JLabel label = new JLabel("click these buttons rapidly");
	private JButton btnLoop;
	private JButton btnOld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MockGame window = new MockGame();
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
	public MockGame() {
		initialize();
		

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Concurrent (threaded) play MP3 sounds example");

		frame.setBounds(100, 100, 450, 151);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		button = new JButton("fire");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Mp3(System.getProperty("user.dir") + "/src/edu/uchicago/cs/java/lec10/playsounds/snds/gun_plasmafire.mp3")).start();
				
			}
		});
		frame.getContentPane().add(button);
		
		button_1 = new JButton("big explosion");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Mp3(System.getProperty("user.dir") + "/src/edu/uchicago/cs/java/lec10/playsounds/snds/explosion_enormous.mp3")).start();

			}
		});
		frame.getContentPane().add(button_1);
		frame.getContentPane().add(label);
		
		//http://www.talkingwav.com/music_mp3_sounds.html
		//http://www.flashheaven.de/englisch/loops.htm
		btnLoop = new JButton("loop music");
		btnLoop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			// new Thread(new Mp3Loop(System.getProperty("user.dir")+  "/src/edu/uchicago/cs/java/lec10/playsounds/snds/loop5.mp3")).start();
				new Thread(new Mp3Loop(System.getProperty("user.dir")+  "/src/edu/uchicago/cs/java/lec10/playsounds/snds/drums09.mp3")).start();
			 
				
			}
		});
		frame.getContentPane().add(btnLoop);
		
		btnOld = new JButton("loop music old school");
		btnOld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Thread(new ClipLoopOldSchool("file://" +   System.getProperty("user.dir") +   "/src/edu/uchicago/cs/java/lec10/playsounds/snds/samisen.au")).start();
			}
		});
		frame.getContentPane().add(btnOld);
	}


}
