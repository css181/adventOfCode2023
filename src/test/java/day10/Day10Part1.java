package day10;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day10Part1 {

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
	void convertFileToArrayOfCharArrayTest() {
		useSampleImput();
		String expected = ""
				+ "7-F7-\n"
				+ ".FJ|7\n"
				+ "SJLL7\n"
				+ "|F--J\n"
				+ "LJ.LJ\n";
		
		assertEquals(expected, day10.getMap().toString());
	}
	
	//Test all the possible symbols with 3x3 maps to ensure we map everything correctly including any potential edges.
	
	@Test
	void can_populate_a_and_b_options_for_pipe_locations() throws Exception {
		day10.setFileToUse(new File(getClass().getResource("allPipe.txt").getPath()));
		day10.populateInput();
		Location lx0y0 = day10.getMap().getLocations().get(0).get(0);
		Location lx0y1 = day10.getMap().getLocations().get(1).get(0);
		Location lx0y2 = day10.getMap().getLocations().get(2).get(0);
		Location lx1y0 = day10.getMap().getLocations().get(0).get(1);
		Location lx1y1 = day10.getMap().getLocations().get(1).get(1);
		Location lx1y2 = day10.getMap().getLocations().get(2).get(1);
		Location lx2y0 = day10.getMap().getLocations().get(0).get(2);
		Location lx2y1 = day10.getMap().getLocations().get(1).get(2);
		Location lx2y2 = day10.getMap().getLocations().get(2).get(2);
		
		assertEquals(null, lx0y0.getaOption());
		assertEquals(lx0y1, lx0y0.getbOption());
		assertEquals(null, lx1y0.getaOption());
		assertEquals(lx1y1, lx1y0.getbOption());
		assertEquals(null, lx2y0.getaOption());
		assertEquals(lx2y1, lx2y0.getbOption());
		
		assertEquals(lx0y0, lx0y1.getaOption());
		assertEquals(lx0y2, lx0y1.getbOption());
		assertEquals(lx1y0, lx1y1.getaOption());
		assertEquals(lx1y2, lx1y1.getbOption());
		assertEquals(lx2y0, lx2y1.getaOption());
		assertEquals(lx2y2, lx2y1.getbOption());
		
		assertEquals(lx0y1, lx0y2.getaOption());
		assertEquals(null, lx0y2.getbOption());
		assertEquals(lx1y1, lx1y2.getaOption());
		assertEquals(null, lx1y2.getbOption());
		assertEquals(lx2y1, lx2y2.getaOption());
		assertEquals(null, lx2y2.getbOption());
	}

	@Test
	void can_populate_a_and_b_options_for_dash_locations() throws Exception {
		day10.setFileToUse(new File(getClass().getResource("allDash.txt").getPath()));
		day10.populateInput();
		Location lx0y0 = day10.getMap().getLocations().get(0).get(0);
		Location lx0y1 = day10.getMap().getLocations().get(1).get(0);
		Location lx0y2 = day10.getMap().getLocations().get(2).get(0);
		Location lx1y0 = day10.getMap().getLocations().get(0).get(1);
		Location lx1y1 = day10.getMap().getLocations().get(1).get(1);
		Location lx1y2 = day10.getMap().getLocations().get(2).get(1);
		Location lx2y0 = day10.getMap().getLocations().get(0).get(2);
		Location lx2y1 = day10.getMap().getLocations().get(1).get(2);
		Location lx2y2 = day10.getMap().getLocations().get(2).get(2);
		
		assertEquals(null, lx0y0.getaOption());
		assertEquals(lx1y0, lx0y0.getbOption());
		assertEquals(lx0y0, lx1y0.getaOption());
		assertEquals(lx2y0, lx1y0.getbOption());
		assertEquals(lx1y0, lx2y0.getaOption());
		assertEquals(null, lx2y0.getbOption());
		
		assertEquals(null, lx0y1.getaOption());
		assertEquals(lx1y1, lx0y1.getbOption());
		assertEquals(lx0y1, lx1y1.getaOption());
		assertEquals(lx2y1, lx1y1.getbOption());
		assertEquals(lx1y1, lx2y1.getaOption());
		assertEquals(null, lx2y1.getbOption());
		
		assertEquals(null, lx0y2.getaOption());
		assertEquals(lx1y2, lx0y2.getbOption());
		assertEquals(lx0y2, lx1y2.getaOption());
		assertEquals(lx2y2, lx1y2.getbOption());
		assertEquals(lx1y2, lx2y2.getaOption());
		assertEquals(null, lx2y2.getbOption());
	}

	@Test
	void can_populate_a_and_b_options_for_L_locations() throws Exception {
		day10.setFileToUse(new File(getClass().getResource("all_L.txt").getPath()));
		day10.populateInput();
		Location lx0y0 = day10.getMap().getLocations().get(0).get(0);
		Location lx0y1 = day10.getMap().getLocations().get(1).get(0);
		Location lx0y2 = day10.getMap().getLocations().get(2).get(0);
		Location lx1y0 = day10.getMap().getLocations().get(0).get(1);
		Location lx1y1 = day10.getMap().getLocations().get(1).get(1);
		Location lx1y2 = day10.getMap().getLocations().get(2).get(1);
		Location lx2y0 = day10.getMap().getLocations().get(0).get(2);
		Location lx2y1 = day10.getMap().getLocations().get(1).get(2);
		Location lx2y2 = day10.getMap().getLocations().get(2).get(2);
		
		assertEquals(null, lx0y0.getaOption());
		assertEquals(lx1y0, lx0y0.getbOption());
		assertEquals(null, lx1y0.getaOption());
		assertEquals(lx2y0, lx1y0.getbOption());
		assertEquals(null, lx2y0.getaOption());
		assertEquals(null, lx2y0.getbOption());
		
		assertEquals(lx0y0, lx0y1.getaOption());
		assertEquals(lx1y1, lx0y1.getbOption());
		assertEquals(lx1y0, lx1y1.getaOption());
		assertEquals(lx2y1, lx1y1.getbOption());
		assertEquals(lx2y0, lx2y1.getaOption());
		assertEquals(null, lx2y1.getbOption());
		
		assertEquals(lx0y1, lx0y2.getaOption());
		assertEquals(lx1y2, lx0y2.getbOption());
		assertEquals(lx1y1, lx1y2.getaOption());
		assertEquals(lx2y2, lx1y2.getbOption());
		assertEquals(lx2y1, lx2y2.getaOption());
		assertEquals(null, lx2y2.getbOption());
	}

	@Test
	void can_populate_a_and_b_options_for_J_locations() throws Exception {
		day10.setFileToUse(new File(getClass().getResource("all_J.txt").getPath()));
		day10.populateInput();
		Location lx0y0 = day10.getMap().getLocations().get(0).get(0);
		Location lx0y1 = day10.getMap().getLocations().get(1).get(0);
		Location lx0y2 = day10.getMap().getLocations().get(2).get(0);
		Location lx1y0 = day10.getMap().getLocations().get(0).get(1);
		Location lx1y1 = day10.getMap().getLocations().get(1).get(1);
		Location lx1y2 = day10.getMap().getLocations().get(2).get(1);
		Location lx2y0 = day10.getMap().getLocations().get(0).get(2);
		Location lx2y1 = day10.getMap().getLocations().get(1).get(2);
		Location lx2y2 = day10.getMap().getLocations().get(2).get(2);
		
		assertEquals(null, lx0y0.getaOption());
		assertEquals(null, lx0y0.getbOption());
		assertEquals(null, lx1y0.getaOption());
		assertEquals(lx0y0, lx1y0.getbOption());
		assertEquals(null, lx2y0.getaOption());
		assertEquals(lx1y0, lx2y0.getbOption());
		
		assertEquals(lx0y0, lx0y1.getaOption());
		assertEquals(null, lx0y1.getbOption());
		assertEquals(lx1y0, lx1y1.getaOption());
		assertEquals(lx0y1, lx1y1.getbOption());
		assertEquals(lx2y0, lx2y1.getaOption());
		assertEquals(lx1y1, lx2y1.getbOption());
		
		assertEquals(lx0y1, lx0y2.getaOption());
		assertEquals(null, lx0y2.getbOption());
		assertEquals(lx1y1, lx1y2.getaOption());
		assertEquals(lx0y2, lx1y2.getbOption());
		assertEquals(lx2y1, lx2y2.getaOption());
		assertEquals(lx1y2, lx2y2.getbOption());
	}

	@Test
	void can_populate_a_and_b_options_for_7_locations() throws Exception {
		day10.setFileToUse(new File(getClass().getResource("all_7.txt").getPath()));
		day10.populateInput();
		Location lx0y0 = day10.getMap().getLocations().get(0).get(0);
		Location lx0y1 = day10.getMap().getLocations().get(1).get(0);
		Location lx0y2 = day10.getMap().getLocations().get(2).get(0);
		Location lx1y0 = day10.getMap().getLocations().get(0).get(1);
		Location lx1y1 = day10.getMap().getLocations().get(1).get(1);
		Location lx1y2 = day10.getMap().getLocations().get(2).get(1);
		Location lx2y0 = day10.getMap().getLocations().get(0).get(2);
		Location lx2y1 = day10.getMap().getLocations().get(1).get(2);
		Location lx2y2 = day10.getMap().getLocations().get(2).get(2);
		
		assertEquals(null, lx0y0.getaOption());
		assertEquals(lx0y1, lx0y0.getbOption());
		assertEquals(lx0y0, lx1y0.getaOption());
		assertEquals(lx1y1, lx1y0.getbOption());
		assertEquals(lx1y0, lx2y0.getaOption());
		assertEquals(lx2y1, lx2y0.getbOption());
		
		assertEquals(null, lx0y1.getaOption());
		assertEquals(lx0y2, lx0y1.getbOption());
		assertEquals(lx0y1, lx1y1.getaOption());
		assertEquals(lx1y2, lx1y1.getbOption());
		assertEquals(lx1y1, lx2y1.getaOption());
		assertEquals(lx2y2, lx2y1.getbOption());
		
		assertEquals(null, lx0y2.getaOption());
		assertEquals(null, lx0y2.getbOption());
		assertEquals(lx0y2, lx1y2.getaOption());
		assertEquals(null, lx1y2.getbOption());
		assertEquals(lx1y2, lx2y2.getaOption());
		assertEquals(null, lx2y2.getbOption());
	}

	@Test
	void can_populate_a_and_b_options_for_F_locations() throws Exception {
		day10.setFileToUse(new File(getClass().getResource("all_F.txt").getPath()));
		day10.populateInput();
		Location lx0y0 = day10.getMap().getLocations().get(0).get(0);
		Location lx0y1 = day10.getMap().getLocations().get(1).get(0);
		Location lx0y2 = day10.getMap().getLocations().get(2).get(0);
		Location lx1y0 = day10.getMap().getLocations().get(0).get(1);
		Location lx1y1 = day10.getMap().getLocations().get(1).get(1);
		Location lx1y2 = day10.getMap().getLocations().get(2).get(1);
		Location lx2y0 = day10.getMap().getLocations().get(0).get(2);
		Location lx2y1 = day10.getMap().getLocations().get(1).get(2);
		Location lx2y2 = day10.getMap().getLocations().get(2).get(2);
		
		assertEquals(lx1y0, lx0y0.getaOption());
		assertEquals(lx0y1, lx0y0.getbOption());
		assertEquals(lx2y0, lx1y0.getaOption());
		assertEquals(lx1y1, lx1y0.getbOption());
		assertEquals(null, lx2y0.getaOption());
		assertEquals(lx2y1, lx2y0.getbOption());
		
		assertEquals(lx1y1, lx0y1.getaOption());
		assertEquals(lx0y2, lx0y1.getbOption());
		assertEquals(lx2y1, lx1y1.getaOption());
		assertEquals(lx1y2, lx1y1.getbOption());
		assertEquals(null, lx2y1.getaOption());
		assertEquals(lx2y2, lx2y1.getbOption());
		
		assertEquals(lx1y2, lx0y2.getaOption());
		assertEquals(null, lx0y2.getbOption());
		assertEquals(lx2y2, lx1y2.getaOption());
		assertEquals(null, lx1y2.getbOption());
		assertEquals(null, lx2y2.getaOption());
		assertEquals(null, lx2y2.getbOption());
	}

	@Test
	void can_populate_a_and_b_options_for_dot_locations() throws Exception {
		day10.setFileToUse(new File(getClass().getResource("all_Dot.txt").getPath()));
		day10.populateInput();
		Location lx0y0 = day10.getMap().getLocations().get(0).get(0);
		Location lx0y1 = day10.getMap().getLocations().get(1).get(0);
		Location lx1y0 = day10.getMap().getLocations().get(0).get(1);
		Location lx1y1 = day10.getMap().getLocations().get(1).get(1);
		
		assertEquals(null, lx0y0.getaOption());
		assertEquals(null, lx0y0.getbOption());
		assertEquals(null, lx1y0.getaOption());
		assertEquals(null, lx1y0.getbOption());
		
		assertEquals(null, lx0y1.getaOption());
		assertEquals(null, lx0y1.getbOption());
		assertEquals(null, lx1y1.getaOption());
		assertEquals(null, lx1y1.getbOption());
	}
	
	@Test
	void can_populate_a_and_b_options_for_S_based_on_manual_hack() throws Exception {
		useSampleImput();
		Location actualStart = day10.getMap().getLocations().get(2).get(0);
		assertEquals(true, actualStart.getIsStart());
		//For Sample day10.treatSAs='F'
		assertEquals(day10.getMap().getLocations().get(2).get(1), actualStart.getaOption());
		assertEquals(day10.getMap().getLocations().get(3).get(0), actualStart.getbOption());
	}
	
	@Test
	void can_set_property_on_location_if_in_loop_and_remark_outside_loop_locations_to_dots() throws Exception {
		useSampleImput();
		String expected = ""
				+ "..F7.\n"
				+ ".FJ|.\n"
				+ "FJ.L7\n"
				+ "|F--J\n"
				+ "LJ...\n";
		
		day10.minifyMapAndSetPropertyOnLocationIfInLoop();
		assertTrue(day10.getMap().getLocations().get(2).get(1).getIsInLoop());
		assertFalse(day10.getMap().getLocations().get(0).get(0).getIsInLoop());
		assertEquals(expected, day10.getMap().toString());
	}
	
//	@Test Note: Requires increasing Heap Size
	void generate_MainMinifiedInput_from_full_input() throws Exception {
		day10.minifyMapAndSetPropertyOnLocationIfInLoop();
//		System.out.println(day10.getMap());
	}
	
	@Test
	void furthest_away_is_half_of_total_locations_in_loop() throws Exception {
		useSampleImput();
		day10.minifyMapAndSetPropertyOnLocationIfInLoop();
		assertEquals(8, day10.getNumOfLocationsInLoopDividedBy2());
	}
	
//	@Test Note: Requires increasing Heap Size
	void get_part1_answer() throws Exception {
		day10.minifyMapAndSetPropertyOnLocationIfInLoop();
//		System.out.println(day10.getNumOfLocationsInLoopDividedBy2());
		assertEquals(6909, day10.getNumOfLocationsInLoopDividedBy2());
	}
}
