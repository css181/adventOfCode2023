package day8;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day8Part1 {

	private Day8 day8;
	
	@BeforeEach
	public void setup() {
		day8 = new Day8();
	}
	private void useSampleImput() {
		day8.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day8.populateInput();
	}

	@Test 
	void convertFileToArrayOfCharArrayTest() {
		useSampleImput();
		ArrayList<Character> eMoves = new ArrayList<>(Arrays.asList('L','L','R'));
		Node aaa = new Node("AAA");
		Node bbb = new Node("BBB");
		Node zzz = new Node("ZZZ");
		aaa.setLeft(bbb);
		aaa.setRight(bbb);
		bbb.setLeft(aaa);
		bbb.setRight(zzz);
		zzz.setLeft(zzz);
		zzz.setRight(zzz);
		ArrayList<Node> expected = new ArrayList<Node>(Arrays.asList(aaa, bbb, zzz));
		
		assertEquals(eMoves, day8.getMoves());
		assertEquals(expected, day8.getNodes());
	}
	
	@Test
	void can_count_moves_following_directions_till_we_get_to_ZZZ() throws Exception {
		useSampleImput();
		
		assertEquals(6, day8.getTotalMoevesTillZZZ());
	}
	
	@Test
	void verify_with_Input2() throws Exception {
		day8.setFileToUse(new File(getClass().getResource("SampleInput2.txt").getPath()));
		day8.populateInput();
		assertEquals(2, day8.getTotalMoevesTillZZZ());
	}
	
	@Test
	void get_part1_answer() throws Exception {
//		System.out.println(day8.getTotalMoevesTillZZZ());
		assertEquals(12357789728873l, day8.getLMCOfAllMovesTillZ());
	}
}
