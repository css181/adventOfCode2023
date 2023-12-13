package day11;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day11 {

	private static File file;
	private ArrayList<ArrayList<Character>> grid;
	public ArrayList<ArrayList<Character>> getGrid() {
		return grid;
	}

	public Day11() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day11.file = file;
	}

	public void populateInput() {
		grid = FileUtility.convertFileToCharacterArray(file);
	}

	public ArrayList<Integer> getRowsWithNoGalaxies() {
		ArrayList<Integer> rowsWitNoGalaxies = new ArrayList<Integer>();
		for(int row=0; row<grid.size(); row++) {
			boolean hasAtLeastOneGalaxy = false;
			for(int col=0; col<grid.get(row).size(); col++) {
				if(grid.get(row).get(col) == '#') {
					hasAtLeastOneGalaxy = true;
					break;
				}
			}
			if(!hasAtLeastOneGalaxy)
				rowsWitNoGalaxies.add(row);
		}
		return rowsWitNoGalaxies;
	}

	public ArrayList<Integer> getColsWithNoGalaxies() {
		ArrayList<Integer> colsWitNoGalaxies = new ArrayList<Integer>();
		for(int col=0; col<grid.get(0).size(); col++) {
			boolean hasAtLeastOneGalaxy = false;
			for(int row=0; row<grid.size(); row++) {
				if(grid.get(row).get(col) == '#') {
					hasAtLeastOneGalaxy = true;
					break;
				}
			}
			if(!hasAtLeastOneGalaxy)
				colsWitNoGalaxies.add(col);
		}
		return colsWitNoGalaxies;
	}

	public void expandGridForNoGalaxyRowsAndCols() {
		ArrayList<ArrayList<Character>> newGrid = new ArrayList<ArrayList<Character>>();
		ArrayList<Integer> noGalaxyRows = getRowsWithNoGalaxies();
		for(int row=0; row<grid.size(); row++) {
			ArrayList<Character> curRow = grid.get(row);
			newGrid.add(curRow);
			if(noGalaxyRows.contains(row)) {
				newGrid.add(curRow);
			}
		}
		ArrayList<Integer> noGalaxyCols = getColsWithNoGalaxies();
		int colCount = newGrid.get(0).size();
		int addedCount = 0;
		for(int col=0; col<colCount; col++) {
			if(noGalaxyCols.contains(col)) {
				newGrid = addDotForEachRowInColToNewGrid(col, addedCount++, newGrid);
			}
		}
		grid = newGrid;
	}

	private ArrayList<ArrayList<Character>> addDotForEachRowInColToNewGrid(int colToAdd, int alreadyAdded, ArrayList<ArrayList<Character>> grid) {
		ArrayList<ArrayList<Character>> newGrid = new ArrayList<ArrayList<Character>>();
		for (int curRow=0; curRow<grid.size(); curRow++) {
			ArrayList<Character> newRow = new ArrayList<Character>();
			ArrayList<Character> row = grid.get(curRow);
			for(int curCol=0; curCol<row.size(); curCol++) {
				newRow.add(row.get(curCol));
				if(curCol==(colToAdd+alreadyAdded)) {
					newRow.add('.');
				}
			}
			newGrid.add(newRow);
		}
		return newGrid;
	}

	public String printGrid(ArrayList<ArrayList<Character>> grid) {
		String print = "";
		for(int row=0; row<grid.size(); row++) {
			for(int col=0; col<grid.get(row).size(); col++) {
				print+=grid.get(row).get(col);
			}
			print+="\n";
		}
		return print;
	}

	public ArrayList<Coordinate> getAllGalaxyCoordinates() {
		expandGridForNoGalaxyRowsAndCols();
		ArrayList<Coordinate> galaxyCoordinates = new ArrayList<Coordinate>();
		for(int row=0; row<grid.size(); row++) {
			for(int col=0; col<grid.get(row).size(); col++) {
				if(grid.get(row).get(col) == '#') {
					galaxyCoordinates.add(new Coordinate(col, row));
				}
			}
		}
		return galaxyCoordinates;
	}

	public ArrayList<CoordinatePair> getAllGalaxyPairs() {
		ArrayList<CoordinatePair> galaxyPairs = new ArrayList<CoordinatePair>();
		ArrayList<Coordinate> allGalaxies = getAllGalaxyCoordinates();
		for(int oneIndex=0; oneIndex<allGalaxies.size(); oneIndex++) {
			Coordinate one = allGalaxies.get(oneIndex);
			for(int twoIndex=oneIndex+1; twoIndex<allGalaxies.size(); twoIndex++) {
				Coordinate two = allGalaxies.get(twoIndex);
				galaxyPairs.add(new CoordinatePair(one, two));
			}
		}
		return galaxyPairs;
	}

	public Long getTotalDistanceOfAllGalaxies() {
		long totalDistance = 0;
		ArrayList<CoordinatePair> galaxyPairs = getAllGalaxyPairs();
		for (CoordinatePair coordinatePair : galaxyPairs) {
			totalDistance+=coordinatePair.getDistance();
		}
		return totalDistance;
	}
}
