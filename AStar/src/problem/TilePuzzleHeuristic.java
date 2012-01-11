package problem;

public class TilePuzzleHeuristic implements Heuristic {

	@Override
	public int calcH(ProblemState _currentState, ProblemState _goalState) {

		TilePuzzleState cs = (TilePuzzleState)_currentState;
		TilePuzzleState gs = (TilePuzzleState)_goalState;
		
		int[][] cTiles = cs.getTiles();
		int[][] gTiles = gs.getTiles();
		
		int cost = 0;
		
		for (int ci = 0; ci < cTiles.length; ci++)	
			for (int cj = 0; cj < cTiles[ci].length; cj++)
				for (int gi = 0; gi < gTiles.length; gi++)
					for (int gj = 0; gj < cTiles[gi].length; gj++)
						if (cTiles[ci][cj] == gTiles[gi][gj])
							cost += Math.abs(ci - gi) + Math.abs(cj - gj);							
		
		return cost;
	}

}
