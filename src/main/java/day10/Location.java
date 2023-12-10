package day10;

public class Location {
	private char symbol;
	private Location aOption;
	private Location bOption;
	private boolean isStart;
	private Coordinate coordinate;
	private boolean isInLoop;
	
	public Location(char symbol, Coordinate coordinate) {
		super();
		this.symbol = symbol;
		this.coordinate = coordinate;
		this.isStart = (symbol=='S');
		this.isInLoop = false;
	}
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public Location getaOption() {
		return aOption;
	}
	public void setaOption(Location aOption) {
		this.aOption = aOption;
	}
	public Location getbOption() {
		return bOption;
	}
	public void setbOption(Location bOption) {
		this.bOption = bOption;
	}
	public boolean getIsStart() {
		return isStart;
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}
	public boolean getIsInLoop() {
		return isInLoop;
	}
	public void setIsInLoop(boolean isInLoop) {
		this.isInLoop = isInLoop;
	}

	@Override
	public String toString() {
		return "[" + String.valueOf(symbol) + "] ~ " + coordinate;
	}
	
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Location)) { return false; }
        Location other = (Location) obj;
        
        if(this.symbol != other.symbol) { return false; }
        if((this.aOption!=null) && (other.aOption!=null)) {
        	if(!this.aOption.getCoordinate().equals(other.aOption.getCoordinate())) { return false; }
        } else if ((this.aOption!=null && other.aOption==null) || (this.aOption==null && other.aOption!=null)) {
        	return false;
        }
        if((this.bOption!=null) && (other.bOption!=null)) {
        	if(!this.bOption.getCoordinate().equals(other.bOption.getCoordinate())) { return false; }
        } else if ((this.bOption!=null && other.bOption==null) || (this.bOption==null && other.bOption!=null)) {
        	return false;
        }
        
        return true;
    }
}
