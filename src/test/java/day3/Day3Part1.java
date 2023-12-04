package day3;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day3Part1 {

	private Day3 day3;
	
	@BeforeEach
	public void setup() {
		day3 = new Day3();
	}
	private void useSampleImput() {
		day3.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day3.populateInput();
	}
	
	@Test 
	void convertFileToArrayOfCharArrayTest() {
		useSampleImput();
		ArrayList<ArrayList<Character>> expected = new ArrayList<ArrayList<Character>>();
		expected.add(new ArrayList<>(Arrays.asList('4','6','7','.','.','1','1','4','.','.')));
		expected.add(new ArrayList<>(Arrays.asList('.','.','.','*','.','.','.','.','.','.')));
		expected.add(new ArrayList<>(Arrays.asList('.','.','3','5','.','.','6','3','3','.')));
		expected.add(new ArrayList<>(Arrays.asList('.','.','.','.','.','.','#','.','.','.')));
		expected.add(new ArrayList<>(Arrays.asList('6','1','7','*','.','.','.','.','.','.')));
		expected.add(new ArrayList<>(Arrays.asList('.','.','.','.','.','+','.','5','8','.')));
		expected.add(new ArrayList<>(Arrays.asList('.','.','5','9','2','.','.','.','.','.')));
		expected.add(new ArrayList<>(Arrays.asList('.','.','.','.','.','.','7','5','5','.')));
		expected.add(new ArrayList<>(Arrays.asList('.','.','.','$','.','*','.','.','.','.')));
		expected.add(new ArrayList<>(Arrays.asList('.','6','6','4','.','5','9','8','.','.')));
		
		assertEquals(expected, day3.getChar2d());
	}
	
	@Test
	void can_identify_symbols() throws Exception {
		useSampleImput();
		ArrayList<Coordinate> expected = new ArrayList<Coordinate>();
		expected.add(new Coordinate(3,1));
		expected.add(new Coordinate(6,3));
		expected.add(new Coordinate(3,4));
		expected.add(new Coordinate(5,5));
		expected.add(new Coordinate(3,8));
		expected.add(new Coordinate(5,8));
		
		assertEquals(expected, day3.getAllSymbolCoordinates());
	}
	
	@Test
	void can_identify_if_char_at_coordinate_isNumeric() throws Exception {
		useSampleImput();
		ArrayList<ArrayList<Character>> char2d = day3.getChar2d();
		assertTrue(day3.isNumeric(char2d.get(0).get(0)));
		assertFalse(day3.isNumeric(char2d.get(0).get(4)));
	}
	
	@Test
	void can_get_number_from_coordinate() throws Exception {
		useSampleImput();
		assertEquals(467, day3.getNumberFromCoordinate(new Coordinate(0, 0)));
		assertEquals(467, day3.getNumberFromCoordinate(new Coordinate(1, 0)));
		assertEquals(467, day3.getNumberFromCoordinate(new Coordinate(2, 0)));
	}

	@Test
	void can_get_all_numbers_within_diagonal_from_symbols() throws Exception {
		useSampleImput();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(467);
		expected.add(35);
		expected.add(633);
		expected.add(617);
		expected.add(592);
		expected.add(664);
		expected.add(755);
		expected.add(598);
		
		assertEquals(expected, day3.getAllNumbersAdjacentToSymbols());
	}
	
	@Test
	void verify_sample_sum() throws Exception {
		useSampleImput();
		
		assertEquals(4361, day3.calculateSumOfAllNumbersAdjacentToSymbols());
	}
	
	@Test
	void get_part1_answer() throws Exception {
		System.out.println(day3.getAllNumbersAdjacentToSymbols().size() + " total numbers being added");
		System.out.println(day3.getAllNumbersAdjacentToSymbols());
		System.out.println(day3.calculateSumOfAllNumbersAdjacentToSymbols());
	}
}
