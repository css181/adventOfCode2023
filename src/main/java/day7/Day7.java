package day7;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import utilities.FileUtility;

public class Day7 {

	private static File file;
	private ArrayList<Hand> hands;
	public ArrayList<Hand> getHands() {
		return hands;
	}

	public Day7() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day7.file = file;
	}

	public void populateInput() {
		hands = new ArrayList<Hand>();
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			ArrayList<Card> cards = new ArrayList<>();
			for(int charPos=0; charPos<5; charPos++) {
				cards.add(new Card(line.charAt(charPos)));
			}
			int bid = Integer.valueOf(line.substring(line.indexOf(" ") + 1));
			hands.add(new Hand(cards, bid));
		}
	}

	public ArrayList<Hand>  getRankOrderedHands() {
		ArrayList<Hand> rankOrderHands = new ArrayList<>(hands);
		Collections.sort(rankOrderHands);
		return rankOrderHands;
	}

	public long calculateTotalWinnings() {
		long total = 0;
		ArrayList<Hand> rankedHands = getRankOrderedHands();
		for(int index = 0; index<rankedHands.size(); index++) {
			Hand curHand = rankedHands.get(index);
			total+= curHand.getBid() * (index+1);
		}
		return total;
	}

}
