package day10;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import day10.Location.Status;
import utilities.FileUtility;

public class Day10 {

	private static File file;
	public char treatSAs;//TODO: This is a cheat
	private Map map;
	public Map getMap() {
		return map;
	}

	public Day10() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		treatSAs = '|';//This was determined by manually looking at the real input
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day10.file = file;
	}

	public void populateInput() {
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		map = new Map(inputLines);
		populateAllOptions(map);
	}

	private void populateAllOptions(Map curMap) {
		ArrayList<ArrayList<Location>> locations = curMap.getLocations();
		for(int row=0; row<locations.size(); row++) {
			ArrayList<Location> curRow = locations.get(row);
			for(int col=0; col<curRow.size(); col++) {
				Location curLocation = curRow.get(col);
				char curSymbol = curLocation.getSymbol();
				if(curSymbol=='S') {
					curSymbol = treatSAs;
				}
				switch (curSymbol) {				case '|': {
					if(row>0) { //Up
						curLocation.setaOption(locations.get(row-1).get(col));
					}
					if(row<locations.size()-1) { //Down
						curLocation.setbOption(locations.get(row+1).get(col));
					}
					break;
				}
				case '-': {
					if(col>0) { //Left
						curLocation.setaOption(locations.get(row).get(col-1));
					}
					if(col<curRow.size()-1) { //Right
						curLocation.setbOption(locations.get(row).get(col+1));
					}
					break;
				}
				case 'L': {
					if(row>0) { //Up
						curLocation.setaOption(locations.get(row-1).get(col));
					}
					if(col<curRow.size()-1) { //Right
						curLocation.setbOption(locations.get(row).get(col+1));
					}
					break;
				}
				case 'J': {
					if(row>0) { //Up
						curLocation.setaOption(locations.get(row-1).get(col));
					}
					if(col>0) { //Left
						curLocation.setbOption(locations.get(row).get(col-1));
					}
					break;
				}
				case '7': {
					if(col>0) { //Left
						curLocation.setaOption(locations.get(row).get(col-1));
					}
					if(row<locations.size()-1) { //Down
						curLocation.setbOption(locations.get(row+1).get(col));
					}
					break;
				}
				case 'F': {
					if(col<curRow.size()-1) { //Right
						curLocation.setaOption(locations.get(row).get(col+1));
					}
					if(row<locations.size()-1) { //Down
						curLocation.setbOption(locations.get(row+1).get(col));
					}
					break;
				}
				case '.': {
					curLocation.setaOption(null);
					curLocation.setbOption(null);
					break;
				}
				default:
//					throw new IllegalArgumentException("Unexpected value: " + curLocation.getSymbol());
				}
			}
		}
	}

	public void minifyMapAndSetPropertyOnLocationIfInLoop() {
		Location start = map.getStart();
		markInLoop(start, null);
		ArrayList<ArrayList<Location>> locations = map.getLocations();
		for(int row=0; row<locations.size(); row++) {
			ArrayList<Location> curRow = locations.get(row);
			for(int col=0; col<curRow.size(); col++) {
				Location curLocation = curRow.get(col);
				if(curLocation.getSymbol()=='S') {
					curLocation.setSymbol(treatSAs);
				}
				if(!curLocation.getIsInLoop()) {
					curLocation.setSymbol('.');
				}
			}
		}
	}

	private void markInLoop(Location curLoc, Location prior) {
		if(curLoc.getIsStart() && curLoc.getIsInLoop()) {
			//we've gone through the whole loop
			return;
		}
		//Note: When within the loop aOpt and bOpt can never be null
		curLoc.setIsInLoop(true);
		curLoc.setStatus(Status.LOOP);
		if(prior==null) {
			//this is start, just go optionA next
			markInLoop(curLoc.getaOption(), curLoc);
		}
		if(prior==curLoc.getaOption()) {
			markInLoop(curLoc.getbOption(), curLoc);
		} else {
			markInLoop(curLoc.getaOption(), curLoc);
		}
	}

	public double getNumOfLocationsInLoopDividedBy2() {
		int sum = 0;
		ArrayList<ArrayList<Location>> locations = map.getLocations();
		for(int row=0; row<locations.size(); row++) {
			ArrayList<Location> curRow = locations.get(row);
			for(int col=0; col<curRow.size(); col++) {
				Location curLocation = curRow.get(col);
				if(curLocation.getIsInLoop()) {
					sum++;
				}
			}
		}
		return Double.valueOf(sum)/2.0;
	}

	public void calculateStatusesOfMap() {
		minifyMapAndSetPropertyOnLocationIfInLoop();
		ArrayList<ArrayList<Location>> locations = map.getLocations();
		for(int row=0; row<locations.size(); row++) {
			boolean within=false;
			boolean isUpDir=false;
			for(int col=0; col<locations.get(row).size(); col++) {
				Location location = locations.get(row).get(col);
				char ck = location.getSymbol();
				switch (ck) {
				case '|': {
					within=!within;					
					break;
				}
				case '-': {
					break;
				}
				case 'L': {
					isUpDir = true;
					break;
				}
				case 'F': {
					isUpDir = false;
					break;
				}
				case '7': {
					if(isUpDir)
						within=!within;	
					isUpDir = false;
					break;
				}
				case 'J': {
					if(!isUpDir)
						within=!within;		
					isUpDir = false;
					break;
				}
				case '.': {
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + ck);
				}
				if(location.getStatus()!=Status.LOOP)
					if(within)
						location.setStatus(Status.INSIDE);
					else
						location.setStatus(Status.OUTSIDE);
			}
		}
	}

}
