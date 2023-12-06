package day6;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day6 {

	private static File file;
	private ArrayList<Race> races;
	public ArrayList<Race> getRaces() {
		return races;
	}

	public Day6() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day6.file = file;
	}

	public void populateInput() {
		races = new ArrayList<Race>();
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		String[] times = inputLines.get(0).substring(6).split(" ");
		String[] distances = inputLines.get(1).substring(10).split(" ");
		ArrayList<Integer> timesList = new ArrayList<Integer>();
		ArrayList<Integer> distanceList = new ArrayList<Integer>();
		for (String time : times) {
			if(time.length()>0) {
				timesList.add(Integer.valueOf(time));
			}
		}
		for(String distance: distances) {
			if(distance.length()>0) {
				distanceList.add(Integer.valueOf(distance));
			}
		}
		if(timesList.size()!=distanceList.size()) {
			throw new RuntimeException("Times and Distances are different sizes.");
		}
		for(int index=0; index<timesList.size(); index++) {
			races.add(new Race(timesList.get(index), distanceList.get(index)));
		}
	}

	public int calculateNumOfWaysToBreakRecordForRace(Race race) {
		int winCount=0;
		int time = race.getTime();
		for(int pushSeconds=0; pushSeconds<race.getTime(); pushSeconds++) {
			int totalDistance = pushSeconds	* (time-pushSeconds);
			if(totalDistance>race.getDistance()) {
				winCount++;
			}
		}
		return winCount;
	}

	public long calcMarginOfErrorForAllRaces() {
		long margin = 1;
		for (Race race : races) {
			margin *= calculateNumOfWaysToBreakRecordForRace(race);
		}
		return margin;
	}

}
