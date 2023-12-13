package day12;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day12 {

	private static File file;
	private ArrayList<SpringRecord> springRecords;
	public ArrayList<SpringRecord> getSpringRecords() {
		return springRecords;
	}

	public Day12() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day12.file = file;
	}

	public void populateInput() {
		springRecords = new ArrayList<SpringRecord>();
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			String[] lineHalfs = line.split(" ");
			ArrayList<Character> springs = new ArrayList<Character>();
			for (Character spring : lineHalfs[0].toCharArray()) {
				springs.add(spring);
			}
			ArrayList<Integer> damages = new ArrayList<Integer>();
			for (String group : lineHalfs[1].split(",")) {
				damages.add(Integer.valueOf(group));
			}
			springRecords.add(new SpringRecord(springs, damages));
		}
	}

	public ArrayList<ArrayList<Character>> getAllPotentialStringListsFromOneWithQuestionMarks(ArrayList<Character> sampleSpring) {
		ArrayList<ArrayList<Character>> allPotentials = new ArrayList<ArrayList<Character>>();
		ArrayList<Integer> questionIndexes = new ArrayList<Integer>();
		for (int index=0; index<sampleSpring.size(); index++) {
			Character symbol = sampleSpring.get(index);
			if(symbol=='?') {
				questionIndexes.add(index);
			}
		}
		ArrayList<Character> replacements = new ArrayList<Character>();
		for (@SuppressWarnings("unused") int index : questionIndexes) {
			replacements.add('.');
		}
		do {
			ArrayList<Character> curPossible = new ArrayList<Character>();
			int curQuestionIndex = 0;
			for(int pos=0; pos<sampleSpring.size(); pos++) {
				if(curQuestionIndex<questionIndexes.size() && questionIndexes.get(curQuestionIndex)==pos) {
					curPossible.add(replacements.get(curQuestionIndex++));
				} else {
					curPossible.add(sampleSpring.get(pos));
				}
			}
			allPotentials.add(curPossible);
			replacements = incrementReplacements(replacements);
		} while (replacements!=null);
		return allPotentials;
	}

	private ArrayList<Character> incrementReplacements(ArrayList<Character> replacements) {
		ArrayList<Character> incremented = replacements;
		for(int pos=replacements.size()-1; pos>=0; pos--) {
			if(incremented.get(pos)=='.') {
				incremented.set(pos, '#');
				break;
			}
			if(pos==0) {
				return null;//Can't increase all max.
			}
			incremented.set(pos, '.');//flip and keep going
		}
		return incremented;
	}

	public boolean isSpringListValidBasedOnDamagedList(ArrayList<Character> springList, ArrayList<Integer> damagedList) {
		ArrayList<Integer> groupSizes = new ArrayList<Integer>();
		int curGroupCount = 0;
		for(int pos=0; pos<springList.size(); pos++) {
			Character curChar = springList.get(pos);
			if(curChar=='.') {
				if(curGroupCount>0) {
					groupSizes.add(curGroupCount);
					curGroupCount=0;
				}
			} else {
				curGroupCount++;
			}
		}
		if(curGroupCount>0) {
			groupSizes.add(curGroupCount);
		}
		return damagedList.equals(groupSizes);
	}

	public Integer getNumOfValidPossiblesForSpringRecord(SpringRecord springRecord) {
		ArrayList<ArrayList<Character>> allPossible = getAllPotentialStringListsFromOneWithQuestionMarks(springRecord.getSprings());
		int validPossibles = 0;
		for (ArrayList<Character> possible : allPossible) {
			if(isSpringListValidBasedOnDamagedList(possible, springRecord.getDamagedList())) {
				validPossibles++;
			}
		}
		return validPossibles;
	}

	public Integer getTotalNumOfAllValidPossiblesForAllInputs() {
		int total = 0;
		for (SpringRecord springRecord : springRecords) {
			total+= getNumOfValidPossiblesForSpringRecord(springRecord);
		}
		return total;
	}

}
