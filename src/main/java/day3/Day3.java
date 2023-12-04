package day3;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day3 {

	private static File file;
	private ArrayList<ArrayList<Character>> char2d;
	public ArrayList<ArrayList<Character>> getChar2d() {
		return char2d;
	}
	private ArrayList<Coordinate> allSymbolCoordinates;
	protected ArrayList<Coordinate> getAllSymbolCoordinates() {
		return allSymbolCoordinates;
	}

	public Day3() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day3.file = file;
	}

	public void populateInput() {
		char2d = FileUtility.convertFileToCharacterArray(file);
		allSymbolCoordinates = calculateAllSymbolsCoordinates();
	}

	public ArrayList<Coordinate> calculateAllSymbolsCoordinates() {
		allSymbolCoordinates = new ArrayList<Coordinate>();
		for(int row=1; row<char2d.size(); row++) {
			ArrayList<Character> charRow = char2d.get(row);
			for(int col=0; col<charRow.size(); col++) {
				if(isSymbol(char2d.get(row).get(col))) {
					allSymbolCoordinates.add(new Coordinate(col, row));
				}
			}
		}
		return allSymbolCoordinates;
	}
	
	private boolean isSymbol(Character character) {
		return (!isNumeric(character) && !character.equals('.'));
	}

	protected boolean isNumeric(Character character) {
	    if (character == null) {
	        return false;
	    }
	    try {
	        Double.parseDouble(character.toString());
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

	public int getNumberFromCoordinate(Coordinate coordinate) {
		if(!isNumeric(char2d.get(coordinate.getY()).get(coordinate.getX()))) {
			return -1; //Not numeric
		}
		Coordinate firstNumberCoordinate = findFirstNumberCoordinate(coordinate);
		Coordinate lastNumberCoordinate = findLastNumberCoordinate(coordinate);
		String number = "";
		for(int col=firstNumberCoordinate.getX(); col<=lastNumberCoordinate.getX(); col++) {
			number+=char2d.get(coordinate.getY()).get(col).toString();
		}
		return Integer.valueOf(number);
	}

	private Coordinate findFirstNumberCoordinate(Coordinate coordinate) {
		Coordinate first = coordinate;
		for(int col=coordinate.getX()-1; col>=0; col--) {
			if(isNumeric(char2d.get(coordinate.getY()).get(col))) {
				first = new Coordinate(col, coordinate.getY());
			} else {
				break;
			}
		}
		return first;
	}

	private Coordinate findLastNumberCoordinate(Coordinate coordinate) {
		Coordinate last = coordinate;
		for(int col=coordinate.getX()+1; col<char2d.get(0).size(); col++) {
			if(isNumeric(char2d.get(coordinate.getY()).get(col))) {
				last = new Coordinate(col, coordinate.getY());
			} else {
				break;
			}
		}
		return last;
	}

	public ArrayList<Integer> getAllNumbersAdjacentToSymbols() {
		ArrayList<Integer> allNumbersAdjacentToSymbols = new ArrayList<Integer>();
		for (Coordinate coordinate : allSymbolCoordinates) {
			lookAbove(coordinate, allNumbersAdjacentToSymbols);
			lookBelow(coordinate, allNumbersAdjacentToSymbols);
			lookLeft(coordinate, allNumbersAdjacentToSymbols);
			lookRight(coordinate, allNumbersAdjacentToSymbols);
		}
		return allNumbersAdjacentToSymbols;
	}

	private void lookAbove(Coordinate coordinate, ArrayList<Integer> allNumbersAdjacentToSymbols) {
		int startCol = coordinate.getX()>0 ? coordinate.getX()-1 : 0;
		int endCol = coordinate.getX()<char2d.get(0).size() ? coordinate.getX()+1 : char2d.get(0).size();
		for(int col=startCol; col<=endCol; col++) {
			Coordinate coordToLook = new Coordinate(col, coordinate.getY()-1);
			if(isNumeric(char2d.get(coordToLook.getY()).get(coordToLook.getX()))) {
				allNumbersAdjacentToSymbols.add(getNumberFromCoordinate(coordToLook));
				break;
			}
		}
	}
	private void lookBelow(Coordinate coordinate, ArrayList<Integer> allNumbersAdjacentToSymbols) {
		int startCol = coordinate.getX()>0 ? coordinate.getX()-1 : 0;
		int endCol = coordinate.getX()<char2d.get(0).size() ? coordinate.getX()+1 : char2d.get(0).size();
		for(int col=startCol; col<=endCol; col++) {
			Coordinate coordToLook = new Coordinate(col, coordinate.getY()+1);
			if(isNumeric(char2d.get(coordToLook.getY()).get(coordToLook.getX()))) {
				allNumbersAdjacentToSymbols.add(getNumberFromCoordinate(coordToLook));
				break;
			}
		}
	}
	private void lookLeft(Coordinate coordinate, ArrayList<Integer> allNumbersAdjacentToSymbols) {
		Coordinate coordToLook = new Coordinate(coordinate.getX()-1, coordinate.getY());
		if(isNumeric(char2d.get(coordToLook.getY()).get(coordToLook.getX()))) {
			allNumbersAdjacentToSymbols.add(getNumberFromCoordinate(coordToLook));
		}
	}
	private void lookRight(Coordinate coordinate, ArrayList<Integer> allNumbersAdjacentToSymbols) {
		Coordinate coordToLook = new Coordinate(coordinate.getX()+1, coordinate.getY());
		if(isNumeric(char2d.get(coordToLook.getY()).get(coordToLook.getX()))) {
			allNumbersAdjacentToSymbols.add(getNumberFromCoordinate(coordToLook));
		}
	}

	public long calculateSumOfAllNumbersAdjacentToSymbols() {
		long sum = 0;
		ArrayList<Integer> allNumbers = getAllNumbersAdjacentToSymbols();
		for (Integer number : allNumbers) {
			sum+=number;
		}
		return sum;
	}
}
