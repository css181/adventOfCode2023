package day11;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day11Part2 {

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
	void simpleTest_with_adding_10() throws Exception {
		CoordinatePair pair = new CoordinatePair(new Coordinate(0, 0), new Coordinate(2, 2));
		ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1));
		assertEquals(22, pair.getDistance(list1, list1, 10));
	}

	@Test
	void simpleTest_other_with_adding_10() throws Exception {
		CoordinatePair pair = new CoordinatePair(new Coordinate(0, 0), new Coordinate(2, 5));
		ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1));
		ArrayList<Integer> list123 = new ArrayList<Integer>(Arrays.asList(1,2,3));
		assertEquals(43, pair.getDistance(list123, list1, 10));
	}
	
	@Test
	void simpleTest_reverse_with_adding_10() throws Exception {
		CoordinatePair pair = new CoordinatePair(new Coordinate(2, 5), new Coordinate(0, 0));
		ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1));
		ArrayList<Integer> list123 = new ArrayList<Integer>(Arrays.asList(1,2,3));
		assertEquals(43, pair.getDistance(list123, list1, 10));
	}
	
	@Test
	void verify_distance_if_no_galaxy_rows_and_cols_add_10() throws Exception {
		useSampleImput();
		
		assertEquals(1030, day11.getTotalDistanceOfAllGalaxiesByAdding_X_RowsAndCols(10));
	}
	
	@Test
	void get_part2_answer() throws Exception {
//		System.out.println("Part2 answer: " + day11.getTotalDistanceOfAllGalaxiesByAdding_X_RowsAndCols(1000000));
		assertEquals(857986849428l, day11.getTotalDistanceOfAllGalaxiesByAdding_X_RowsAndCols(1000000));
	}
}
