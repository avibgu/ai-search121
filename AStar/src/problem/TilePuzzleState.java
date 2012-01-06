package problem;

public class TilePuzzleState implements ProblemState{

	protected TilePuzzleState	parent;
	protected int[][]			tiles;
	protected int 				g;
	protected Heuristic			heuristic;

	public TilePuzzleState(int[][] tTiles, Heuristic tHeuristic){
		tiles = tTiles;
		heuristic = tHeuristic;
	}
	
	@Override
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		
		for (int[] row: tiles){
			
			for (int cellValue: row)
				sb.append(cellValue + "\t");
				
			sb.append("\n");
		}

		sb.append("\n");
		
		return sb.toString();
	}

	@Override
	public boolean equals(ProblemState other) {

		boolean ans = true;
		
		if (!(other instanceof TilePuzzleState))
			ans = false;
		
		else if (tiles.length != ((TilePuzzleState)other).tiles.length)
			ans = false;
		
		for (int i = 0; i < tiles.length && ans; i++){
		
			if (tiles[i].length != ((TilePuzzleState)other).tiles[i].length)
				ans = false;
		
			for (int j = 0; j < tiles[i].length && ans; j++)
				if (tiles[i][j] != ((TilePuzzleState)other).tiles[i][j])
					ans = false;					
		}
		
		return ans;
	}

	@Override
	public int f(ProblemState goalState) {
		return g + heuristic.calcH(this, goalState);
	}
	
	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	@Override
	public ProblemState getParent() {
		return parent;
	}
}
