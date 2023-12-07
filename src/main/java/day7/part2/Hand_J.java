package day7.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hand_J implements Comparable<Hand_J>{

	private ArrayList<Card_J> cards;
	private int stregnth;
	private int bid;
	
	public Hand_J(ArrayList<Card_J> cards, int bid) {
		if(cards.size()!=5) {
			throw new RuntimeException("Hands must have 5 cards, not: " + cards.size());
		}
		this.cards = cards;
		this.stregnth = calculateStregnth();
		this.bid = bid;
	}

	public Hand_J(char card1, char card2, char card3, char card4, char card5) {
		this(new ArrayList<>(Arrays.asList(new Card_J(card1), new Card_J(card2), new Card_J(card3), new Card_J(card4), new Card_J(card5))), -1);
	}
	public Hand_J(char card1, char card2, char card3, char card4, char card5, int bid) {
		this(new ArrayList<>(Arrays.asList(new Card_J(card1), new Card_J(card2), new Card_J(card3), new Card_J(card4), new Card_J(card5))), bid);
	}
	
//	7 - Five of a kind, where all five cards have the same label: AAAAA
//	6 - Four of a kind, where four cards have the same label and one card has a different label: AA8AA
//	5 - Full house, where three cards have the same label, and the remaining two cards share a different label: 23332
//	4 - Three of a kind, where three cards have the same label, and the remaining two cards are each different from any other card in the hand: TTT98
//	3 - Two pair, where two cards share one label, two other cards share a second label, and the remaining card has a third label: 23432
//	2 - One pair, where two cards share one label, and the other three cards have a different label from the pair and each other: A23A4
//	1 - High card, where all cards' labels are distinct: 23456
	private int calculateStregnth() {
		int stregnth = 0;
		ArrayList<Card_J> sortedCards = new ArrayList<>(cards);
		Collections.sort(sortedCards);
		calculateCountsInHand(sortedCards);
		replaceJokers(sortedCards);
		Collections.sort(sortedCards);
		
		if(sortedCards.get(0).equals(sortedCards.get(4))) {
			stregnth = 7;
		}
		else if((sortedCards.get(0).equals(sortedCards.get(3))) || sortedCards.get(1).equals(sortedCards.get(4))) {
			stregnth = 6;
		}
		else if( (sortedCards.get(0).equals(sortedCards.get(1)) && sortedCards.get(2).equals(sortedCards.get(4)) ) ||
					(sortedCards.get(0).equals(sortedCards.get(2)) && sortedCards.get(3).equals(sortedCards.get(4))) ) {
			stregnth = 5;
		}
		else if( (sortedCards.get(0).equals(sortedCards.get(2))) ||
				(sortedCards.get(1).equals(sortedCards.get(3))) ||
				(sortedCards.get(2).equals(sortedCards.get(4)))) {
			stregnth = 4;
		}
		else if( isPairXPair(sortedCards) || isXPairPair(sortedCards) || isPairPairX(sortedCards) ) {
			stregnth = 3;
		}
		else if( isPair(sortedCards, 0,1) || isPair(sortedCards, 1,  2) || isPair(sortedCards, 2,  3) || isPair(sortedCards, 3,  4)) {
			stregnth = 2;
		} else {
			stregnth = 1;
		}
		return stregnth;
	}

	private void calculateCountsInHand(ArrayList<Card_J> sortedCards) {
		for(int index=0; index<sortedCards.size(); index++) {
			int count = 1;
			Card_J curCard = sortedCards.get(index);
			for(int check=0; check<sortedCards.size(); check++) {
				if(index==check) {
					//skip, same card
				} else {
					if(curCard.equals(sortedCards.get(check))) {
						count++;
					}
				}
			}
			sortedCards.get(index).setCountInHand(count);
		}
	}

	private void replaceJokers(ArrayList<Card_J> sortedCards) {
		if(sortedCards.equals(new ArrayList<>(Arrays.asList(new Card_J('J'), new Card_J('J'), new Card_J('J'), new Card_J('J'), new Card_J('J'))))) {
			return;//Do nothing for 5 J's.
		}
		int highestCount = -1;
		Card_J highestCountCard = null;
		for (Card_J card : sortedCards) {
			if((card.getCountInHand() > highestCount) && !card.equals(new Card_J('J'))) {
				highestCount = card.getCountInHand();
				highestCountCard = card;
			}
		}
		
		for (int x=0; x<sortedCards.size(); x++) {
			if(sortedCards.get(x).equals(new Card_J('J'))) {
				sortedCards.set(x, highestCountCard);
			}
		}
	}

	private boolean isPair(ArrayList<Card_J> sortedCards, int i, int j) {
		return sortedCards.get(i).equals(sortedCards.get(j));
	}
	private boolean isPairXPair(ArrayList<Card_J> sortedCards) {
		return isPair(sortedCards, 0, 1) && isPair(sortedCards, 3, 4);
	}
	private boolean isXPairPair(ArrayList<Card_J> sortedCards) {
		return isPair(sortedCards, 1, 2) && isPair(sortedCards, 3, 4);
	}
	private boolean isPairPairX(ArrayList<Card_J> sortedCards) {
		return isPair(sortedCards, 0, 1) && isPair(sortedCards, 2, 3);
	}
	
	public ArrayList<Card_J> getCards() {
		return cards;
	}
	public int getStregnth() {
		return this.stregnth;
	}
	public int getBid() {
		return this.bid;
	}

	@Override
	public String toString() {
		String hand = "";
		for (Card_J card : cards) {
			hand+=card.getLabel();
		}
		return hand + ", stregnth:  " + stregnth;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Hand_J)) { return false; }
        Hand_J other = (Hand_J) obj;

        if(!this.cards.equals(other.cards)) { return false; }
        
        return true;
    }
    
    //return -1 if <, 0 if =, 1 if >
    @Override
	public int compareTo(Hand_J o) {
		if(this.stregnth<o.getStregnth()) {
			return -1;
		}
		if(this.stregnth>o.getStregnth()) {
			return 1;
		}
		for(int pos=0; pos<this.cards.size(); pos++) {
			if(this.cards.get(pos).getValue() > o.getCards().get(pos).getValue()) {
				return 1;
			}
			if(this.cards.get(pos).getValue() < o.getCards().get(pos).getValue()) {
				return -1;
			}
		}
		return 0;
	}

}
