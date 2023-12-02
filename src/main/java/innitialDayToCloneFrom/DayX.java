package innitialDayToCloneFrom;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class DayX {

	private static File file;
	private ArrayList<ArrayList<Character>> inputLines;
	public ArrayList<ArrayList<Character>> getInputLines() {
		return inputLines;
	}
	
	public DayX() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	
	protected void setFileToUse(File file) {
		DayX.file = file;
	}

	public void populateInput() {
		this.inputLines = FileUtility.convertFileToCharacterArray(file);
	}

}
