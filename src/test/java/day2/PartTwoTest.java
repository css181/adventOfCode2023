package day2;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PartTwoTest {

	private Day2 day2;
	
	@BeforeEach
	public void setup() {
		day2 = new Day2();
	}
	private void useSampleImput() {
		day2.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day2.populateInput();
	}

	@Test 
	void verify_min_colorCounts_per_game() {
		useSampleImput();
		
		assertEquals(4, day2.getGames().get(0).getMinRedCount());
		assertEquals(2, day2.getGames().get(0).getMinGreenCount());
		assertEquals(6, day2.getGames().get(0).getMinBlueCount());
		
		assertEquals(1, day2.getGames().get(1).getMinRedCount());
		assertEquals(3, day2.getGames().get(1).getMinGreenCount());
		assertEquals(4, day2.getGames().get(1).getMinBlueCount());
		
		assertEquals(20, day2.getGames().get(2).getMinRedCount());
		assertEquals(13, day2.getGames().get(2).getMinGreenCount());
		assertEquals(6, day2.getGames().get(2).getMinBlueCount());
		
		assertEquals(14, day2.getGames().get(3).getMinRedCount());
		assertEquals(3, day2.getGames().get(3).getMinGreenCount());
		assertEquals(15, day2.getGames().get(3).getMinBlueCount());
		
		assertEquals(6, day2.getGames().get(4).getMinRedCount());
		assertEquals(3, day2.getGames().get(4).getMinGreenCount());
		assertEquals(2, day2.getGames().get(4).getMinBlueCount());
	}
	
	@Test
	void verify_game_powers() throws Exception {
		useSampleImput();
		assertEquals(48, day2.getGames().get(0).getPower());
		assertEquals(12, day2.getGames().get(1).getPower());
		assertEquals(1560, day2.getGames().get(2).getPower());
		assertEquals(630, day2.getGames().get(3).getPower());
		assertEquals(36, day2.getGames().get(4).getPower());
	}
	
	@Test
	void verify_sum_of_all_powers() throws Exception {
		useSampleImput();
		assertEquals(2286, day2.getSumOfAllGamePowers());
	}
	
	@Test
	void get_answer() throws Exception {
//		System.out.println(day2.getSumOfAllGamePowers());
		assertEquals(62811, day2.getSumOfAllGamePowers());
	}
}
