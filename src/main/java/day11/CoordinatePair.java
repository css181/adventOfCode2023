package day11;

import java.util.ArrayList;

public class CoordinatePair {

	private Coordinate one;
	private Coordinate two;
	public CoordinatePair(Coordinate one, Coordinate two) {
		super();
		this.one = one;
		this.two = two;
	}
	protected Coordinate getOne() {
		return one;
	}
	protected Coordinate getTwo() {
		return two;
	}
	
	@Override
    public String toString() {
    	String print = one + " ~ " + two;
		return print;
    } 
	
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof CoordinatePair)) { return false; }
        CoordinatePair other = (CoordinatePair) obj;

        if(this.one.equals(other.one) && this.two.equals(other.two)) {
        	return true;
        }
        if(this.one.equals(other.two) && this.two.equals(other.one)) {
        	return true;
        }
        return false;
    }
    
	public Integer getDistance() {
		int distance = 0;
		if(one.getX()<two.getX()) {
			distance+=two.getX()-one.getX();
		} else {
			distance+=one.getX()-two.getX();
		}
		if(one.getY()<two.getY()) {
			distance+=two.getY()-one.getY();
		} else {
			distance+=one.getY()-two.getY();
		}
		return distance;
	}
	
	public long getDistance(ArrayList<Integer> rowsWithNoGalaxies, ArrayList<Integer> colsWithNoGalaxies, long rowsAndColsToAdd) {
		long distance = 0;
		rowsAndColsToAdd--;
		if(one.getX()<two.getX()) {
			distance+=two.getX()-one.getX();
			for(int x=one.getX()+1; x<=two.getX()-1; x++) {
				if(colsWithNoGalaxies.contains(x)) {
					distance+=rowsAndColsToAdd;
				}
			}
		} else {
			distance+=one.getX()-two.getX();
			for(int x=two.getX()+1; x<=one.getX()-1; x++) {
				if(colsWithNoGalaxies.contains(x)) {
					distance+=rowsAndColsToAdd;
				}
			}
		}
		if(one.getY()<two.getY()) {
			distance+=two.getY()-one.getY();
			for(int y=one.getY()+1; y<=two.getY()-1; y++) {
				if(rowsWithNoGalaxies.contains(y)) {
					distance+=rowsAndColsToAdd;
				}
			}
		} else {
			distance+=one.getY()-two.getY();
			for(int y=two.getY()+1; y<=one.getY()-1; y++) {
				if(rowsWithNoGalaxies.contains(y)) {
					distance+=rowsAndColsToAdd;
				}
			}
		}
		return distance;
	}
}
