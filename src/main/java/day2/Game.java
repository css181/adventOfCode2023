package day2;

import java.util.ArrayList;

public class Game {

	private int id;
	private ArrayList<Pull> pulls;
	private boolean isPossible;
	
	public Game(int id, ArrayList<Integer> reds, ArrayList<Integer> greens, ArrayList<Integer> blues) {
		if((reds.size() != greens.size()) && (reds.size() != blues.size())) {
			throw new RuntimeException("array sizes not equal");
		}
		this.id = id;
		ArrayList<Pull> pulls = new ArrayList<>();
		for (int pos=0; pos<reds.size(); pos++) {
			pulls.add(new Pull(reds.get(pos), greens.get(pos), blues.get(pos)));
		}
		this.pulls = pulls;
		this.isPossible = true;
		for (Pull pull : pulls) {
			if(pull.getReds()>Day2.RED_MAX) {
				this.isPossible = false;
				return;
			}
			if(pull.getGreens()>Day2.GREEN_MAX) {
				this.isPossible = false;
				return;
			}
			if(pull.getBlues()>Day2.BLUE_MAX) {
				this.isPossible = false;
				return;
			}
		}
	}
	
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected ArrayList<Pull> getPulls() {
		return pulls;
	}
	protected void setPulls(ArrayList<Pull> pulls) {
		this.pulls = pulls;
	}
	protected boolean getIsPossible() {
		return this.isPossible;
	}

	@Override
	public String toString() {
		return "id: " + id + ", Pulls:  " + pulls;
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
        if(!this.pulls.equals(other.pulls)) { return false; }
        if(this.isPossible != other.isPossible) { return false; }
        
        return true;
    }
}
