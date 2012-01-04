package main;

import problem.Problem;
import problem.TilePuzzle;

import algorithm.*;

public class Main {

	public static void main(String[] args) {

		Problem tp = new TilePuzzle();

		Algorithm a = new AStar();
		
		a.solve(tp);
	}

}
