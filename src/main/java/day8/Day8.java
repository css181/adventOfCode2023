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

	public long moveSimultaneousUntilAllZ() {
		long moveCount = 0;
		ArrayList<Node> curNodes = getAllNodesEndingWithA();
		int movePosition = 0;
		do {
			if(movePosition>=moves.size()) {
				movePosition = 0;
			}
			moveCount++;
			if(moves.get(movePosition++) == 'L') {
				curNodes = advanceAllNodeLeft(curNodes);
			} else {
				curNodes = advanceAllNodeRight(curNodes);
			}
		} while (atLeastOneNodeDoesNotEndInZ(curNodes));
		return moveCount;
	}
	private ArrayList<Node> advanceAllNodeLeft(ArrayList<Node> curNodes) {
		ArrayList<Node> movedNodes = new ArrayList<Node>(curNodes);
		for (int x=0; x<movedNodes.size(); x++) {
			Node curNode = movedNodes.get(x);
			movedNodes.set(x, curNode.getLeft());
		}
		return movedNodes;
	}
	private ArrayList<Node> advanceAllNodeRight(ArrayList<Node> curNodes) {
		ArrayList<Node> movedNodes = new ArrayList<Node>(curNodes);
		for (int x=0; x<movedNodes.size(); x++) {
			Node curNode = movedNodes.get(x);
			movedNodes.set(x, curNode.getRight());
		}
		return movedNodes;
	}

	private boolean atLeastOneNodeDoesNotEndInZ(ArrayList<Node> curNodes) {
		for (Node node : curNodes) {
			if(!node.getName().endsWith("Z")) {
				return true;
			}
		}
		return false;
	}

	private ArrayList<Node> getAllNodesEndingWithA() {
		ArrayList<Node> startNodes = new ArrayList<Node>();
		for (Node node : nodes) {
			if(node.getName().endsWith("A")) { 
				startNodes.add(node);
			}
		}
		return startNodes;
	}


	public ArrayList<Long> getMovesOfEachStartTillEnd() {
		ArrayList<Long> movesTillZ = new ArrayList<Long>();
		ArrayList<Node> startNodes = getAllNodesEndingWithA();
		for (Node node : startNodes) {
			int movePosition = 0;
			long moveCount = 0;
			do {
				if(movePosition>=moves.size()) {
					movePosition = 0;
				}
				moveCount++;
				if(moves.get(movePosition++) == 'L') {
					node = node.getLeft();
				} else {
					node = node.getRight();
				}
			} while (!node.getName().endsWith("Z"));
			movesTillZ.add(moveCount);
		}
		return movesTillZ;
	}

	public long getLMCOfAllMovesTillZ() {
		ArrayList<Long> movesTillZ = getMovesOfEachStartTillEnd();
		return lcmOfArray(movesTillZ);
	}
	private long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}
	private long lcm(long a, long b)
	{
	    return a * (b / gcd(a, b));
	}
	public long lcmOfArray(ArrayList<Long> input)
	{
	    long result = input.get(0);
	    for(int i = 1; i < input.size(); i++) result = lcm(result, input.get(i));
	    return result;
	}
	
}
