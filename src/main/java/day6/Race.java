package day6;

public class Race {

	private long time;
	private long distance;
	
	public Race(long time, long distance) {
		super();
		this.time = time;
		this.distance = distance;
	}
	protected long getTime() {
		return time;
	}
	protected void setTime(long time) {
		this.time = time;
	}
	protected long getDistance() {
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
