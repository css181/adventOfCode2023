package day3;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class SymbolsAndGears {

	private static File file;
	private ArrayList<ArrayList<Character>> char2d;
	public ArrayList<ArrayList<Character>> getChar2d() {
		return char2d;
	}
	private ArrayList<Coordinate> allSymbolCoordinates;
	protected ArrayList<Coordinate> getAllSymbolCoordinates() {
		return allSymbolCoordinates;
	}
	private ArrayList<Coordinate> allGearCoordinates;
	protected ArrayList<Coordinate> getAllGearCoordinates() {
		return allGearCoordinates;
	}

	public SymbolsAndGears() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		SymbolsAndGears.file = file;
	}

	public void populateInput() {
		char2d = FileUtility.convertFileToCharacterArray(file);
		allSymbolCoordinates = calculateAllSymbolsCoordinates();
		allGearCoordinates = calculateAllGearCoordinates();
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

	public ArrayList<Coordinate> calculateAllGearCoordinates() {
		allGearCoordinates = new ArrayList<Coordinate>();
		for (Coordinate coordinate : allSymbolCoordinates) {
			if(isCoordinateGear(coordinate)) {
				allGearCoordinates.add(coordinate);
			}
		}
		return allGearCoordinates;
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
	
	private boolean isCoordinateGear(Coordinate coordinate) {
		ArrayList<Integer> allNumbersAdjacentToCoordinate = new ArrayList<Integer>();
		lookAbove(coordinate, allNumbersAdjacentToCoordinate);
		lookBelow(coordinate, allNumbersAdjacentToCoordinate);
		lookLeft(coordinate, allNumbersAdjacentToCoordinate);
		lookRight(coordinate, allNumbersAdjacentToCoordinate);
		return allNumbersAdjacentToCoordinate.size()==2;
	}

	private void lookAbove(Coordinate coordinate, ArrayList<Integer> allNumbersAdjacentToSymbols) {
		int startCol = coordinate.getX()>0 ? coordinate.getX()-1 : 0;
		int endCol = coordinate.getX()<char2d.get(0).size() ? coordinate.getX()+1 : char2d.get(0).size();
		for(int col=startCol; col<=endCol; col++) {
			Coordinate coordToLook = new Coordinate(col, coordinate.getY()-1);
			if(isNumeric(char2d.get(coordToLook.getY()).get(coordToLook.getX()))) {
				allNumbersAdjacentToSymbols.add(getNumberFromCoordinate(coordToLook));
				break; //So we don't add ##., .##, or ### multiple times
			}
		}
		//Check for potential #.#
		Coordinate coordToLook = new Coordinate(coordinate.getX(), coordinate.getY()-1);
		if(isNumberThenDotThenNumber(coordToLook)) {
			Coordinate additionalNumber = new Coordinate(coordinate.getX()+1, coordinate.getY()-1);
			allNumbersAdjacentToSymbols.add(getNumberFromCoordinate(additionalNumber));
		}
	}
	private boolean isNumberThenDotThenNumber(Coordinate coordToLook) {
		return isNumeric(char2d.get(coordToLook.getY()).get(coordToLook.getX()-1)) &&
				!isNumeric(char2d.get(coordToLook.getY()).get(coordToLook.getX())) &&
				isNumeric(char2d.get(coordToLook.getY()).get(coordToLook.getX()+1));
	}

	private void lookBelow(Coordinate coordinate, ArrayList<Integer> allNumbersAdjacentToSymbols) {
		int startCol = coordinate.getX()>0 ? coordinate.getX()-1 : 0;
		int endCol = coordinate.getX()<char2d.get(0).size() ? coordinate.getX()+1 : char2d.get(0).size();
		for(int col=startCol; col<=endCol; col++) {
			Coordinate coordToLook = new Coordinate(col, coordinate.getY()+1);
			if(isNumeric(char2d.get(coordToLook.getY()).get(coordToLook.getX()))) {
				allNumbersAdjacentToSymbols.add(getNumberFromCoordinate(coordToLook));
				break; //So we don't add ##., .##, or ### multiple times
			}
		}
		//Check for potential #.#
		Coordinate coordToLook = new Coordinate(coordinate.getX(), coordinate.getY()+1);
		if(isNumberThenDotThenNumber(coordToLook)) {
			Coordinate additionalNumber = new Coordinate(coordinate.getX()+1, coordinate.getY()+1);
			allNumbersAdjacentToSymbols.add(getNumberFromCoordinate(additionalNumber));
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

	public long getGearRatio(Coordinate coordinate) {
		ArrayList<Integer> allNumbersAdjacentToCoordinate = new ArrayList<Integer>();
		lookAbove(coordinate, allNumbersAdjacentToCoordinate);
		lookBelow(coordinate, allNumbersAdjacentToCoordinate);
		lookLeft(coordinate, allNumbersAdjacentToCoordinate);
		lookRight(coordinate, allNumbersAdjacentToCoordinate);
		if(allNumbersAdjacentToCoordinate.size()!=2) {
			throw new RuntimeException("'Gear' does not have 2 numbers, so it's not a gear");
		}
		return allNumbersAdjacentToCoordinate.get(0) * allNumbersAdjacentToCoordinate.get(1);
	}

	public long calculateSumOfAllGearRatios() {
		long sum = 0;
		for (Coordinate gear : allGearCoordinates) {
			sum+=getGearRatio(gear);
		}
		return sum;
	}

}
