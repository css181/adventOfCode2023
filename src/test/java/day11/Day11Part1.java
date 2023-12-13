package day11;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day11Part1 {

	private Day11 day11;
	
	@BeforeEach
	public void setup() {
		day11 = new Day11();
	}
	private void useSampleImput() {
		day11.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day11.populateInput();
	}
	
	@Test 
	void convertFileToArrayOfCharArrayTest() {
		useSampleImput();
		ArrayList<ArrayList<Character>> expected = new ArrayList<ArrayList<Character>>();
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','#','.','.','.','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','.','#','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('#','.','.','.','.','.','.','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','.','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','#','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','#','.','.','.','.','.','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','.','.','.','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','.','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','.','#','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('#','.','.','.','#','.','.','.','.','.')));
		
		assertEquals(expected, day11.getGrid());
	}
	
	@Test
	void can_find_rows_that_have_no_galaxies() throws Exception {
		useSampleImput();
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(3,7));
		
		assertEquals(expected, day11.getRowsWithNoGalaxies());
	}
	
	@Test
	void can_find_cols_that_have_no_galaxies() throws Exception {
		useSampleImput();
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(2,5,8));
		
		assertEquals(expected, day11.getColsWithNoGalaxies());
	}
	
	@Test
	void can_expand_grid_by_adding_additional_dot_row_and_col_when_there_are_no_galaxies() throws Exception {
		useSampleImput();
		ArrayList<ArrayList<Character>> expected = new ArrayList<ArrayList<Character>>();
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','#','.','.','.','.','.','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','.','.','.','#','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('#','.','.','.','.','.','.','.','.','.','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','.','.','.','.','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','.','.','.','.','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','.','.','#','.','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','#','.','.','.','.','.','.','.','.','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','.','.','.','.','.','.','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','.','.','.','.','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','.','.','.','.','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','.','.','.','.','.','#','.','.','.')));
		expected.add(new ArrayList<Character>(Arrays.asList('#','.','.','.','.','#','.','.','.','.','.','.','.')));
		
		day11.expandGridForNoGalaxyRowsAndCols();
		assertEquals(day11.printGrid(expected), day11.printGrid(day11.getGrid()));
	}
	
	@Test
	void each_galaxy_is_marked_as_a_Coordinate() throws Exception {
		useSampleImput();
		ArrayList<Coordinate> expected = new ArrayList<Coordinate>();
		expected.add(new Coordinate(4, 0));
		expected.add(new Coordinate(9, 1));
		expected.add(new Coordinate(0, 2));
		expected.add(new Coordinate(8, 5));
		expected.add(new Coordinate(1, 6));
		expected.add(new Coordinate(12, 7));
		expected.add(new Coordinate(9, 10));
		expected.add(new Coordinate(0, 11));
		expected.add(new Coordinate(5, 11));
		
		assertEquals(expected, day11.getAllGalaxyCoordinates());
	}
	
	@Test
	void can_get_all_CoordinatePairs() throws Exception {
		useSampleImput();
		ArrayList<CoordinatePair> expected = new ArrayList<CoordinatePair>();
		expected.add(new CoordinatePair(new Coordinate(4, 0), new Coordinate(9, 1)));
		expected.add(new CoordinatePair(new Coordinate(4, 0), new Coordinate(0, 2)));
		expected.add(new CoordinatePair(new Coordinate(0, 11), new Coordinate(5, 11)));
		ArrayList<CoordinatePair> allGalaxyPairs = day11.getAllGalaxyPairs();
		assertEquals(36, allGalaxyPairs.size());
		assertTrue(allGalaxyPairs.contains(expected.get(0)));
		assertTrue(allGalaxyPairs.contains(expected.get(1)));
		assertTrue(allGalaxyPairs.contains(expected.get(2)));
	}
	
	@Test
	void each_CoordinatePair_can_get_distance_between_them() throws Exception {
		CoordinatePair pair = new CoordinatePair(new Coordinate(1, 6), new Coordinate(5, 11));
		assertEquals(9, pair.getDistance());
		
		pair = new CoordinatePair(new Coordinate(4, 0), new Coordinate(9, 10));
		assertEquals(15, pair.getDistance());
		
		pair = new CoordinatePair(new Coordinate(0, 2), new Coordinate(12, 7));
		assertEquals(17, pair.getDistance());

		pair = new CoordinatePair(new Coordinate(0, 11), new Coordinate(5, 11));
		assertEquals(5, pair.getDistance());
	}
	
	@Test
	void verify_sample_input_total_distance() throws Exception {
		useSampleImput();
		
		assertEquals(374, day11.getTotalDistanceOfAllGalaxies());
	}
	
	@Test
	void get_part1_answer() throws Exception {
//		System.out.println(day11.getTotalDistanceOfAllGalaxies());
		assertEquals(9565386l, day11.getTotalDistanceOfAllGalaxies());
	}
}
