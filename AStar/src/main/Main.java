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

		int[][] initTiles = null;	//TODO
		int[][] goalTiles = null;	//TODO
		
		Heuristic heuristic = new TilePuzzleHeuristic();
		
		ProblemState init = new TilePuzzleState(initTiles, heuristic);
		ProblemState goal = new TilePuzzleState(goalTiles, heuristic);
		
		Problem tp = new TilePuzzle(init, goal, heuristic);

		Algorithm a = new AStar();
		
		a.solve(tp);
		
		if (tp.isSolved())
			tp.printSolution();
	}

}
