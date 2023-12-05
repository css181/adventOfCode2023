package day4;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day4 {

	private static File file;
	private ArrayList<Card> cards;
	public ArrayList<Card> getCards() {
		return cards;
	}

	public Day4() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day4.file = file;
	}

	public void populateInput() {
		cards = new ArrayList<Card>();
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (String line : inputLines) {
			cards.add(new Card(line));
		}
	}

	public long getPointTotalOfAllCards() {
		long sum = 0;
		for (Card card : cards) {
			sum+=card.getPoints();
		}
		return sum;
	}

	public void calculateCardInstancesFromWins() {
		for (int cardNum=0; cardNum<cards.size(); cardNum++) {
			Card curCard = cards.get(cardNum);
			for (int instance=0; instance<curCard.getInstances(); instance++) {
				for(int wins=1; wins<=curCard.getNumOfWins(); wins++) {
					Card nextCard = cards.get(cardNum+wins);
					nextCard.incrementInstances();
				}
			}
		}
	}

	public long getTotalInstancesOfAllCards() {
		long total = 0;
		for (Card card : cards) {
			total+=card.getInstances();
		}
		return total;
	}

}
