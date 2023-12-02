package day1;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PartOneTest {

	private Day1FromInput day1FromInput;
	
	@BeforeEach
	public void setup() {
		day1FromInput = new Day1FromInput();
	}
	
	@Test 
	void convertFileToArrayOfCharArrayTest() {
		ArrayList<ArrayList<Character>> expected = new ArrayList<ArrayList<Character>>();
		expected.add(new ArrayList<>(Arrays.asList('1','a','b','c','2')));
		expected.add(new ArrayList<>(Arrays.asList('p','q','r','3','s','t','u','8','v','w','x')));
		expected.add(new ArrayList<>(Arrays.asList('a','1','b','2','c','3','d','4','e','5','f')));
		expected.add(new ArrayList<>(Arrays.asList('t','r','e','b','7','u','c','h','e','t')));
		
		day1FromInput.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day1FromInput.populateInput();
		assertEquals(expected, day1FromInput.getInputLines());
	}
	
	
	
	
}
