import java.awt.FileDialog;

public class FileFunctions {
	GUI gui;
	
	public FileFunctions(GUI gui) {
		this.gui = gui;
	}
	
	public void newFile() {
		//erase the current text
		gui.textArea.setText("");
		gui.window.setTitle("New File - NotepadJ");
	}
	
	public void openFile() {
		//open the file dialog
		FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
		fd.setVisible(true);
	}
}
