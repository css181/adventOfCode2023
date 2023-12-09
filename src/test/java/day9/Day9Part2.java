package day9;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day9Part2 {

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
	void can_get_prior_prediction_num_from_treeBreakdown() throws Exception {
		useSampleImput();
		ArrayList<ArrayList<Long>> treeBreakdown = day9.getTreeBreakdownForInputLine(day9.getInput().get(0));
		assertEquals(-3l, day9.getPriorPredictionFromTreeBreakdown(treeBreakdown));
		treeBreakdown = day9.getTreeBreakdownForInputLine(day9.getInput().get(1));
		assertEquals(0l, day9.getPriorPredictionFromTreeBreakdown(treeBreakdown));
		treeBreakdown = day9.getTreeBreakdownForInputLine(day9.getInput().get(2));
		assertEquals(5l, day9.getPriorPredictionFromTreeBreakdown(treeBreakdown));
	}
	
	@Test
	void get_sum_of_all_predictions() throws Exception {
		useSampleImput();
		assertEquals(2l, day9.getSumOfAllPriorPredictions());
	}
	
	@Test
	void get_part2_answer() throws Exception {
//		System.out.println(day9.getSumOfAllPriorPredictions());
		assertEquals(973l, day9.getSumOfAllPriorPredictions());
	}
}
