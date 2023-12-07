package day7.part2;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import utilities.FileUtility;

public class Day7_J {

	private static File file;
	private ArrayList<Hand_J> hands;
	public ArrayList<Hand_J> getHands() {
		return hands;
	}

	public Day7_J() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	public void setFileToUse(File file) {
		Day7_J.file = file;
	}

	public void populateInput() {
		hands = new ArrayList<Hand_J>();
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			ArrayList<Card_J> cards = new ArrayList<>();
			for(int charPos=0; charPos<5; charPos++) {
				cards.add(new Card_J(line.charAt(charPos)));
			}
			int bid = Integer.valueOf(line.substring(line.indexOf(" ") + 1));
			hands.add(new Hand_J(cards, bid));
		}
	}

	public ArrayList<Hand_J>  getRankOrderedHands() {
		ArrayList<Hand_J> rankOrderHands = new ArrayList<>(hands);
		Collections.sort(rankOrderHands);
		return rankOrderHands;
	}

	public long calculateTotalWinnings() {
		long total = 0;
		ArrayList<Hand_J> rankedHands = getRankOrderedHands();
		for(int index = 0; index<rankedHands.size(); index++) {
			Hand_J curHand = rankedHands.get(index);
			total+= curHand.getBid() * (index+1);
		}
		return total;
	}

}
