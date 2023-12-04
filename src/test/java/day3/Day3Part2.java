package day3;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day3Part2 {

	private SymbolsAndGears day3;
	
	@BeforeEach
	public void setup() {
		day3 = new SymbolsAndGears();
	}
	private void useSampleImput() {
		day3.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day3.populateInput();
	}
	
	@Test
	void can_identify_gears() throws Exception {
		useSampleImput();
		ArrayList<Coordinate> expected = new ArrayList<Coordinate>();
		expected.add(new Coordinate(3,1));
		expected.add(new Coordinate(5,8));
		
		assertEquals(expected, day3.getAllGearCoordinates());
	}
	
	@Test
	void verify_gear_ratios() throws Exception {
		useSampleImput();
		ArrayList<Coordinate> allGears = day3.getAllGearCoordinates();
		assertEquals(16345, day3.getGearRatio(allGears.get(0)));
		assertEquals(451490, day3.getGearRatio(allGears.get(1)));
	}
	
	@Test
	void verify_gear_sum() throws Exception {
		useSampleImput();
		assertEquals(467835, day3.calculateSumOfAllGearRatios());
	}
	
	@Test
	void get_part_2_answer() throws Exception {
//		System.out.println(day3.calculateSumOfAllGearRatios());
		assertEquals(91031374, day3.calculateSumOfAllGearRatios());
	}
}
