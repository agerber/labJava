package lec05.swing;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class LeetTranslator {

	private JFrame frm;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenu menu_1;
	private JMenu menu_2;
	private JEditorPane edpLeet;

	// ===============================================
	// ==MY FIELDS
	// ===============================================

	private Hashtable<String, String> htbLeet; // = new Hashtable<String, String>();
	private JSlider sldLeet;
	private JMenuItem menuItem;
	private JMenuItem menuItem_2;
	private Set<String> setKeys;

	private JMenuItem menuItem_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeetTranslator window = new LeetTranslator();
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
	public LeetTranslator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frm = new JFrame();

		frm.setTitle("Leet Translator");
		frm.setBounds(100, 100, 571, 452);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		frm.setJMenuBar(menuBar);

		menu = new JMenu("File");
		menuBar.add(menu);

		menuItem = new JMenuItem("Exit");
		menu.add(menuItem);

		menu_1 = new JMenu("Edit");
		menuBar.add(menu_1);

		menuItem_5 = new JMenuItem("paste");

		menu_1.add(menuItem_5);

		menu_2 = new JMenu("Help");
		menuBar.add(menu_2);

		menuItem_2 = new JMenuItem("About");
		menu_2.add(menuItem_2);

		edpLeet = new JEditorPane();
		edpLeet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {

				if (evt.getKeyCode() == KeyEvent.VK_ENTER)
					translate();
				//				else if (evt.getKeyCode() ==  KeyEvent.VK_R   &&   (evt.getModifiers() & KeyEvent.CTRL_MASK) != 0){
				//					translate(true);
				//				}

			}
		});
		edpLeet.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		frm.getContentPane().add(edpLeet, BorderLayout.CENTER);

		sldLeet = new JSlider(0, 99, 50);
		frm.getContentPane().add(sldLeet, BorderLayout.NORTH);

		//working with swing components
		//http://www.java2s.com/Code/Java/Swing-JFC/Makethecomponentonlystretchhorizontally.htm

		//http://www.chatslang.com/leet_sheet
		//hashtable to store leet key/value pairs
		htbLeet = new Hashtable<String, String>();

		htbLeet.put("a", "@");
		htbLeet.put("b", "8");
		htbLeet.put("c", "�");
		htbLeet.put("d", ")");
		htbLeet.put("e", "3");
		htbLeet.put("f", "�");
		htbLeet.put("g", "6");
		htbLeet.put("h", "#");
		htbLeet.put("i", "1");
		htbLeet.put("j", "]");
		htbLeet.put("k", "X");
		htbLeet.put("l", "|");
		htbLeet.put("m", "|v|");
		htbLeet.put("n", "|\\|");
		htbLeet.put("o", "0");
		htbLeet.put("p", "�");
		htbLeet.put("q", "9");
		htbLeet.put("r", "2");
		htbLeet.put("s", "5");
		htbLeet.put("t", "7");
		htbLeet.put("u", "�");
		htbLeet.put("v", "\\/");
		htbLeet.put("w", "VV");
		htbLeet.put("x", "%");
		htbLeet.put("y", "�");
		htbLeet.put("z", "2");

	}

	//translate() called when user clicks enter

	//create a unique set of characters in a sentence
	//for each char in set 
		//if alpha char and Math.randoom() * 100 < slider-value 
			//replace chars in sentence
	//copy sentence clipboard
	//clear out text editor

	private void translate() {
		String strSentence = edpLeet.getText();

		//letters of the sentence as a set
		Set<String> setLetters = new HashSet<String>();
		//keys from our leet hashtable

		//add all the chars
		for (int nC = 0; nC < strSentence.length(); nC++) {
			setLetters.add(String.valueOf(strSentence.charAt(nC)));
		}

		for (String str : setLetters) {

			String strHashValue = htbLeet.get(str);

			if ((strHashValue != null)
					&& Math.random() * 100 < sldLeet.getValue()) {

				strSentence = strSentence.replace(str, strHashValue);
			}

		}

		Clipboard clp = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection sel = new StringSelection(strSentence);
		clp.setContents(sel, null);

		edpLeet.setText("");

	}

}
