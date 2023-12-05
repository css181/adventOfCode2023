package day5;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day5 {

	private static File file;
	private ArrayList<Game> games;
	public ArrayList<Game> getGames() {
		return games;
	}

	public Day5() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day5.file = file;
	}

	public void populateInput() {
		games = new ArrayList<Game>();
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			games.add(createPOJO_FromInputLine(line));
		}
	}

	private Game createPOJO_FromInputLine(String line) {
		return new Game(0, null, null, null);
	}
}
