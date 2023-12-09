package day8;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day8Part2 {

	private Day8 day8;
	
	@BeforeEach
	public void setup() {
		day8 = new Day8();
	}
	private void useSampleImput() {
		day8.setFileToUse(new File(getClass().getResource("SampleInput3.txt").getPath()));
		day8.populateInput();
	}

	@Test 
	void convertFileToArrayOfCharArrayTest() {
		useSampleImput();
		ArrayList<Character> eMoves = new ArrayList<>(Arrays.asList('L','R'));
		Node a11 = new Node("11A");
		Node b11 = new Node("11B");
		Node z11 = new Node("11Z");
		Node a22 = new Node("22A");
		Node b22 = new Node("22B");
		Node c22 = new Node("22C");
		Node z22 = new Node("22Z");
		Node xxx = new Node("XXX");
		a11.setLeft(b11);
		a11.setRight(xxx);
		b11.setLeft(xxx);
		b11.setRight(z11);
		z11.setLeft(b11);
		z11.setRight(xxx);
		a22.setLeft(b22);
		a22.setRight(xxx);
		b22.setLeft(c22);
		b22.setRight(c22);
		c22.setLeft(z22);
		c22.setRight(z22);
		z22.setLeft(b22);
		z22.setRight(b22);
		xxx.setLeft(xxx);
		xxx.setRight(xxx);
		ArrayList<Node> expected = new ArrayList<Node>(Arrays.asList(a11, b11, z11, a22, b22, c22, z22, xxx));
		
		assertEquals(eMoves, day8.getMoves());
		assertEquals(expected, day8.getNodes());
	}
	
	@Test
	//NOTE: Can't do this for the real input, it would run for days and days until it hit the answer
	void verify_simultaneous_moves_until_all_ending_on_Z() throws Exception {
		useSampleImput();
		assertEquals(6, day8.moveSimultaneousUntilAllZ());
	}
	
	@Test
	void can_get_Num_of_moves_for_each_a_till_hits_z() throws Exception {
		useSampleImput();
		ArrayList<Long> expected = new ArrayList<Long>(Arrays.asList(2l,3l));
		assertEquals(expected, day8.getMovesOfEachStartTillEnd());
	}

	@Test
	void can_get_leastCommonMultiple_of_all_moves_till_z() throws Exception {
		useSampleImput();
		assertEquals(6, day8.getLMCOfAllMovesTillZ());
	}
	@Test
	void get_part2_answer() throws Exception {
//		System.out.println(day8.getLMCOfAllMovesTillZ());
		assertEquals(12357789728873l, day8.getLMCOfAllMovesTillZ());
	}

}
