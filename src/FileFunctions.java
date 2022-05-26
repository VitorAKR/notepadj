import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileFunctions {
	GUI gui;
	String fileName;
	String fileAddress;
	
	public FileFunctions(GUI gui) {
		this.gui = gui;
	}
	
	public void newFile() {
		//erase the current text
		gui.textArea.setText("");
		gui.window.setTitle("New File - NotepadJ");
		fileName = null;
		fileAddress = null;
	}
	
	public void openFile() {
		//open the file dialog
		FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
		fd.setVisible(true);
		
		//if fileDialog gets something
		if(fd.getFile()!=null) {
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();
			
			//changing the GUI title
			gui.window.setTitle(fileName + " - NotepadJ");
		}
		
		System.out.println("File opened: " + fileAddress + fileName);
		
		//to read the content, we use BufferedReader
		try {
			//you need the address to read a file
			BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
			
			//clear the textArea
			gui.textArea.setText("");
			
			//then read the lines of the file
			String line = null;
			
			while ((line = br.readLine())!= null) {
				
				gui.textArea.append(line + "\n");
				
			}
			
			br.close();
			
		}catch(Exception e) {
			System.out.println("FILE ISN'T OPENED!");
		}
	}
	
	public void save() {
		//this one usually overwrites the file
		
		//if the file isn't saved yet, just call SaveAs
		if(fileName==null) {
			saveAs();
		}else {
			//but if you just want to save the changes..
			try {
				
				FileWriter fw = new FileWriter(fileAddress + fileName);
				fw.write(gui.textArea.getText());
				gui.window.setTitle(fileName + " - NotepadJ");
				fw.close();
				
			}catch(Exception e) {
				System.out.println("CAN'T SAVE/OVERWRITE THE FILE!");
			}
			
		}
	}
	
	public void saveAs() {
		//open the file dialog
		FileDialog fd = new FileDialog(gui.window, "Save as", FileDialog.SAVE);
		fd.setVisible(true);
		
		if(fd.getFile()!=null){
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();
			
			gui.window.setTitle(fileName + " - NotepadJ");
		}
		
		try {
			//use FileWriter to get the text written inside TextArea and write to the file
			FileWriter fw = new FileWriter(fileAddress + fileName);
			fw.write(gui.textArea.getText());
			fw.close();
			
		}catch(Exception e) {
			System.out.println("CAN'T SAVE THE FILE!");
		}
	}
	
	public void exit() {
		System.exit(0);
	}
}
