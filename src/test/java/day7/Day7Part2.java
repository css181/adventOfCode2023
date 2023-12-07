package day7;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import day7.part2.Day7_J;
import day7.part2.Hand_J;

public class Day7Part2 {

	private Day7_J day7;
	
	@BeforeEach
	public void setup() {
		day7 = new Day7_J();
	}
	private void useSampleImput() {
		day7.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day7.populateInput();
	}
	
	@Test
	void can_recognize_five_of_kind_hands() throws Exception {
		Hand_J fiveOfKind = new Hand_J('A', 'J', 'A', 'A', 'A');
		assertEquals(7, fiveOfKind.getStregnth());
		Hand_J nonFiveOfKind = new Hand_J('2', 'A', 'A', 'A', 'A');
		assertFalse(nonFiveOfKind.getStregnth()==7);
	}
	
	@Test
	void can_recognize_four_of_kind_hands() throws Exception {
		Hand_J fourOfKind = new Hand_J('2', 'A', 'J', 'J', 'A');
		assertEquals(6, fourOfKind.getStregnth());
		Hand_J nonFourOfKind = new Hand_J('2', '3', 'A', 'A', 'A');
		assertFalse(nonFourOfKind.getStregnth()==6);
	}
	
	@Test
	void can_recoginze_full_house_hands() throws Exception {
		Hand_J fullHouse = new Hand_J('2', 'A', 'J', '2', 'A');
		assertEquals(5, fullHouse.getStregnth());
		Hand_J nonFullHouse = new Hand_J('2', '3', 'A', 'A', 'A');
		assertFalse(nonFullHouse.getStregnth()==5);
	}
	
	@Test
	void can_recognize_three_of_kind_hands() throws Exception {
		Hand_J threeOfKind = new Hand_J('2', 'J', 'J', '3', 'A');
		assertEquals(4, threeOfKind.getStregnth());
		Hand_J nonThreeOfKind = new Hand_J('2', '3', 'A', '4', 'A');
		assertFalse(nonThreeOfKind.getStregnth()==4);
	}
	
	@Test
	void can_recognize_two_pair_hands() throws Exception {
		Hand_J twoPair = new Hand_J('2', 'A', 'A', '3', '2');
		assertEquals(3, twoPair.getStregnth());
		Hand_J nonTwoPair = new Hand_J('2', '3', 'A', '4', 'A');
		assertFalse(nonTwoPair.getStregnth()==3);
	}
	
	@Test
	void can_recognize_one_pair_hands() throws Exception {
		Hand_J onePair = new Hand_J('2', 'A', 'J', '3', '4');
		assertEquals(2, onePair.getStregnth());
		Hand_J nonOnePair = new Hand_J('2', '3', '5', '4', 'A');
		assertFalse(nonOnePair.getStregnth()==2);
	}
	
	@Test
	void can_recognize_high_card_hands() throws Exception {
		Hand_J hightCard = new Hand_J('2', 'A', '5', '3', '4');
		assertEquals(1, hightCard.getStregnth());
		Hand_J nonOnePair = new Hand_J('2', '3', '2', '4', 'A');
		assertFalse(nonOnePair.getStregnth()==1);
	}
	
	@Test
	void hands_can_be_compared_by_stregnth() throws Exception {
		Hand_J higher = new Hand_J('Q','Q','Q','J','A');
		Hand_J lower = new Hand_J('T','5','5','J','5');
		assertEquals(1, higher.compareTo(lower));
		assertEquals(-1, lower.compareTo(higher));
		Hand_J equal = new Hand_J('T','5','5','J','5');
		assertEquals(0, lower.compareTo(equal));
	}
	
	@Test
	void hands_with_same_stregnth_goes_to_sucessive_card_value_and_J_is_low() throws Exception {
		Hand_J onePair = new Hand_J('4', '4', '6', '7', '8');
		Hand_J lowerOnePair = new Hand_J('4', 'J', '9', '8', 'Q');
		assertEquals(1, onePair.compareTo(lowerOnePair));
	}
	
	@Test
	void verify_hand_comparable_stregnths() throws Exception {
		useSampleImput();
		ArrayList<Hand_J> expectedOrderedHand_Js = new ArrayList<Hand_J>();
		expectedOrderedHand_Js.add(new Hand_J('3','2','T','3','K'));
		expectedOrderedHand_Js.add(new Hand_J('K','K','6','7','7'));
		expectedOrderedHand_Js.add(new Hand_J('T','5','5','J','5'));
		expectedOrderedHand_Js.add(new Hand_J('Q','Q','Q','J','A'));
		expectedOrderedHand_Js.add(new Hand_J('K','T','J','J','T'));
		assertEquals(expectedOrderedHand_Js, day7.getRankOrderedHands());
	}
	
	@Test
	void verify_total_winnings() throws Exception {
		useSampleImput();
		long expectedWinnings = 5905;
		
		assertEquals(expectedWinnings, day7.calculateTotalWinnings());
	}
	
	@Test
	void get_Part1_anser() throws Exception {
//		System.out.println(day7.calculateTotalWinnings());
		assertEquals(254115617, day7.calculateTotalWinnings());
	}
}
