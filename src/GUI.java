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
	//MENU BAR:
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuFormat, menuColor, menuHelp;
	//FILE
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
	//FORMAT
	JMenuItem iWordWarp;
	JMenu menuFont, menuFontSize;
	
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
		iWordWarp = new JMenuItem("World Wrap: Off");
		iWordWarp.addActionListener(this);
		iWordWarp.setActionCommand("World Wrap");
		menuFormat.add(iWordWarp);
		
		menuFont = new JMenu("Font..");
		menuFormat.add(menuFont);
		
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
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
		}
	}
	
	//icon link:
	// https://www.freeiconspng.com/img/17537
	
}
