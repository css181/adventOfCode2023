package day6;

public class Race {

	private int time;
	private int distance;
	
	public Race(int time, int distance) {
		super();
		this.time = time;
		this.distance = distance;
	}
	protected int getTime() {
		return time;
	}
	protected void setTime(int time) {
		this.time = time;
	}
	protected int getDistance() {
		return this.distance;
	}

	@Override
	public String toString() {
		return "time: " + time + ", distance:  " + distance;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Race)) { return false; }
        Race other = (Race) obj;

        if(this.time != other.time) { return false; }
        if(this.distance != other.distance) { return false; }
        
        return true;
    }

}
