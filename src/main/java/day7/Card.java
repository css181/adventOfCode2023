package day7;

public class Card implements Comparable<Card>{

	private int value;
	private char label;
	
	public Card(char label) {
		this.label = label;
		this.value = calcValue();
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
				val = 11;
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

	protected int getValue() {
		return value;
	}
	protected char getLabel() {
		return (char) this.label;
	}

	@Override
	public String toString() {
		return "value: " + value + ", label:  " + label;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Card)) { return false; }
        Card other = (Card) obj;

        if(this.value != other.value) { return false; }
        if(this.label != other.label) { return false; }
        
        return true;
    }

    //return -1 if <, 0 if =, 1 if >
	@Override
	public int compareTo(Card o) {
		if(this.value<o.value) {
			return -1;
		}
		if(this.value==o.value) {
			return 0;
		}
		return 1;
	}

}
