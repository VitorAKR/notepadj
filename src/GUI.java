import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class GUI implements ActionListener{
	
	JFrame window;
	//TEXT AREA:
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
	//MENU BAR:
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuFormat, menuColor, menuHelp;
	//FILE
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
	//FORMAT
	JMenuItem iWordWarp;
	JMenu menuFont, menuFontSize;
	//fonts
	JMenuItem iFontArial, iFontCSMS, iFontTNR;
	//sizes
	JMenuItem iFontSize8, iFontSize9, iFontSize10, iFontSize11, iFontSize12,
	iFontSize14, iFontSize16, iFontSize18, iFontSize20, iFontSize22, iFontSize24,
	iFontSize26, iFontSize28, iFontSize36, iFontSize48, iFontSize72;
	
	FileFunctions file = new FileFunctions(this);
	FormatFunctions format = new FormatFunctions(this);
	
	public static void main(String[] args) {
		
		new GUI();
		
	}
	
	public GUI(){
		//call window constructor
		createWindow();
		
		//call textArea
		createTextArea();
		
		//call menuBar
		createMenuBar();
		
		//call menu items
		createFileMenu();
		createFormatMenu();
		
		//make it visible
		window.setVisible(true);
		
	}
	
	public void createWindow() {
		window = new JFrame("Untitled - NotepadJ");
		window.setSize(1010, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createTextArea() {
		textArea = new JTextArea();
		//set scrollbar as needed
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//disable annoying border
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
		//window.add(textArea);
	}
	
	public void createMenuBar() {
		menuBar = new JMenuBar();
		//removing the shadow background 
		menuBar.setBackground(Color.WHITE);
		window.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuColor = new JMenu("Color");
		menuBar.add(menuColor);
		
		menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		
	}
	
	public void createFileMenu() {
		iNew = new JMenuItem("New     ");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		//add key trigger
		iNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		menuFile.add(iNew);
		
		iOpen = new JMenuItem("Open...  ");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		iOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		menuFile.add(iOpen);
		
		iSave = new JMenuItem("Save     ");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		iSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("Save As..");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		iSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem("Exit     ");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
		
	}
	
	public void createFormatMenu() {
		iWordWarp = new JMenuItem("Word Wrap: [OFF]");
		iWordWarp.addActionListener(this);
		iWordWarp.setActionCommand("Word Wrap");
		menuFormat.add(iWordWarp);
		
		menuFont = new JMenu("Font..");
		menuFormat.add(menuFont);
		
		//Add fonts in the Font Menu
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);
		
		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);
		
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		//Add sizes in the Size Menu
		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("size8");
		menuFontSize.add(iFontSize8);
		
		iFontSize9 = new JMenuItem("9");
		iFontSize9.addActionListener(this);
		iFontSize9.setActionCommand("size9");
		menuFontSize.add(iFontSize9);
		
		iFontSize10 = new JMenuItem("10");
		iFontSize10.addActionListener(this);
		iFontSize10.setActionCommand("size10");
		menuFontSize.add(iFontSize10);
		
		iFontSize11 = new JMenuItem("11");
		iFontSize11.addActionListener(this);
		iFontSize11.setActionCommand("size11");
		menuFontSize.add(iFontSize11);
		
		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("size12");
		menuFontSize.add(iFontSize12);
		
		iFontSize14 = new JMenuItem("14");
		iFontSize14.addActionListener(this);
		iFontSize14.setActionCommand("size14");
		menuFontSize.add(iFontSize14);
		
		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("size16");
		menuFontSize.add(iFontSize16);
		
		iFontSize18 = new JMenuItem("18");
		iFontSize18.addActionListener(this);
		iFontSize18.setActionCommand("size18");
		menuFontSize.add(iFontSize18);
		
		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("size20");
		menuFontSize.add(iFontSize20);
		
		iFontSize22 = new JMenuItem("22");
		iFontSize22.addActionListener(this);
		iFontSize22.setActionCommand("size22");
		menuFontSize.add(iFontSize22);
		
		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("size24");
		menuFontSize.add(iFontSize24);
		
		iFontSize26 = new JMenuItem("26");
		iFontSize26.addActionListener(this);
		iFontSize26.setActionCommand("size26");
		menuFontSize.add(iFontSize26);
		
		iFontSize28 = new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("size28");
		menuFontSize.add(iFontSize28);
		
		iFontSize36 = new JMenuItem("36");
		iFontSize36.addActionListener(this);
		iFontSize36.setActionCommand("size36");
		menuFontSize.add(iFontSize36);
		
		iFontSize48 = new JMenuItem("48");
		iFontSize48.addActionListener(this);
		iFontSize48.setActionCommand("size48");
		menuFontSize.add(iFontSize48);
		
		iFontSize72 = new JMenuItem("72");
		iFontSize72.addActionListener(this);
		iFontSize72.setActionCommand("size72");
		menuFontSize.add(iFontSize72);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		switch (command) {
		case "New": file.newFile(); break;
		case "Open": file.openFile(); break;
		case "Save": file.save(); break;
		case "SaveAs": file.saveAs(); break;
		case "Exit": file.exit(); break;
		case "Word Wrap": format.wordWrap(); break;
		}
	}
	
	//icon link:
	// https://www.freeiconspng.com/img/17537
	
}
