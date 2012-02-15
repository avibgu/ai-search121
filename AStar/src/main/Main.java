package main;

import file.FileManipulator;
import problem.Heuristic;
import problem.Map;
import problem.MapHeuristic;
import problem.MapState;
import problem.MapWeightedHeuristic;
import problem.Problem;
import problem.ProblemState;
import problem.TilePuzzle;
import problem.TilePuzzleHeuristic;
import problem.TilePuzzleState;
import problem.TilePuzzleWeightedHeuristic;

import algorithm.*;

public class Main {

	public static void main(String[] args) {

//		Problem p = tileProblemGenerator();
		Problem p = mapProblemGenerator();

		Algorithm a = new AStar();
		
		a.solve(p);
		
		if (p.isSolved())
			p.printSolution();
	}

	
	private static Problem tileProblemGenerator() {
		
//		int[][] initTiles = {{0,3},{1,2}};
//		int[][] goalTiles = {{0,1},{2,3}};

		int[][] initTiles = {{1,4,2},{3,5,8},{6,0,7}};
		int[][] goalTiles = {{0,1,2},{3,4,5},{6,7,8}};
		
//		int[][] initTiles = {{5,11,3,8},{13,2,6,7},{14,12,9,4},{10,1,0,15}};
//		int[][] goalTiles = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
		
		Heuristic heuristic = new TilePuzzleHeuristic();
//		Heuristic heuristic = new TilePuzzleWeightedHeuristic(2);
//		Heuristic heuristic = new TilePuzzleWeightedHeuristic(2);
		
		ProblemState init = new TilePuzzleState(initTiles, heuristic);
		ProblemState goal = new TilePuzzleState(goalTiles, heuristic);
		
		return new TilePuzzle(init, goal, heuristic);
	}
	
	
	private static Problem mapProblemGenerator() {

		Heuristic heuristic = new MapHeuristic();
//		Heuristic heuristic = new MapWeightedHeuristic(2);
		
		int[][] map = FileManipulator.getMapFromFile("8room_004.map");
		
		ProblemState init = new MapState(2, 2, map, heuristic);
		ProblemState goal = new MapState(101, 28, map, heuristic);
		
		return new Map(init, goal, heuristic);
	}
}
