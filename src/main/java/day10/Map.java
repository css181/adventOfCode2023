package day10;

import java.util.ArrayList;

public class Map {

	private ArrayList<ArrayList<Location>> locations;
	private Location start;
	
	public Map(ArrayList<String> inputLines) {
		locations = new ArrayList<ArrayList<Location>>();
		for (int row=0; row<inputLines.size(); row++) {
			String line = inputLines.get(row);
			ArrayList<Location> curLocationRow = new ArrayList<Location>();
			char[] charList = line.toCharArray();
			for (int col=0; col<charList.length; col++) {
				Character symbol = charList[col];
				Location curLocation = new Location(symbol, new Coordinate(col, row));
				if(symbol=='S') {
					start = curLocation;
				}
				curLocationRow.add(curLocation);
			}
			locations.add(curLocationRow);
		}
	}
	
	public ArrayList<ArrayList<Location>> getLocations() {
		return locations;
	}
	public Location getStart() {
		return start;
	}
	
	@Override
	public String toString() {
		String print = "";
		for(int row=0; row<locations.size(); row++) {
			ArrayList<Location> curRow = locations.get(row);
			for(int col=0; col<curRow.size(); col++) {
				Location curLocation = curRow.get(col);
				print+= curLocation.getSymbol();
			}
			print+="\n";
		}
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

        if(!(obj instanceof Map)) { return false; }
        Map other = (Map) obj;

        if(!this.locations.equals(other.locations)) { return false; }
        
        return true;
    }

}
