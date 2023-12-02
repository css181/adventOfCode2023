package day1;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day1 {

	private static File file;
	private ArrayList<ArrayList<Character>> inputLines;
	public ArrayList<ArrayList<Character>> getInputLines() {
		return inputLines;
	}

	private ArrayList<Integer> firstNumbers;
	public ArrayList<Integer> getFirstNumbers() {
		return firstNumbers;
	}

	private ArrayList<Integer> lastNumbers;
	public ArrayList<Integer> getLastNumbers() {
		return lastNumbers;
	}

	private ArrayList<Integer> twoDigitNumbers;
	public ArrayList<Integer> getTwoDigitNumbers() {
		return twoDigitNumbers;
	}
	
	public Day1() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day1.file = file;
	}

	public void populateInput() {
		this.inputLines = FileUtility.convertFileToCharacterArray(file);
		this.firstNumbers = new ArrayList<>();
		this.lastNumbers = new ArrayList<>();
		this.twoDigitNumbers = new ArrayList<>();
	}

	public void calculateFirstNumbers() {
		for (ArrayList<Character> charList : inputLines) {
			for (int pos = 0; pos < charList.size(); pos++) {
				if (!Character.isAlphabetic(charList.get(pos))) {
					int num = Character.getNumericValue(charList.get(pos));
					firstNumbers.add(num);
					break;
				}
			}
		}
	}

	public void calculateLastNumbers() {
		for (ArrayList<Character> charList : inputLines) {
			for (int pos = charList.size()-1; pos >=0; pos--) {
				if (!Character.isAlphabetic(charList.get(pos))) {
					int num = Character.getNumericValue(charList.get(pos));
					lastNumbers.add(num);
					break;
				}
			}
		}
	}

	public void calculateTwoDigitNumbers() {
		calculateFirstNumbers();
		calculateLastNumbers();
		if(firstNumbers.size()!=lastNumbers.size()) {
			throw new RuntimeException("Invalid sizes of lists");
		}
		for (int pos=0; pos<firstNumbers.size(); pos++) {
			String number = firstNumbers.get(pos).toString() + lastNumbers.get(pos).toString();
			twoDigitNumbers.add(Integer.valueOf(number));
		}
	}

	public long addAllTwoDigitNumbers() {
		calculateTwoDigitNumbers();
		long sum = 0;
		for (Integer twoDigitNum : twoDigitNumbers) {
			sum+=twoDigitNum;
		}
		return sum;
	}

}
