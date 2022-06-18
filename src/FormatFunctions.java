import java.awt.Color;
import java.awt.Font;

public class FormatFunctions {
	GUI gui;
	Font arial, comicSansMS, timesNewRoman;
	
	public FormatFunctions(GUI gui) {
		this.gui = gui;
	}
	
	public void wordWrap() {
		
		if(gui.wordWrapOn==false) {
			gui.wordWrapOn=true;
			//this wraps lines in textAreas
			gui.textArea.setLineWrap(true);
			//this parameter as true, will always break lines between words
			gui.textArea.setWrapStyleWord(true);
			//change text
			gui.iWordWarp.setText("Word Wrap: [ON]");
			//change background
			gui.iWordWarp.setBackground(Color.CYAN);
		}else if(gui.wordWrapOn==true) {
			gui.wordWrapOn=false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWordWarp.setText("Word Wrap: [OFF]");
			gui.iWordWarp.setBackground(null);
		}
	}
	
	public void createFont(int fontSize) {
		
		//define fonts
		arial = new Font("Arial", Font.PLAIN, fontSize);
		comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
	}
}
