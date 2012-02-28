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
	
		map2();
	
	}
	
	
	private static void map2(){
		
		
		// SHIRAN
		solve(mapProblemsGenerator(656	,2,	66,	741));
		solve(mapProblemsGenerator(754	,99	,31,	681));//492.836
		solve(mapProblemsGenerator(50	,725	,728,	47));//	495.593
		solve(mapProblemsGenerator(39	,38	,767	,660));//	495.806
		solve(mapProblemsGenerator(748	,39	,68,	744));//	499.434
		solve(mapProblemsGenerator(767	,706	,48,	60));//	499.233
		solve(mapProblemsGenerator(63	,4,	759,	651));//	496.333
		solve(mapProblemsGenerator(3 ,699,	552,	61));//	499.919
		solve(mapProblemsGenerator(691,	7,	250,	744));//	498.392
		solve(mapProblemsGenerator(270,	757,	732,	41));//	496.907
		solve(mapProblemsGenerator(531,	42,	84,	704));//	499.404
		solve(mapProblemsGenerator(650,	179,	48,	707));//499.877
		solve(mapProblemsGenerator(757,	59,	4	,428));//	497.321
		solve(mapProblemsGenerator(7,	84,	724,	581));//	496.505
		solve(mapProblemsGenerator(	627,	44,	357,	754	));//	500.505
		solve(mapProblemsGenerator(516,	117,	46	,746));//	503.635
		solve(mapProblemsGenerator(	515,	47,	133,	757));//	503.563
		solve(mapProblemsGenerator(85,	587	,729	,102));//	501.563
		solve(mapProblemsGenerator(7,	112,	378,	696));//	500.848
	
		
		//AVI
		solve(mapProblemsGenerator(225	,743	,379	,25));//	503.877
		solve(mapProblemsGenerator(724	,712,	355,	41));//	502.534
		solve(mapProblemsGenerator(665	,28	,144	,445));//	503.877
		solve(mapProblemsGenerator(34	,2,	390,	515));//	500.132
		solve(mapProblemsGenerator(712	,756	,7,	628));//	500.019	
		solve(mapProblemsGenerator(68	,735,	376,	154));//	505.12
		solve(mapProblemsGenerator(723	,40	,74	,372));//	507.848
		solve(mapProblemsGenerator(139	,345,	688,	730));//	506.818
		solve(mapProblemsGenerator(57	,603	,86	,21));//	506.321
		solve(mapProblemsGenerator(134	,12,	626,	570));//	504.948
		solve(mapProblemsGenerator(24	,610	,685	,643));//	504.333
		solve(mapProblemsGenerator(36	,10,	753,	116));//	505.161
		solve(mapProblemsGenerator(528	,748	,212	,155));//	505.392
		solve(mapProblemsGenerator(50	,484,	546,	24));//	505.978
		solve(mapProblemsGenerator(617	,718	,645	,118));//	506.233
		solve(mapProblemsGenerator(87	,467,	586,	36));//	509.362
		solve(mapProblemsGenerator(135	,757	,754	,465));//	509.291
		solve(mapProblemsGenerator(241	,153	,384,	686));//	509.492
		solve(mapProblemsGenerator(439	,728	,342	,81));//	509.919
		solve(mapProblemsGenerator(1	,341,	689,	190));//	509.049
		
	}
	
	private static void map1(){
		solve(mapProblemsGenerator(468, 493, 2, 2));

		solve(mapProblemsGenerator(465,188,61,188));//492.836
		solve(mapProblemsGenerator(101,332,509,337));//	495.593
		solve(mapProblemsGenerator(77,437,109,17));//	495.806
		solve(mapProblemsGenerator(331,436,21,203));//	499.434
		solve(mapProblemsGenerator(31,169,398,11));//	499.233
		solve(mapProblemsGenerator(259,92,507,404));//	496.333
		solve(mapProblemsGenerator(470,43,319,427));//	499.919
		solve(mapProblemsGenerator(449,31,462,456));//	498.392
		solve(mapProblemsGenerator(2,465,397,321));//	496.907
		solve(mapProblemsGenerator(116,418,338,78));//	499.404
		solve(mapProblemsGenerator(126,281,491,469));//499.877
		solve(mapProblemsGenerator(25,246,434,319));//	497.321
		solve(mapProblemsGenerator(7,21,221,356));//	496.505
		solve(mapProblemsGenerator(486,74,228,385));//	500.505
		solve(mapProblemsGenerator(308,465,299,55));//	503.635
		solve(mapProblemsGenerator(21,291,427,319));//	503.563
		solve(mapProblemsGenerator(335,114,211,506));//	501.563
		solve(mapProblemsGenerator(20,205,381,381));//	500.848
		solve(mapProblemsGenerator(19,106,439,45));//	503.877
		solve(mapProblemsGenerator(143,277,506,434));//	502.534
		solve(mapProblemsGenerator(14,116,425,26));//	503.877
		solve(mapProblemsGenerator(27,451,318,162));//	500.132
		solve(mapProblemsGenerator(157,35,263,440));//	500.019	
		solve(mapProblemsGenerator(383,116,228,511));//	505.12
		solve(mapProblemsGenerator(11,324,378,139));//	507.848
		solve(mapProblemsGenerator(284,70,15,371));//	506.818
		solve(mapProblemsGenerator(506,148,88,101));//	506.321
		solve(mapProblemsGenerator(307,422,492,70));//	504.948
		solve(mapProblemsGenerator(179,90,456,385));//	504.333
		solve(mapProblemsGenerator(502,457,203,188));//	505.161
		solve(mapProblemsGenerator(251,454,455,91));//	505.392
		solve(mapProblemsGenerator(346,430,255,2));//	505.978
		solve(mapProblemsGenerator(303,82,34,395));
		solve(mapProblemsGenerator(19,3,399,185));
		solve(mapProblemsGenerator(428,426,316,17));
		solve(mapProblemsGenerator(67,39,60,485));
		solve(mapProblemsGenerator(423,146,183,477));
		solve(mapProblemsGenerator(412,7,210,374));
	}
	
	private static void solve(Vector<Problem> problems){
		
		for (Problem p : problems) {
	
			Algorithm a = new AStar();
	
			a.solve(p);
	
			if (p.isSolved())
				p.printSolution();
		}
		
		System.out.println();
	}
		
	private static Vector<Problem> tileProblemsGenerator() {

		Vector<Problem> problems = new Vector<Problem>();

		int[][] initTiles = { { 5, 11, 3, 8 }, { 13, 2, 6, 7 },
				{ 14, 12, 9, 4 }, { 10, 1, 0, 15 } };
		int[][] goalTiles = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }, { 13, 14, 15, 0 } };

		Heuristic heuristic1 = new TilePuzzleWeightedHeuristic(1);
		Heuristic heuristic2 = new TilePuzzleWeightedHeuristic(2);
		Heuristic heuristic5 = new TilePuzzleWeightedHeuristic(5);
		Heuristic heuristic7 = new TilePuzzleWeightedHeuristic(7);
		Heuristic heuristic9 = new TilePuzzleWeightedHeuristic(9);
		Heuristic heuristic13 = new TilePuzzleWeightedHeuristic(13);
		Heuristic heuristic15 = new TilePuzzleWeightedHeuristic(15);
		Heuristic heuristic17 = new TilePuzzleWeightedHeuristic(17);
		Heuristic heuristic20 = new TilePuzzleWeightedHeuristic(20);
		Heuristic heuristic25 = new TilePuzzleWeightedHeuristic(25);

		problems.add(new TilePuzzle(new TilePuzzleState(initTiles, heuristic1),
				new TilePuzzleState(goalTiles, heuristic1), heuristic1));
		problems.add(new TilePuzzle(new TilePuzzleState(initTiles, heuristic2),
				new TilePuzzleState(goalTiles, heuristic2), heuristic2));
		problems.add(new TilePuzzle(new TilePuzzleState(initTiles, heuristic5),
				new TilePuzzleState(goalTiles, heuristic5), heuristic5));
		problems.add(new TilePuzzle(new TilePuzzleState(initTiles, heuristic7),
				new TilePuzzleState(goalTiles, heuristic7), heuristic7));
		problems.add(new TilePuzzle(new TilePuzzleState(initTiles, heuristic9),
				new TilePuzzleState(goalTiles, heuristic9), heuristic9));
		problems.add(new TilePuzzle(
				new TilePuzzleState(initTiles, heuristic13),
				new TilePuzzleState(goalTiles, heuristic13), heuristic13));
		problems.add(new TilePuzzle(
				new TilePuzzleState(initTiles, heuristic15),
				new TilePuzzleState(goalTiles, heuristic15), heuristic15));
		problems.add(new TilePuzzle(
				new TilePuzzleState(initTiles, heuristic17),
				new TilePuzzleState(goalTiles, heuristic17), heuristic17));
		problems.add(new TilePuzzle(
				new TilePuzzleState(initTiles, heuristic20),
				new TilePuzzleState(goalTiles, heuristic20), heuristic20));
		problems.add(new TilePuzzle(
				new TilePuzzleState(initTiles, heuristic25),
				new TilePuzzleState(goalTiles, heuristic25), heuristic25));

		return problems;
	}

	private static Problem tileProblemGenerator() {

		// int[][] initTiles = {{0,3},{1,2}};
		// int[][] goalTiles = {{0,1},{2,3}};

		int[][] initTiles = { { 1, 4, 2 }, { 3, 5, 8 }, { 6, 0, 7 } };
		int[][] goalTiles = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };

		// int[][] initTiles = {{5,11,3,8},{13,2,6,7},{14,12,9,4},{10,1,0,15}};
		// int[][] goalTiles = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};

		Heuristic heuristic = new TilePuzzleHeuristic();
		// Heuristic heuristic = new TilePuzzleWeightedHeuristic(2);
		// Heuristic heuristic = new TilePuzzleWeightedHeuristic(2);

		ProblemState init = new TilePuzzleState(initTiles, heuristic);
		ProblemState goal = new TilePuzzleState(goalTiles, heuristic);

		return new TilePuzzle(init, goal, heuristic);
	}

	private static Vector<Problem> mapProblemsGenerator(int pX1, int pY1,
			int pX2, int pY2) {

		Vector<Problem> maps = new Vector<Problem>();

		//int[][] map = FileManipulator.getMapFromFile("8room_004.map");
		int[][] map = FileManipulator.getMapFromFile("BrokenSteppes.map");

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

		maps.add(new Map(new MapState(pX1, pY1, map, heuristic1), new MapState(
				pX2, pY2, map, heuristic1), heuristic1));
		maps.add(new Map(new MapState(pX1, pY1, map, heuristic2), new MapState(
				pX2, pY2, map, heuristic2), heuristic2));
		maps.add(new Map(new MapState(pX1, pY1, map, heuristic5), new MapState(
				pX2, pY2, map, heuristic5), heuristic5));
		maps.add(new Map(new MapState(pX1, pY1, map, heuristic7), new MapState(
				pX2, pY2, map, heuristic7), heuristic7));
		maps.add(new Map(new MapState(pX1, pY1, map, heuristic9), new MapState(
				pX2, pY2, map, heuristic9), heuristic9));
		maps.add(new Map(new MapState(pX1, pY1, map, heuristic13),
				new MapState(pX2, pY2, map, heuristic13), heuristic13));
		maps.add(new Map(new MapState(pX1, pY1, map, heuristic15),
				new MapState(pX2, pY2, map, heuristic15), heuristic15));
		maps.add(new Map(new MapState(pX1, pY1, map, heuristic17),
				new MapState(pX2, pY2, map, heuristic17), heuristic17));
		maps.add(new Map(new MapState(pX1, pY1, map, heuristic20),
				new MapState(pX2, pY2, map, heuristic20), heuristic20));
		maps.add(new Map(new MapState(pX1, pY1, map, heuristic25),
				new MapState(pX2, pY2, map, heuristic25), heuristic25));

		return maps;
	}
}
