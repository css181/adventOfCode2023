package day6;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day6Part1 {

	private Day6 day6;
	
	@BeforeEach
	public void setup() {
		day6 = new Day6();
	}
	private void useSampleImput() {
		day6.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day6.populateInput();
	}

	@Test 
	void convertFileToArrayOfRaces() {
		useSampleImput();
		ArrayList<Race> expected = new ArrayList<Race>();
		expected.add(new Race(7,9));
		expected.add(new Race(15,40));
		expected.add(new Race(30,200));
		
		assertEquals(expected, day6.getRaces());
	}
	
	@Test
	void can_obtain_num_of_ways_to_break_distance_record() throws Exception {
		useSampleImput();
		assertEquals(4, day6.calculateNumOfWaysToBreakRecordForRace(day6.getRaces().get(0)));
		assertEquals(8, day6.calculateNumOfWaysToBreakRecordForRace(day6.getRaces().get(1)));
		assertEquals(9, day6.calculateNumOfWaysToBreakRecordForRace(day6.getRaces().get(2)));
	}
	
	@Test
	void verify_margin_error() throws Exception {
		useSampleImput();
		assertEquals(288, day6.calcMarginOfErrorForAllRaces());
	}
	
	@Test
	void get_Part1_answer() throws Exception {
//		System.out.println(day6.calcMarginOfErrorForAllRaces());
		assertEquals(4568778, day6.calcMarginOfErrorForAllRaces());
	}
}
