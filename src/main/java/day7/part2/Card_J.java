package day7.part2;

public class Card_J implements Comparable<Card_J>{

	private int value;
	private char label;
	private int countInHand;
	
	public Card_J(char label) {
		this.label = label;
		this.value = calcValue();
		this.countInHand = 1;
	}
	
	private int calcValue() {
		int val = -1;
		//TODO: find a better way than general catch
		try {
			val = Integer.parseInt(String.valueOf(label));;
		} catch (NumberFormatException e) {
			switch (String.valueOf(label)) {
			case "T": {
				val = 10;
				break;
			} case "J": {
				val = 1;
				break;
			} case "Q": {
				val = 12;
				break;
			} case "K": {
				val = 13;
				break;
			} case "A": {
				val = 14;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + label);
			}
		}
		return val;
	}

	public int getValue() {
		return value;
	}
	public char getLabel() {
		return (char) this.label;
	}
	protected int getCountInHand() {
		return countInHand;
	}
	protected void setCountInHand(int countInHand) {
		this.countInHand = countInHand;
	}

	@Override
	public String toString() {
		return String.valueOf(label);
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Card_J)) { return false; }
        Card_J other = (Card_J) obj;

        if(this.value != other.value) { return false; }
        if(this.label != other.label) { return false; }
        
        return true;
    }

    //return -1 if <, 0 if =, 1 if >
	@Override
	public int compareTo(Card_J o) {
		if(this.value<o.value) {
			return -1;
		}
		if(this.value==o.value) {
			return 0;
		}
		return 1;
	}

}
