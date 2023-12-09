package day9;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day9Part1 {

	private Day9 day9;
	
	@BeforeEach
	public void setup() {
		day9 = new Day9();
	}
	private void useSampleImput() {
		day9.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day9.populateInput();
	}
	
	@Test 
	void convertFileToArrayOfCharArrayTest() {
		useSampleImput();
		ArrayList<ArrayList<Long>> expected = new ArrayList<ArrayList<Long>>();
		expected.add(new ArrayList<Long>(Arrays.asList(0l,3l,6l,9l,12l,15l)));
		expected.add(new ArrayList<Long>(Arrays.asList(1l,3l,6l,10l,15l,21l)));
		expected.add(new ArrayList<Long>(Arrays.asList(10l,13l,16l,21l,30l,45l)));
		assertEquals(expected, day9.getInput());
	}
	
	@Test
	void can_get_tree_breakdown_till_last_array_is_all_zeros() throws Exception {
		useSampleImput();
		ArrayList<ArrayList<Long>> expected = new ArrayList<ArrayList<Long>>();
		expected.add(new ArrayList<Long>(Arrays.asList(0l,3l,6l,9l,12l,15l)));
		expected.add(new ArrayList<Long>(Arrays.asList(3l,3l,3l,3l,3l)));
		expected.add(new ArrayList<Long>(Arrays.asList(0l,0l,0l,0l)));
		assertEquals(expected, day9.getTreeBreakdownForInputLine(day9.getInput().get(0)));
		
		expected = new ArrayList<ArrayList<Long>>();
		expected.add(new ArrayList<Long>(Arrays.asList(1l,3l,6l,10l,15l,21l)));
		expected.add(new ArrayList<Long>(Arrays.asList(2l,3l,4l,5l,6l)));
		expected.add(new ArrayList<Long>(Arrays.asList(1l,1l,1l,1l)));
		expected.add(new ArrayList<Long>(Arrays.asList(0l,0l,0l)));
		assertEquals(expected, day9.getTreeBreakdownForInputLine(day9.getInput().get(1)));
	}
	
	@Test
	void can_get_top_prediction_num_from_treeBreakdown() throws Exception {
		useSampleImput();
		ArrayList<ArrayList<Long>> treeBreakdown = day9.getTreeBreakdownForInputLine(day9.getInput().get(0));
		assertEquals(18l, day9.getPredictionFromTreeBreakdown(treeBreakdown));
		treeBreakdown = day9.getTreeBreakdownForInputLine(day9.getInput().get(1));
		assertEquals(28l, day9.getPredictionFromTreeBreakdown(treeBreakdown));
		treeBreakdown = day9.getTreeBreakdownForInputLine(day9.getInput().get(2));
		assertEquals(68l, day9.getPredictionFromTreeBreakdown(treeBreakdown));
	}
	
	@Test
	void get_sum_of_all_predictions() throws Exception {
		useSampleImput();
		assertEquals(114l, day9.getSumOfAllPredictions());
	}
	
	@Test
	void get_part1_answer() throws Exception {
//		System.out.println(day9.getSumOfAllPredictions());
		assertEquals(1479011877l, day9.getSumOfAllPredictions());
	}
}
