package day1;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day1FromInput {

	private static File file;
	private ArrayList<ArrayList<Character>> inputLines;
	public ArrayList<ArrayList<Character>> getInputLines() {
		return inputLines;
	}
	
	public Day1FromInput() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}
	
	protected void setFileToUse(File file) {
		Day1FromInput.file = file;
	}

	public void populateInput() {
		this.inputLines = FileUtility.convertFileToCharacterArray(file);
	}

}
