package day2;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import day2.pojos.Game;
import utilities.FileUtility;

public class GamesWithColorDicePulls {

	private static File file;
	private ArrayList<Game> games;
	public ArrayList<Game> getGames() {
		return games;
	}

	public static final int RED_MAX = 12;
	public static final int GREEN_MAX = 13;
	public static final int BLUE_MAX = 14;

	public GamesWithColorDicePulls() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		GamesWithColorDicePulls.file = file;
	}

	public void populateInput() {
		games = new ArrayList<Game>();
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String game : inputLines) {
			games.add(new Game(getId(game), getColorCountsFor("red", game), getColorCountsFor("green", game), getColorCountsFor("blue", game)));
		}
	}

	private int getId(String game) {
		int stop = game.indexOf(":");
		String id = game.substring(5,stop);
		return Integer.valueOf(id);
	}

	private ArrayList<Integer> getColorCountsFor(String color, String game) {
		ArrayList<Integer> returnVal = new ArrayList<>();
		game= game.substring(game.indexOf(":")+1);
		String[] pullLists = game.split(";");
		for (String pullList : pullLists) {
			int numOfColor = 0;
			String[] colorCounts = pullList.split(",");
			for (String colorCount : colorCounts) {
				colorCount = colorCount.trim();
				if(colorCount.contains(color)) {
					numOfColor = Integer.valueOf(colorCount.substring(0,colorCount.indexOf(" ")));
					break;
				}
			}
			returnVal.add(numOfColor);
		}
		return returnVal;
	}

	public int getSumOfPossibleGameIDs() {
		int sum = 0;
		for (Game game : games) {
			if(game.getIsPossible()) {
				sum+=game.getId();
			}
		}
		return sum;
	}

	public int getSumOfAllGamePowers() {
		int sum = 0;
		for (Game game : games) {
			sum+=game.getPower();
		}
		return sum;
	}


}
