package day4;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day4Part2 {

	private Day4 day4;
	
	@BeforeEach
	public void setup() {
		day4 = new Day4();
	}
	private void useSampleImput() {
		day4.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day4.populateInput();
	}

	@Test
	void can_get_total_instances_of_cards() throws Exception {
		useSampleImput();
		
		day4.calculateCardInstancesFromWins();
		
		assertEquals(1, day4.getCards().get(0).getInstances());
		assertEquals(2, day4.getCards().get(1).getInstances());
		assertEquals(4, day4.getCards().get(2).getInstances());
		assertEquals(8, day4.getCards().get(3).getInstances());
		assertEquals(14, day4.getCards().get(4).getInstances());
		assertEquals(1, day4.getCards().get(5).getInstances());
	}
	
	@Test
	void verify_total_instances() throws Exception {
		useSampleImput();
		day4.calculateCardInstancesFromWins();
		
		assertEquals(30, day4.getTotalInstancesOfAllCards());
	}
	
//	@Test Takes 3 full seconds to run
	void get_Part2_answer() throws Exception {
		day4.calculateCardInstancesFromWins();
//		System.out.println(day4.getCards());
//		System.out.println(day4.getTotalInstancesOfAllCards());
		assertEquals(6050769, day4.getTotalInstancesOfAllCards());
	}
}
