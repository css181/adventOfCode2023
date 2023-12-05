package day5;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day5Part1 {

	private Day5 day5;
	
	@BeforeEach
	public void setup() {
		day5 = new Day5();
	}
	private void useSampleImput() {
		day5.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day5.populateInput();
	}
	
	@Test 
	void convertFileToArrayOfCharArrayTest() {
		useSampleImput();
		ArrayList<Game> expected = new ArrayList<Game>();
		expected.add(new Game(0, new ArrayList<>(Arrays.asList(4,1,0)), new ArrayList<>(Arrays.asList(0,2,2)), new ArrayList<>(Arrays.asList(3,6,0))));
		expected.add(new Game(0, new ArrayList<>(Arrays.asList(0,1,0)), new ArrayList<>(Arrays.asList(2,3,1)), new ArrayList<>(Arrays.asList(1,4,1))));
		expected.add(new Game(0, new ArrayList<>(Arrays.asList(20,4,1)), new ArrayList<>(Arrays.asList(8,13,5)), new ArrayList<>(Arrays.asList(6,5,0))));
		expected.add(new Game(0, new ArrayList<>(Arrays.asList(3,6,14)), new ArrayList<>(Arrays.asList(1,3,3)), new ArrayList<>(Arrays.asList(6,0,15))));
		expected.add(new Game(0, new ArrayList<>(Arrays.asList(6,1)), new ArrayList<>(Arrays.asList(3,2)), new ArrayList<>(Arrays.asList(1,2))));
		
		assertEquals(expected, day5.getGames());
	}
	
}
