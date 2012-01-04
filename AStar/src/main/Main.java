package main;

import problem.Problem;
import problem.ProblemState;
import problem.TilePuzzle;
import problem.TilePuzzleState;

import algorithm.*;

public class Main {

	public static void main(String[] args) {

		int[][] initTiles = null;	//TODO
		int[][] goalTiles = null;	//TODO
		
		ProblemState init = new TilePuzzleState(initTiles);
		ProblemState goal = new TilePuzzleState(goalTiles);
		
		Problem tp = new TilePuzzle(init, goal);

		Algorithm a = new AStar();
		
		a.solve(tp);
		
		if (tp.isSolved())
			tp.printSolution();
	}

}
