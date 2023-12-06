package day5;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day5Part2 {

	private Day5 day5;
	
	@BeforeEach
	public void setup() {
		day5 = new Day5();
	}
	private void useSampleImput() {
		day5.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day5.populateInput_Part2();
	}

	@Test 
	void convertFileToSeedsAndMappers_Part2_yeilds_27_seeds() {
		useSampleImput();
		
		assertEquals(27, day5.getSeeds().size());
		assertEquals(79l, day5.getSeeds().get(0));
		assertEquals(80l, day5.getSeeds().get(1));
		assertEquals(81l, day5.getSeeds().get(2));
		assertEquals(82l, day5.getSeeds().get(3));
		assertEquals(83l, day5.getSeeds().get(4));
		assertEquals(84l, day5.getSeeds().get(5));
		assertEquals(85l, day5.getSeeds().get(6));
		assertEquals(86l, day5.getSeeds().get(7));
		assertEquals(87l, day5.getSeeds().get(8));
		assertEquals(88l, day5.getSeeds().get(9));
		assertEquals(89l, day5.getSeeds().get(10));
		assertEquals(90l, day5.getSeeds().get(11));
		assertEquals(91l, day5.getSeeds().get(12));
		assertEquals(92l, day5.getSeeds().get(13));
		
		assertEquals(55l, day5.getSeeds().get(14));
		assertEquals(56l, day5.getSeeds().get(15));
		assertEquals(57l, day5.getSeeds().get(16));
		assertEquals(58l, day5.getSeeds().get(17));
		assertEquals(59l, day5.getSeeds().get(18));
		assertEquals(60l, day5.getSeeds().get(19));
		assertEquals(61l, day5.getSeeds().get(20));
		assertEquals(62l, day5.getSeeds().get(21));
		assertEquals(63l, day5.getSeeds().get(22));
		assertEquals(64l, day5.getSeeds().get(23));
		assertEquals(65l, day5.getSeeds().get(24));
		assertEquals(66l, day5.getSeeds().get(25));
		assertEquals(67l, day5.getSeeds().get(26));
	}

	@Test
	void verify_lowest_final_location_of_all_seeds() throws Exception {
		useSampleImput();
		assertEquals(46l, day5.doItAll());
	}
	
//	@Test  Warning takes 85minutes to run.
	void get_answer_Part2() throws Exception {
		day5.doItAll();
	}
}
