package day2;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import day2.pojos.Game;


public class Day2Part1 {

	private GamesWithColorDicePulls day2;
	
	@BeforeEach
	public void setup() {
		day2 = new GamesWithColorDicePulls();
	}
	private void useSampleImput() {
		day2.setFileToUse(new File(getClass().getResource("SampleInput.txt").getPath()));
		day2.populateInput();
	}
	
	@Test 
	void populate_from_input() {
		useSampleImput();
		ArrayList<Game> expected = new ArrayList<Game>();
		expected.add(new Game(1, new ArrayList<>(Arrays.asList(4,1,0)), new ArrayList<>(Arrays.asList(0,2,2)), new ArrayList<>(Arrays.asList(3,6,0))));
		expected.add(new Game(2, new ArrayList<>(Arrays.asList(0,1,0)), new ArrayList<>(Arrays.asList(2,3,1)), new ArrayList<>(Arrays.asList(1,4,1))));
		expected.add(new Game(3, new ArrayList<>(Arrays.asList(20,4,1)), new ArrayList<>(Arrays.asList(8,13,5)), new ArrayList<>(Arrays.asList(6,5,0))));
		expected.add(new Game(4, new ArrayList<>(Arrays.asList(3,6,14)), new ArrayList<>(Arrays.asList(1,3,3)), new ArrayList<>(Arrays.asList(6,0,15))));
		expected.add(new Game(5, new ArrayList<>(Arrays.asList(6,1)), new ArrayList<>(Arrays.asList(3,2)), new ArrayList<>(Arrays.asList(1,2))));
		
		assertEquals(expected, day2.getGames());
	}
	
	@Test
	void verify_games_1_2_and_5_only_are_possible() throws Exception {
		useSampleImput();
		
		assertTrue(day2.getGames().get(0).getIsPossible());
		assertTrue(day2.getGames().get(1).getIsPossible());
		assertFalse(day2.getGames().get(2).getIsPossible());
		assertFalse(day2.getGames().get(3).getIsPossible());
		assertTrue(day2.getGames().get(4).getIsPossible());
	}
	
	@Test
	void verify_sum_of_possible_game_ids_is_8() throws Exception {
		useSampleImput();
		
		assertEquals(8, day2.getSumOfPossibleGameIDs());
	}
	
	@Test
	void get_answer() throws Exception {
//		System.out.println(day2.getSumOfPossibleGameIDs());
		assertEquals(2551, day2.getSumOfPossibleGameIDs());
	}
}
