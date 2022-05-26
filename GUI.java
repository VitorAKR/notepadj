import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI implements ActionListener{
	
	JFrame window;
	JTextArea textArea;
	JScrollPane scrollPane;
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuFormat, menuColor, menuHelp;
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
	
	FileFunctions file = new FileFunctions(this);
	
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
		
		//call menu items for File
		createFileMenu();
		
		//make it visible
		window.setVisible(true);
		
	}
	
	public void createWindow() {
		window = new JFrame("NotepadJ");
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
		iNew = new JMenuItem("New                          Ctrl+N");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new JMenuItem("Open                        Ctrl+O");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new JMenuItem("Save                        Ctrl+S");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("Save As..      Ctrl+Shift+S");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
		
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
	
}
