package innitialDayToCloneFrom;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class DayX {

	private static File file;
	private ArrayList<Game> games;
	public ArrayList<Game> getGames() {
		return games;
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
