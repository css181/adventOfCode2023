package day10;

import java.util.ArrayList;

import day10.Location.Status;

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

    public String printAllStatuses() {
		String print = "";
		for(int row=0; row<locations.size(); row++) {
			for(int col=0; col<locations.get(row).size(); col++) {
				Location location = locations.get(row).get(col);
				print+="[";
				switch (location.getStatus()) {
				case OUTSIDE: {
					print+="OUTSIDE";
					break;
				}
				case INSIDE: {
					print+="INSIDE ";
					break;
				}
				case LOOP: {
					print+=" LOOP  ";
					break;
				}
				case UNKNOWN: {
					print+="UNKNOWN";
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + location.getStatus());
				}
				print+="]";
			}
			print+="\n";
		}
		return print;
	}

	public Integer getNumOfInsideStatuses() {
		int total = 0;
		for(int row=0; row<locations.size(); row++) {
			for(int col=0; col<locations.get(row).size(); col++) {
				Location location = locations.get(row).get(col);
				if(location.getStatus()==Status.INSIDE)
					total++;
			}
		}
		return total;
	}

}
