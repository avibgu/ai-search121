package main;

import java.util.Vector;

import algorithm.AStar;
import algorithm.Algorithm;

import problem.Heuristic;
import problem.Problem;
import problem.TilePuzzle;
import problem.TilePuzzleHeuristic;
import problem.TilePuzzleState;
import problem.TilePuzzleWeightedHeuristic;

import file.FileManipulator;

public class AutomaticTilePuzzleTester implements Runnable{

	protected String fileName = null;
	
	protected int[][] goalTiles = null;
	
	protected Heuristic heuristic1 = null;
	protected Heuristic heuristic2 = null;
	protected Heuristic heuristic5 = null;
	protected Heuristic heuristic7 = null;
	protected Heuristic heuristic9 = null;
	protected Heuristic heuristic13 = null;
	protected Heuristic heuristic15 = null;
	protected Heuristic heuristic17 = null;
	protected Heuristic heuristic20 = null;
	protected Heuristic heuristic25 = null;

	public AutomaticTilePuzzleTester(String filename) {

		fileName = filename;
		
		goalTiles = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
		
		heuristic1 = new TilePuzzleHeuristic();
		heuristic2 = new TilePuzzleWeightedHeuristic(2);
		heuristic5 = new TilePuzzleWeightedHeuristic(5);
		heuristic7 = new TilePuzzleWeightedHeuristic(7);
		heuristic9 = new TilePuzzleWeightedHeuristic(9);
		heuristic13 = new TilePuzzleWeightedHeuristic(13);
		heuristic15 = new TilePuzzleWeightedHeuristic(15);
		heuristic17 = new TilePuzzleWeightedHeuristic(17);
		heuristic20 = new TilePuzzleWeightedHeuristic(20);
		heuristic25 = new TilePuzzleWeightedHeuristic(25);
	}
	
	@Override
	public void run() {

		StringBuilder fileContent = FileManipulator.readFromFile(fileName);
		
		Vector<TilePuzzleState> initStates = fromFileToTileStates(fileContent);
		
		for (TilePuzzleState state : initStates){
			
			solve(generateProblemsFromInitState(state));
		}
	}

	private Vector<TilePuzzleState> fromFileToTileStates(StringBuilder fileContent) {

		Vector<TilePuzzleState> ans = new Vector<TilePuzzleState>();
		
		String[] lines = fileContent.toString().split("\n");
		
		Heuristic heuristic = null;
		 
		for (String line : lines)
			if (!line.isEmpty())
				ans.add(new TilePuzzleState(line, heuristic));
			
		return ans;
	}
	
	private Vector<Problem> generateProblemsFromInitState(TilePuzzleState initState){
		
		Vector<Problem> tiles = new Vector<Problem>();

		tiles.add(new TilePuzzle(initState, new TilePuzzleState(goalTiles, heuristic1), heuristic1));
		tiles.add(new TilePuzzle(initState, new TilePuzzleState(goalTiles, heuristic2), heuristic2));
		tiles.add(new TilePuzzle(initState, new TilePuzzleState(goalTiles, heuristic5), heuristic5));
		tiles.add(new TilePuzzle(initState, new TilePuzzleState(goalTiles, heuristic7), heuristic7));
		tiles.add(new TilePuzzle(initState, new TilePuzzleState(goalTiles, heuristic9), heuristic9));
		tiles.add(new TilePuzzle(initState, new TilePuzzleState(goalTiles, heuristic13), heuristic13));
		tiles.add(new TilePuzzle(initState, new TilePuzzleState(goalTiles, heuristic15), heuristic15));
		tiles.add(new TilePuzzle(initState, new TilePuzzleState(goalTiles, heuristic17), heuristic17));
		tiles.add(new TilePuzzle(initState, new TilePuzzleState(goalTiles, heuristic20), heuristic20));
		tiles.add(new TilePuzzle(initState, new TilePuzzleState(goalTiles, heuristic25), heuristic25));
		
		return tiles;
	}
	
	private void solve(Vector<Problem> problems){
		
		Algorithm a;
		Problem p;
		
		while (!problems.isEmpty()) {
	
			a = new AStar();
			p = problems.firstElement();
			
			problems.removeElementAt(0);
			
			a.solve(p);
	
			if (p.isSolved())
				p.printSolution();
			
			System.out.flush();
			
			a = null;
			p = null;
			
			System.gc();
		}
		
		System.out.println();
	}
}
