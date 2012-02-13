package main;

import problem.Heuristic;
import problem.Problem;
import problem.ProblemState;
import problem.TilePuzzle;
import problem.TilePuzzleHeuristic;
import problem.TilePuzzleState;

import algorithm.*;

public class Main {

	public static void main(String[] args) {

//		int[][] initTiles = {{0,3},{1,2}};
//		int[][] goalTiles = {{0,1},{2,3}};

		int[][] initTiles = {{1,4,2},{3,5,8},{6,0,7}};
		int[][] goalTiles = {{0,1,2},{3,4,5},{6,7,8}};
		
//		int[][] initTiles = {{5,11,3,8},{13,2,6,7},{14,12,9,4},{10,1,0,15}};
//		int[][] goalTiles = {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}};
		
		Heuristic heuristic = new TilePuzzleHeuristic();
		
		ProblemState init = new TilePuzzleState(initTiles, heuristic);
		ProblemState goal = new TilePuzzleState(goalTiles, heuristic);
		
		Problem tp = new TilePuzzle(init, goal, heuristic);

		Algorithm a = new AStar(init,goal);
		
		a.solve(tp);
		
		if (tp.isSolved())
			tp.printSolution();
	}

}
