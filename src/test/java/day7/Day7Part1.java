package day7;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day7Part1 {

	private Day7 day7;
	
	@BeforeEach
	public void setup() {
		day7 = new Day7();
	}
	private void useSampleImput() {
		day7.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day7.populateInput();
	}
	
	@Test 
	void convertFileToArrayOfHandsAndBids() {
		useSampleImput();
		ArrayList<Hand> expectedHands = new ArrayList<Hand>();
		expectedHands.add(new Hand('3', '2', 'T', '3', 'K', 765));
		expectedHands.add(new Hand('T', '5', '5', 'J', '5', 684));
		expectedHands.add(new Hand('K', 'K', '6', '7', '7', 28));
		expectedHands.add(new Hand('K', 'T', 'J', 'J', 'T', 220));
		expectedHands.add(new Hand('Q', 'Q', 'Q', 'J', 'A', 483));
		assertEquals(expectedHands, day7.getHands());
	}
	
	@Test
	void can_recognize_five_of_kind_hands() throws Exception {
		Hand fiveOfKind = new Hand('A', 'A', 'A', 'A', 'A');
		assertEquals(7, fiveOfKind.getStregnth());
		Hand nonFiveOfKind = new Hand('2', 'A', 'A', 'A', 'A');
		assertFalse(nonFiveOfKind.getStregnth()==7);
	}
	
	@Test
	void can_recognize_four_of_kind_hands() throws Exception {
		Hand fourOfKind = new Hand('2', 'A', 'A', 'A', 'A');
		assertEquals(6, fourOfKind.getStregnth());
		Hand nonFourOfKind = new Hand('2', '3', 'A', 'A', 'A');
		assertFalse(nonFourOfKind.getStregnth()==6);
	}
	
	@Test
	void can_recoginze_full_house_hands() throws Exception {
		Hand fullHouse = new Hand('2', 'A', 'A', '2', 'A');
		assertEquals(5, fullHouse.getStregnth());
		Hand nonFullHouse = new Hand('2', '3', 'A', 'A', 'A');
		assertFalse(nonFullHouse.getStregnth()==5);
	}
	
	@Test
	void can_recognize_three_of_kind_hands() throws Exception {
		Hand threeOfKind = new Hand('2', 'A', 'A', '3', 'A');
		assertEquals(4, threeOfKind.getStregnth());
		Hand nonThreeOfKind = new Hand('2', '3', 'A', '4', 'A');
		assertFalse(nonThreeOfKind.getStregnth()==4);
	}
	
	@Test
	void can_recognize_two_pair_hands() throws Exception {
		Hand twoPair = new Hand('2', 'A', 'A', '3', '2');
		assertEquals(3, twoPair.getStregnth());
		Hand nonTwoPair = new Hand('2', '3', 'A', '4', 'A');
		assertFalse(nonTwoPair.getStregnth()==3);
	}
	
	@Test
	void can_recognize_one_pair_hands() throws Exception {
		Hand onePair = new Hand('2', 'A', 'A', '3', '4');
		assertEquals(2, onePair.getStregnth());
		Hand nonOnePair = new Hand('2', '3', '5', '4', 'A');
		assertFalse(nonOnePair.getStregnth()==2);
	}
	
	@Test
	void can_recognize_high_card_hands() throws Exception {
		Hand hightCard = new Hand('2', 'A', '5', '3', '4');
		assertEquals(1, hightCard.getStregnth());
		Hand nonOnePair = new Hand('2', '3', '2', '4', 'A');
		assertFalse(nonOnePair.getStregnth()==1);
	}
	
	@Test
	void hands_can_be_compared_by_stregnth() throws Exception {
		Hand higher = new Hand('Q','Q','Q','J','A');
		Hand lower = new Hand('T','5','5','J','5');
		assertEquals(1, higher.compareTo(lower));
		assertEquals(-1, lower.compareTo(higher));
		Hand equal = new Hand('T','5','5','J','5');
		assertEquals(0, lower.compareTo(equal));
	}
	
	@Test
	void hands_with_same_stregnth_goes_to_sucessive_card_value() throws Exception {
		Hand onePair = new Hand('4', '4', '6', '7', '8');
		Hand lowerOnePair = new Hand('4', '3', '8', '8', 'Q');
		assertEquals(1, onePair.compareTo(lowerOnePair));
	}
	
	@Test
	void verify_hand_comparable_stregnths() throws Exception {
		useSampleImput();
		ArrayList<Hand> expectedOrderedHands = new ArrayList<Hand>();
		expectedOrderedHands.add(new Hand('3','2','T','3','K'));
		expectedOrderedHands.add(new Hand('K','T','J','J','T'));
		expectedOrderedHands.add(new Hand('K','K','6','7','7'));
		expectedOrderedHands.add(new Hand('T','5','5','J','5'));
		expectedOrderedHands.add(new Hand('Q','Q','Q','J','A'));
		
		assertEquals(expectedOrderedHands, day7.getRankOrderedHands());
	}
	
	@Test
	void verify_total_winnings() throws Exception {
		useSampleImput();
		long expectedWinnings = (765 * 1 + 220 * 2 + 28 * 3 + 684 * 4 + 483 * 5);
		
		assertEquals(expectedWinnings, day7.calculateTotalWinnings());
	}
	
	@Test
	void get_Part1_anser() throws Exception {
//		System.out.println(day7.calculateTotalWinnings());
		assertEquals(254024898, day7.calculateTotalWinnings());
	}
}
