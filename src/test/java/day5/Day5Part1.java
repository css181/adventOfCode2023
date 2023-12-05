package day5;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day5Part1 {

	private Day5 day5;
	
	@BeforeEach
	public void setup() {
		day5 = new Day5();
	}
	private void useSampleImput() {
		day5.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day5.populateInput();
	}

	@Test 
	void convertFileToSeedsAndMappers() {
		useSampleImput();
		ArrayList<Long> expectedSeeds = new ArrayList<Long>(Arrays.asList(79l,14l,55l,13l));
		ArrayList<Mapper> expectedMappers = new ArrayList<Mapper>();
		expectedMappers.add(new Mapper(new ArrayList<>(Arrays.asList(50l,52l)), new ArrayList<>(Arrays.asList(98l,50l)), new ArrayList<>(Arrays.asList(2l,48l))));
		expectedMappers.add(new Mapper(new ArrayList<>(Arrays.asList(0l,37l,39l)), new ArrayList<>(Arrays.asList(15l,52l,0l)), new ArrayList<>(Arrays.asList(37l,2l,15l))));
		expectedMappers.add(new Mapper(new ArrayList<>(Arrays.asList(49l,0l,42l,57l)), new ArrayList<>(Arrays.asList(53l,11l,0l,7l)), new ArrayList<>(Arrays.asList(8l,42l,7l,4l))));
		expectedMappers.add(new Mapper(new ArrayList<>(Arrays.asList(88l,18l)), new ArrayList<>(Arrays.asList(18l,25l)), new ArrayList<>(Arrays.asList(7l,70l))));
		expectedMappers.add(new Mapper(new ArrayList<>(Arrays.asList(45l,81l,68l)), new ArrayList<>(Arrays.asList(77l,45l,64l)), new ArrayList<>(Arrays.asList(23l,19l,13l))));
		expectedMappers.add(new Mapper(new ArrayList<>(Arrays.asList(0l,1l)), new ArrayList<>(Arrays.asList(69l,0l)), new ArrayList<>(Arrays.asList(1l,69l))));
		expectedMappers.add(new Mapper(new ArrayList<>(Arrays.asList(60l,56l)), new ArrayList<>(Arrays.asList(56l,93l)), new ArrayList<>(Arrays.asList(37l,4l))));
		
		assertEquals(expectedSeeds, day5.getSeeds());
		assertEquals(expectedMappers, day5.getMappers());
	}
	
	@Test
	void a_seed_can_be_continually_mapped_across_each_mapper_to_a_final_location() throws Exception {
		useSampleImput();
		//Seed 1
		long firstMap = day5.processMapping(day5.getSeeds().get(0), day5.getMappers().get(0));
		assertEquals(81l, firstMap);
		long secondMap = day5.processMapping(firstMap, day5.getMappers().get(1));
		assertEquals(81l, secondMap);
		long thirdMap = day5.processMapping(secondMap, day5.getMappers().get(2));
		assertEquals(81l, thirdMap);
		long fourthMap = day5.processMapping(thirdMap, day5.getMappers().get(3));
		assertEquals(74l, fourthMap);
		long fifthMap = day5.processMapping(fourthMap, day5.getMappers().get(4));
		assertEquals(78l, fifthMap);
		long sithMap = day5.processMapping(fifthMap, day5.getMappers().get(5));
		assertEquals(78l, sithMap);
		long seventhMap = day5.processMapping(sithMap, day5.getMappers().get(6));
		assertEquals(82l, seventhMap);
		
//		Seed 13, soil 13, fertilizer 52, water 41, light 34, temperature 34, humidity 35, location 35.
		firstMap = day5.processMapping(day5.getSeeds().get(3), day5.getMappers().get(0));
		assertEquals(13l, firstMap);
		secondMap = day5.processMapping(firstMap, day5.getMappers().get(1));
		assertEquals(52l, secondMap);
		thirdMap = day5.processMapping(secondMap, day5.getMappers().get(2));
		assertEquals(41l, thirdMap);
		fourthMap = day5.processMapping(thirdMap, day5.getMappers().get(3));
		assertEquals(34l, fourthMap);
		fifthMap = day5.processMapping(fourthMap, day5.getMappers().get(4));
		assertEquals(34l, fifthMap);
		sithMap = day5.processMapping(fifthMap, day5.getMappers().get(5));
		assertEquals(35l, sithMap);
		seventhMap = day5.processMapping(sithMap, day5.getMappers().get(6));
		assertEquals(35l, seventhMap);
	}
	
	@Test
	void verify_lowest_final_location_of_all_seeds() throws Exception {
		useSampleImput();
		assertEquals(35l, day5.determineLowestFinalLocation());
	}
	
	@Test
	void get_Part1_answer() throws Exception {
		System.out.println(day5.determineLowestFinalLocation());
	}
}
