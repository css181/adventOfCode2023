package day5;

import java.util.ArrayList;

public class Game {

	private int id;
	private boolean isPossible;
	
	public Game(Integer id, ArrayList<Integer> reds, ArrayList<Integer> greens, ArrayList<Integer> blues) {
		this.id = id;
		this.isPossible = true;
	}
	
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected boolean getIsPossible() {
		return this.isPossible;
	}

	@Override
	public String toString() {
		return "id: " + id + ", isPossible:  " + isPossible;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Game)) { return false; }
        Game other = (Game) obj;

        if(this.id != other.id) { return false; }
        if(this.isPossible != other.isPossible) { return false; }
        
        return true;
    }

}
