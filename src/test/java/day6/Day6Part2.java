package day6;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day6Part2 {

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
		Race expected = new Race(71530,940200);
		
		assertEquals(expected, day6.getSingleRace());
	}
	
	@Test
	void can_find_min_pushTime_to_set_record() throws Exception {
		useSampleImput();
		assertEquals(14, day6.getMinPushTimeToSetRecord(day6.getSingleRace()));
	}
	
	@Test
	void can_find_max_pushTime_to_set_record() throws Exception {
		useSampleImput();
		assertEquals(71516, day6.getMaxPushTimeToSetRecord(day6.getSingleRace()));
	}
	
	@Test
	void verify_total_ways_to_win_singleRace() throws Exception {
		useSampleImput();
		int min = day6.getMinPushTimeToSetRecord(day6.getSingleRace());
		long max = day6.getMaxPushTimeToSetRecord(day6.getSingleRace());
		long total = max-min+1;
		assertEquals(71503, total);
	}
	
	@Test
	void get_Part2_answer() throws Exception {
		int min = day6.getMinPushTimeToSetRecord(day6.getSingleRace());
		long max = day6.getMaxPushTimeToSetRecord(day6.getSingleRace());
		long total = max-min+1;
//		System.out.println(total);
		assertEquals(28973936, total);
	}
}
