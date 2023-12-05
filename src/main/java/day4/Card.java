package day4;

import java.util.ArrayList;

public class Card {

	int id;
	private ArrayList<Integer> winningNums;
	private ArrayList<Integer> myNums;
	private int points;
	private int instances;
	
	public Card(String inputLine) {
		int start = inputLine.indexOf(" ");
		int end = inputLine.indexOf(":");
		this.id = Integer.valueOf(inputLine.substring(start, end).trim());
		start = end+1;
		end = inputLine.indexOf("|")-1;
		String winningString = inputLine.substring(start, end);
		String[] winningList = winningString.split(" ");
		this.winningNums = new ArrayList<>();
		for (String winningNum : winningList) {
			if(winningNum.length()>0)
				this.winningNums.add(Integer.valueOf(winningNum.trim()));
		}
		start = end+2;
		String myString = inputLine.substring(start);
		String[] myList = myString.split(" ");
		this.myNums = new ArrayList<>();
		for (String myNum : myList) {
			if(myNum.length()>0)
				this.myNums.add(Integer.valueOf(myNum.trim()));
		}
		this.points = 0;
		calculatePoints();
		this.instances=1;
	}
	public Card(int id, ArrayList<Integer> winningNums, ArrayList<Integer> myNums) {
		super();
		this.id = id;
		this.winningNums = winningNums;
		this.myNums = myNums;
	}


	protected int getId() {
		return id;
	}
	protected ArrayList<Integer> getWinningNums() {
		return winningNums;
	}
	protected ArrayList<Integer> getMyNums() {
		return myNums;
	}
	@Override
	public String toString() {
		return "id: " + id + ", wins:  " + getNumOfWins() + ", instances: " + instances;
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

        if(this.id != other.id) { return false; }
        if(!this.winningNums.equals(other.winningNums)) { return false; }
        if(!this.myNums.equals(other.myNums)) { return false; }
        
        return true;
    }
    
	public int getNumOfWins() {
		int numOfWins = 0;
		for (Integer myNum : myNums) {
			for (Integer winNum : winningNums) {
				if(myNum==winNum) {
					numOfWins++;
				}
			}
		}
		return numOfWins;
	}
	
	public int getPoints() {
		return this.points;
	}

	public void calculatePoints() {
		for(int x=0; x<getNumOfWins(); x++) {
			if(this.points==0) {
				this.points=1;
			} else {
				this.points*=2;
			}
		}
	}
	public int getInstances() {
		return instances;
	}
	public void incrementInstances() {
		this.instances++;
	}
}
