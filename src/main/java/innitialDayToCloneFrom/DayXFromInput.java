package innitialDayToCloneFrom;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class DayXFromInput {

	private static File file;
	private ArrayList<ArrayList<Character>> inputLines;
	public ArrayList<ArrayList<Character>> getInputLines() {
		return inputLines;
	}
	
	public DayXFromInput() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	
	protected void setFileToUse(File file) {
		DayXFromInput.file = file;
	}

	public void populateInput() {
		this.inputLines = FileUtility.convertFileToCharacterArray(file);
	}

}
