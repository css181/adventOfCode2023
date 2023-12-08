package day8;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import utilities.FileUtility;

public class Day8 {

	private static File file;
	private ArrayList<Character> moves;
	public ArrayList<Character> getMoves() {
		return moves;
	}
	private ArrayList<Node> nodes;
	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public Day8() {
		URL fileName = getClass().getResource("Input.txt");
		file = new File(fileName.getPath());
		populateInput();
	}

	protected void setFileToUse(File file) {
		Day8.file = file;
	}

	public void populateInput() {
		nodes = new ArrayList<Node>();
		ArrayList<String> inputLines = FileUtility.convertFileToStringArray(file);
		moves = new ArrayList<Character>();
		for (char c : inputLines.get(0).toCharArray()) {
		  moves.add(c);
		}
		//Create all the nodes
		for (int x=2; x<inputLines.size(); x++) {
			String line = inputLines.get(x);
			nodes.add(new Node(line.substring(0,3)));
		}
		//Assign all the left and rights, now that all the nodes exist
		for (int x=2; x<inputLines.size(); x++) {
			String line = inputLines.get(x);
			String name = line.substring(0,3);
			String left = line.substring(7,10);
			String right = line.substring(12,15);
			Node curNode = getNodeByName(name);
			curNode.setLeft(getNodeByName(left));
			curNode.setRight(getNodeByName(right));
		}
	}

	private Node getNodeByName(String name) {
		for (Node node : nodes) {
			if(node.getName().equals(name)) {
				return node;
			}
		}
		throw new RuntimeException("Could not find Node: " + name);
	}

	public int getTotalMoevesTillZZZ() {
		Node endNode = getNodeByName("ZZZ");
		Node curNode = getNodeByName("AAA");
		int movePosition = 0;
		int moveCount = 0;
		do {
			if(movePosition>=moves.size()) {
				movePosition = 0;
			}
			moveCount++;
			if(moves.get(movePosition++) == 'L') {
				curNode = curNode.getLeft();
			} else {
				curNode = curNode.getRight();
			}
		} while (!curNode.equals(endNode));
		return moveCount;
	}

}
