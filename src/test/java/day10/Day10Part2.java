package day10;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day10Part2 {

	private Day10 day10;
	
	@BeforeEach
	public void setup() {
		day10 = new Day10();
	}
	private void useSampleImput() {
		day10.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day10.treatSAs = 'F'; //This was determined manually by looking at the SampleInput
		day10.populateInput();
	}

	@Test
	void can_calculate_statuses_of_locations() throws Exception {
		useSampleImput();
		String expected = ""
				+ "[OUTSIDE][OUTSIDE][ LOOP  ][ LOOP  ][OUTSIDE]\n"
				+ "[OUTSIDE][ LOOP  ][ LOOP  ][ LOOP  ][OUTSIDE]\n"
				+ "[ LOOP  ][ LOOP  ][INSIDE ][ LOOP  ][ LOOP  ]\n"
				+ "[ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ]\n"
				+ "[ LOOP  ][ LOOP  ][OUTSIDE][OUTSIDE][OUTSIDE]\n";
		
		day10.calculateStatusesOfMap();
		assertEquals(expected, day10.getMap().printAllStatuses());
	}
	
	@Test
	void verify_statuses_on_harder_map() throws Exception {
		day10.setFileToUse(new File(getClass().getResource("pipesOutsideSample.txt").getPath()));
		day10.treatSAs = 'F'; //This was determined manually by looking at the SampleInput
		day10.populateInput();
		String expected = ""
				+ "[OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE]\n"
				+ "[OUTSIDE][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][OUTSIDE]\n"
				+ "[OUTSIDE][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][OUTSIDE]\n"
				+ "[OUTSIDE][ LOOP  ][ LOOP  ][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][ LOOP  ][ LOOP  ][OUTSIDE]\n"
				+ "[OUTSIDE][ LOOP  ][ LOOP  ][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][ LOOP  ][ LOOP  ][OUTSIDE]\n"
				+ "[OUTSIDE][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][OUTSIDE]\n"
				+ "[OUTSIDE][ LOOP  ][INSIDE ][INSIDE ][ LOOP  ][ LOOP  ][INSIDE ][INSIDE ][ LOOP  ][OUTSIDE]\n"
				+ "[OUTSIDE][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][ LOOP  ][OUTSIDE]\n"
				+ "[OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE][OUTSIDE]\n";
		
		day10.calculateStatusesOfMap();
		assertEquals(expected, day10.getMap().printAllStatuses());
	}
	
	@Test
	void verify_num_of_inside_locations() throws Exception {
		day10.setFileToUse(new File(getClass().getResource("pipesOutsideSample.txt").getPath()));
		day10.treatSAs = 'F'; //This was determined manually by looking at the SampleInput
		day10.populateInput();
		
		day10.calculateStatusesOfMap();
		assertEquals(4, day10.getMap().getNumOfInsideStatuses());
	}
	
//	@Test Note: Requires increasing heap size
	void get_part2_answer() throws Exception {
		day10.calculateStatusesOfMap();
//		System.out.println(day10.getMap().getNumOfInsideStatuses());
		assertEquals(461, day10.getMap().getNumOfInsideStatuses());
	}
}
