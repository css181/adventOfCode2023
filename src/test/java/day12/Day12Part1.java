package day12;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day12Part1 {

	private Day12 day12;
	
	@BeforeEach
	public void setup() {
		day12 = new Day12();
	}
	private void useSampleImput() {
		day12.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day12.populateInput();
	}
	
	@Test 
	void convertFileToArrayOfCharArrayTest() {
		useSampleImput();
		ArrayList<SpringRecord> expected = new ArrayList<SpringRecord>();
		expected.add(new SpringRecord(new ArrayList<Character>(Arrays.asList('?','?','?','.','#','#','#')), new ArrayList<Integer>(Arrays.asList(1,1,3))));
		expected.add(new SpringRecord(new ArrayList<Character>(Arrays.asList('.','?','?','.','.','?','?','.','.','.','?','#','#','.')), new ArrayList<Integer>(Arrays.asList(1,1,3))));
		expected.add(new SpringRecord(new ArrayList<Character>(Arrays.asList('?','#','?','#','?','#','?','#','?','#','?','#','?','#','?')), new ArrayList<Integer>(Arrays.asList(1,3,1,6))));
		expected.add(new SpringRecord(new ArrayList<Character>(Arrays.asList('?','?','?','?','.','#','.','.','.','#','.','.','.')), new ArrayList<Integer>(Arrays.asList(4,1,1))));
		expected.add(new SpringRecord(new ArrayList<Character>(Arrays.asList('?','?','?','?','.','#','#','#','#','#','#','.','.','#','#','#','#','#','.')), new ArrayList<Integer>(Arrays.asList(1,6,5))));
		expected.add(new SpringRecord(new ArrayList<Character>(Arrays.asList('?','#','#','#','?','?','?','?','?','?','?','?')), new ArrayList<Integer>(Arrays.asList(3,2,1))));
		
		assertEquals(expected, day12.getSpringRecords());
	}
			
	@Test
	void can_create_list_of_all_possible_springs_from_SpringRecord_by_replacing_questionMarks() throws Exception {
		ArrayList<Character> sampleSpring = new ArrayList<Character>(Arrays.asList('?','?','?','.','#','#','#'));
		ArrayList<ArrayList<Character>> expected = new ArrayList<ArrayList<Character>>();
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','#','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','#','.','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','#','#','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('#','.','.','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('#','.','#','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('#','#','.','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('#','#','#','.','#','#','#')));
		
		assertEquals(expected, day12.getAllPotentialStringListsFromOneWithQuestionMarks(sampleSpring));
	}
	
	@Test
	void can_verify_if_a_possible_springs_list_is_valid() throws Exception {
		ArrayList<Integer> damagedList = new ArrayList<Integer>(Arrays.asList(1,1,3));
		ArrayList<ArrayList<Character>> expected = new ArrayList<ArrayList<Character>>();
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','.','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','.','#','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','#','.','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('.','#','#','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('#','.','.','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('#','.','#','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('#','#','.','.','#','#','#')));
		expected.add(new ArrayList<Character>(Arrays.asList('#','#','#','.','#','#','#')));
		
		assertFalse(day12.isSpringListValidBasedOnDamagedList(expected.get(0), damagedList));
		assertFalse(day12.isSpringListValidBasedOnDamagedList(expected.get(1), damagedList));
		assertFalse(day12.isSpringListValidBasedOnDamagedList(expected.get(2), damagedList));
		assertFalse(day12.isSpringListValidBasedOnDamagedList(expected.get(3), damagedList));
		assertFalse(day12.isSpringListValidBasedOnDamagedList(expected.get(4), damagedList));
		assertTrue(day12.isSpringListValidBasedOnDamagedList(expected.get(5), damagedList));
		assertFalse(day12.isSpringListValidBasedOnDamagedList(expected.get(6), damagedList));
		assertFalse(day12.isSpringListValidBasedOnDamagedList(expected.get(7), damagedList));
	}
	
	@Test
	void can_verify_num_of_valid_possibles_for_all_sample_inputs() throws Exception {
		useSampleImput();
		assertEquals(1, day12.getNumOfValidPossiblesForSpringRecord(day12.getSpringRecords().get(0)));
		assertEquals(4, day12.getNumOfValidPossiblesForSpringRecord(day12.getSpringRecords().get(1)));
		assertEquals(1, day12.getNumOfValidPossiblesForSpringRecord(day12.getSpringRecords().get(2)));
		assertEquals(1, day12.getNumOfValidPossiblesForSpringRecord(day12.getSpringRecords().get(3)));
		assertEquals(4, day12.getNumOfValidPossiblesForSpringRecord(day12.getSpringRecords().get(4)));
		assertEquals(10, day12.getNumOfValidPossiblesForSpringRecord(day12.getSpringRecords().get(5)));
	}
	
	@Test
	void can_get_total_valid_possible_spring_lists_from_all_possibles_found_from_input() throws Exception {
		useSampleImput();
		assertEquals(21, day12.getTotalNumOfAllValidPossiblesForAllInputs());
	}
	
	@Test
	void get_part1_answer() throws Exception {
//		System.out.println(day12.getTotalNumOfAllValidPossiblesForAllInputs());
		assertEquals(7307, day12.getTotalNumOfAllValidPossiblesForAllInputs());
	}
}
