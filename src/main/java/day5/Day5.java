package day5;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day5 {

	private static File file;
	private ArrayList<Long> seeds;
	protected ArrayList<Long> getSeeds() {
		return seeds;
	}
	private ArrayList<Mapper> mappers;
	public ArrayList<Mapper> getMappers() {
		return mappers;
	}

	public Day5() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput_Part1();
	}

	protected void setFileToUse(File file) {
		Day5.file = file;
	}

	public void populateInput_Part1() {
		ArrayList<String> inputLines = populateInputCommon();
		String[] seedsString = inputLines.get(0).substring(7).split(" ");
		for (String seed : seedsString) {
			seeds.add(Long.valueOf(seed));
		}
	}

	private ArrayList<String> populateInputCommon() {
		seeds = new ArrayList<Long>();
		mappers = new ArrayList<Mapper>();
		ArrayList<Long> curDestinationStarts = new ArrayList<Long>();
		ArrayList<Long> curSourceStarts = new ArrayList<Long>();
		ArrayList<Long> curRanges = new ArrayList<Long>();
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		for (int line=3; line<inputLines.size(); line++) {
			String curLine = inputLines.get(line);
			if(curLine.length()==0) {
				//set the mapper on this blank line
				mappers.add(new Mapper(curDestinationStarts, curSourceStarts, curRanges));
				curDestinationStarts = new ArrayList<Long>();
				curSourceStarts = new ArrayList<Long>();
				curRanges = new ArrayList<Long>();
				//skip the next line which is a source-to-destination-mapping String
				line++;
			} else {
				String[] threeNums = curLine.split(" ");
				if(threeNums.length!=3) {
					throw new RuntimeException("Lines must have 3 nums, Line [" + line + "] this has" + threeNums.length);
				}
				curDestinationStarts.add(Long.valueOf(threeNums[0]));
				curSourceStarts.add(Long.valueOf(threeNums[1]));
				curRanges.add(Long.valueOf(threeNums[2]));
			}
		}
		//Add the last mapper
		mappers.add(new Mapper(curDestinationStarts, curSourceStarts, curRanges));
		return inputLines;
	}

	public void populateInput_Part2() {
		ArrayList<String> inputLines = populateInputCommon();
		String[] seedsString = inputLines.get(0).substring(7).split(" ");
		for (int index=0; index<seedsString.length-1; index+=2) {
			long seedStart = Long.valueOf(seedsString[index]);
			long seedEnd = seedStart + Long.valueOf(seedsString[index+1]);
			for(long newSeed=seedStart; newSeed<seedEnd; newSeed++) {
				seeds.add(newSeed);
			}
		}
	}

	public long processMapping(Long source, Mapper mapper) {
		long destination = source;
		for (int index = 0; index<mapper.getSourceStarts().size(); index++) {
			long start = mapper.getSourceStarts().get(index);
			long end = start + mapper.getRanges().get(index) - 1;
			if(source>=start && source<=end) {
				destination = mapper.getDestinationStarts().get(index) + (source-start);
				break;
			}
		}
		return destination;
	}

	public long determineLowestFinalLocation() {
		long minLocation = Long.MAX_VALUE;
		for (long seed : seeds) {
			long curSeedLocation = seed;
			for (Mapper mapper : mappers) {
				curSeedLocation = processMapping(curSeedLocation, mapper);
			}
			if(curSeedLocation<minLocation) {
				minLocation = curSeedLocation;
			}
		}
		return minLocation;
	}

	public long doItAll() {
		ArrayList<String> inputLines = populateInputCommon();
		ArrayList<Long> seedStarts = new ArrayList<>();
		ArrayList<Long> seedEnds = new ArrayList<>();
		String[] seedsString = inputLines.get(0).substring(7).split(" ");
		for (int index=0; index<seedsString.length-1; index+=2) {
			long seedStart = Long.valueOf(seedsString[index]);
			long seedEnd = seedStart + Long.valueOf(seedsString[index+1]) - 1;
			seedStarts.add(seedStart);
			seedEnds.add(seedEnd);
		}
		long minLocation = Long.MAX_VALUE;
		String minFlow = "";
		for (int index=0; index<seedStarts.size(); index++) {
			long counter = 0;
			long curSeed = seedStarts.get(index)+counter;
			do {
				curSeed = seedStarts.get(index)+counter;
				System.out.println("seed: " + curSeed + " ~ " + (seedEnds.get(index) - curSeed) + " left, In list " + String.valueOf(index+1) + " of " + seedStarts.size()
						+ "curMinLocation: " + minLocation);
				
				long curSeedLocation = curSeed;
				String curFlow = curSeedLocation + "->";
				for (Mapper mapper : mappers) {
					curSeedLocation = processMapping(curSeedLocation, mapper);
					curFlow+= curSeedLocation + "->";
				}
				if(curSeedLocation<minLocation) {
					minLocation = curSeedLocation;
					minFlow = curFlow.substring(0, curFlow.length()-2);
				}
				counter++;
			} while (curSeed<seedEnds.get(index));
		}
		System.out.println(minFlow);
		System.out.println("Answer: " + minLocation);
		return minLocation;
	}


}
