package innitialDayToCloneFrom;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DayXPart1 {

	private DayX dayX;
	
	@BeforeEach
	public void setup() {
		dayX = new DayX();
	}
	private void useSampleImput() {
		dayX.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		dayX.populateInput();
	}
	
	@Test 
	void convertFileToArrayOfCharArrayTest() {
		useSampleImput();
		ArrayList<Game> expected = new ArrayList<Game>();
		expected.add(new Game("line1"));
		expected.add(new Game("line2"));
		expected.add(new Game("line3"));
		expected.add(new Game("line4"));
		expected.add(new Game("line5"));
		
		assertEquals(expected, dayX.getGames());
	}
	
}
