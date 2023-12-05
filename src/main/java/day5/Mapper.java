package day5;

import java.util.ArrayList;

public class Mapper {

	private ArrayList<Long> destinationStarts;
	private ArrayList<Long> sourceStarts;
	private ArrayList<Long> ranges;
	
	public Mapper(ArrayList<Long> destinationStarts, ArrayList<Long> sourceStarts, ArrayList<Long> ranges) {
		super();
		this.destinationStarts = destinationStarts;
		this.sourceStarts = sourceStarts;
		this.ranges = ranges;
	}

	protected ArrayList<Long> getDestinationStarts() {
		return destinationStarts;
	}

	protected ArrayList<Long> getSourceStarts() {
		return sourceStarts;
	}

	protected ArrayList<Long> getRanges() {
		return ranges;
	}

	@Override
	public String toString() {
		return "destinationStarts: " + destinationStarts + ", sourceStarts:  " + sourceStarts + ", ranges: " + ranges;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Mapper)) { return false; }
        Mapper other = (Mapper) obj;

        if(!this.destinationStarts.equals(other.destinationStarts)) { return false; }
        if(!this.sourceStarts.equals(other.sourceStarts)) { return false; }
        if(!this.ranges.equals(other.ranges)) { return false; }
        
        return true;
    }

}
