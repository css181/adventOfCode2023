package day4;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day4Part1 {

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
	void convertFileCardList() {
		useSampleImput();
		ArrayList<Card> expected = new ArrayList<Card>();
		expected.add(new Card(1, new ArrayList<Integer>(Arrays.asList(41,48,83,86,17)), new ArrayList<Integer>(Arrays.asList(83,86,6,31,17,9,48,53))));
		expected.add(new Card(2, new ArrayList<Integer>(Arrays.asList(13,32,20,16,61)), new ArrayList<Integer>(Arrays.asList(61,30,68,82,17,32,24,19))));
		expected.add(new Card(3, new ArrayList<Integer>(Arrays.asList(1,21,53,59,44)), new ArrayList<Integer>(Arrays.asList(69,82,63,72,16,21,14,1))));
		expected.add(new Card(4, new ArrayList<Integer>(Arrays.asList(41,92,73,84,69)), new ArrayList<Integer>(Arrays.asList(59,84,76,51,58,5,54,83))));
		expected.add(new Card(5, new ArrayList<Integer>(Arrays.asList(87,83,26,28,32)), new ArrayList<Integer>(Arrays.asList(88,30,70,12,93,22,82,36))));
		expected.add(new Card(6, new ArrayList<Integer>(Arrays.asList(31,18,13,56,72)), new ArrayList<Integer>(Arrays.asList(74,77,10,23,35,67,36,11))));
		
		assertEquals(expected, day4.getCards());
	}
	
	@Test
	void can_calculate_num_of_wins_on_card() throws Exception {
		useSampleImput();
		
		assertEquals(4, day4.getCards().get(0).getNumOfWins());
		assertEquals(2, day4.getCards().get(1).getNumOfWins());
		assertEquals(2, day4.getCards().get(2).getNumOfWins());
		assertEquals(1, day4.getCards().get(3).getNumOfWins());
		assertEquals(0, day4.getCards().get(4).getNumOfWins());
		assertEquals(0, day4.getCards().get(5).getNumOfWins());
	}
	
	@Test
	void can_calculate_point_values_on_card() throws Exception {
		useSampleImput();
		
		assertEquals(8, day4.getCards().get(0).getPoints());
		assertEquals(2, day4.getCards().get(1).getPoints());
		assertEquals(2, day4.getCards().get(2).getPoints());
		assertEquals(1, day4.getCards().get(3).getPoints());
		assertEquals(0, day4.getCards().get(4).getPoints());
		assertEquals(0, day4.getCards().get(5).getPoints());
	}
	
	@Test
	void verify_point_totals_of_all_cards() throws Exception {
		useSampleImput();
		
		assertEquals(13, day4.getPointTotalOfAllCards());
	}
	
	@Test
	void get_Part1_answer() throws Exception {
		System.out.println(day4.getPointTotalOfAllCards());
	}
}
