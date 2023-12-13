package day12;

import java.util.ArrayList;

public class SpringRecord {

	private ArrayList<Integer> damagedList;
	private ArrayList<Character> springs;
	
	public SpringRecord(ArrayList<Character> springs, ArrayList<Integer> damagedList) {
		this.damagedList = damagedList;
		this.springs = springs;
	}
	
	public ArrayList<Integer> getDamagedList() {
		return damagedList;
	}
	public void setDamagedList(ArrayList<Integer> list) {
		this.damagedList = list;
	}
	public ArrayList<Character> getSprings() {
		return springs;
	}
	public void setSprings(ArrayList<Character> springs) {
		this.springs = springs;
	}

	@Override
	public String toString() {
		return "damagedList: " + damagedList + ", springs:  " + springs;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof SpringRecord)) { return false; }
        SpringRecord other = (SpringRecord) obj;

        if(!this.damagedList.equals(other.damagedList)) { return false; }
        if(!this.springs.equals(other.springs)) { return false; }
        
        return true;
    }

}
