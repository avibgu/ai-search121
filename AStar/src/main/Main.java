package main;

import java.util.Vector;

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
//		Problem p = mapProblemGenerator();
		
		Vector<Problem> problems = mapProblemsGenerator();
		
		for (Problem p : problems){
			
			Algorithm a = new AStar();
			
			a.solve(p);
			
			if (p.isSolved())
				p.printSolution();
		}
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
		ProblemState goal = new MapState(468, 493, map, heuristic);
		
		return new Map(init, goal, heuristic);
	}
	
	private static Vector<Problem> mapProblemsGenerator() {

		Vector<Problem> maps = new Vector<Problem>();
		
		int[][] map = FileManipulator.getMapFromFile("8room_004.map");
		
		Heuristic heuristic1 = new MapWeightedHeuristic(1);
		Heuristic heuristic2 = new MapWeightedHeuristic(2);
		Heuristic heuristic5 = new MapWeightedHeuristic(5);
		Heuristic heuristic7 = new MapWeightedHeuristic(7);
		Heuristic heuristic9 = new MapWeightedHeuristic(9);
		Heuristic heuristic13 = new MapWeightedHeuristic(13);
		Heuristic heuristic15 = new MapWeightedHeuristic(15);
		Heuristic heuristic17 = new MapWeightedHeuristic(17);
		Heuristic heuristic20 = new MapWeightedHeuristic(20);
		Heuristic heuristic25 = new MapWeightedHeuristic(25);

		maps.add(new Map(new MapState(2, 2, map, heuristic1), new MapState(468, 493, map, heuristic1), heuristic1));
		maps.add(new Map(new MapState(2, 2, map, heuristic2), new MapState(468, 493, map, heuristic2), heuristic2));
		maps.add(new Map(new MapState(2, 2, map, heuristic5), new MapState(468, 493, map, heuristic5), heuristic5));
		maps.add(new Map(new MapState(2, 2, map, heuristic7), new MapState(468, 493, map, heuristic7), heuristic7));
		maps.add(new Map(new MapState(2, 2, map, heuristic9), new MapState(468, 493, map, heuristic9), heuristic9));
		maps.add(new Map(new MapState(2, 2, map, heuristic13), new MapState(468, 493, map, heuristic13), heuristic13));
		maps.add(new Map(new MapState(2, 2, map, heuristic15), new MapState(468, 493, map, heuristic15), heuristic15));
		maps.add(new Map(new MapState(2, 2, map, heuristic17), new MapState(468, 493, map, heuristic17), heuristic17));
		maps.add(new Map(new MapState(2, 2, map, heuristic20), new MapState(468, 493, map, heuristic20), heuristic20));
		maps.add(new Map(new MapState(2, 2, map, heuristic25), new MapState(468, 493, map, heuristic25), heuristic25));
		
		return maps;
	}
}
