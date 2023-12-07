package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hand implements Comparable<Hand>{

	private ArrayList<Card> cards;
	private int stregnth;
	private int bid;
	
	public Hand(ArrayList<Card> cards, int bid) {
		if(cards.size()!=5) {
			throw new RuntimeException("Hands must have 5 cards, not: " + cards.size());
		}
		this.cards = cards;
		this.stregnth = calculateStregnth();
		this.bid = bid;
	}

	public Hand(char card1, char card2, char card3, char card4, char card5) {
		this(new ArrayList<>(Arrays.asList(new Card(card1), new Card(card2), new Card(card3), new Card(card4), new Card(card5))), -1);
	}
	public Hand(char card1, char card2, char card3, char card4, char card5, int bid) {
		this(new ArrayList<>(Arrays.asList(new Card(card1), new Card(card2), new Card(card3), new Card(card4), new Card(card5))), bid);
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
		ArrayList<Card> sortedCards = new ArrayList<>(cards);
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
	private boolean isPair(ArrayList<Card> sortedCards, int i, int j) {
		return sortedCards.get(i).equals(sortedCards.get(j));
	}
	private boolean isPairXPair(ArrayList<Card> sortedCards) {
		return isPair(sortedCards, 0, 1) && isPair(sortedCards, 3, 4);
	}
	private boolean isXPairPair(ArrayList<Card> sortedCards) {
		return isPair(sortedCards, 1, 2) && isPair(sortedCards, 3, 4);
	}
	private boolean isPairPairX(ArrayList<Card> sortedCards) {
		return isPair(sortedCards, 0, 1) && isPair(sortedCards, 2, 3);
	}
	
	protected ArrayList<Card> getCards() {
		return cards;
	}
	protected int getStregnth() {
		return this.stregnth;
	}
	protected int getBid() {
		return this.bid;
	}

	@Override
	public String toString() {
		String hand = "";
		for (Card card : cards) {
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

        if(!(obj instanceof Hand)) { return false; }
        Hand other = (Hand) obj;

        if(!this.cards.equals(other.cards)) { return false; }
        
        return true;
    }
    
    //return -1 if <, 0 if =, 1 if >
    @Override
	public int compareTo(Hand o) {
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
