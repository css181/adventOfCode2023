package day9;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day9 {

	private static File file;
	private ArrayList<ArrayList<Long>> input;
	public ArrayList<ArrayList<Long>> getInput() {
		return input;
	}

	public Day9() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day9.file = file;
	}

	public void populateInput() {
		input = new ArrayList<ArrayList<Long>>();
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			String[] innerList = line.split(" ");
			ArrayList<Long> curInnerList = new ArrayList<Long>();
			for (String innerNum : innerList) {
				curInnerList.add(Long.valueOf(innerNum));
			}
			input.add(curInnerList);
		}
	}

	public ArrayList<ArrayList<Long>> getTreeBreakdownForInputLine(ArrayList<Long> arrayList) {
		ArrayList<ArrayList<Long>> treeBreakdown = new ArrayList<ArrayList<Long>>();
		treeBreakdown.add(arrayList);
		ArrayList<Long> curList = arrayList;
		ArrayList<Long> nextList;
		do {
			nextList = new ArrayList<Long>();
			for(int pos=1; pos<curList.size(); pos++) {
				nextList.add(curList.get(pos) - curList.get(pos-1));
			}
			treeBreakdown.add(nextList);
			curList = nextList;
		} while (!everyElementIsZero(nextList));
		return treeBreakdown;
	}

	private boolean everyElementIsZero(ArrayList<Long> nextList) {
		for (Long elem : nextList) {
			if(elem!=0) {
				return false;
			}
		}
		return true;
	}

	public Long getPredictionFromTreeBreakdown(ArrayList<ArrayList<Long>> treeBreakdown) {
		long curPrediction = -1;
		for(int lineIndex=treeBreakdown.size()-1; lineIndex>=1; lineIndex--) {
			ArrayList<Long> curLine = treeBreakdown.get(lineIndex);
			ArrayList<Long> priorLine = treeBreakdown.get(lineIndex-1);
			int lastElemCurLine = curLine.size()-1;
			int lastElemPriorLine = priorLine.size()-1;
			curPrediction = priorLine.get(lastElemPriorLine) + curLine.get(lastElemCurLine);
			treeBreakdown.get(lineIndex-1).add(curPrediction);
		}
		return curPrediction;
	}

	public Long getSumOfAllPredictions() {
		long sum = 0;
		for (ArrayList<Long> line : input) {
			ArrayList<ArrayList<Long>> curTreeBreakdown = getTreeBreakdownForInputLine(line);
			Long curPrediction = getPredictionFromTreeBreakdown(curTreeBreakdown);
			sum+=curPrediction;
		}
		return sum;
	}

}
