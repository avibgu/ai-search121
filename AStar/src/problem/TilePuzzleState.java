package problem;

import java.util.Vector;

public class TilePuzzleState implements ProblemState{

	protected String			id;
	protected ProblemState		parent;
	protected int[][]			tiles;
	protected int 				g;
	protected Heuristic			heuristic;
	
	public TilePuzzleState(int[][] tTiles, Heuristic tHeuristic){
		
		setTiles(tTiles);
		heuristic = tHeuristic;
		calcId();
	}
	
	public void calcId() {
		
		StringBuffer sb = new StringBuffer();
		
		for (int ci = 0; ci < tiles.length; ci++){
			
			for (int cj = 0; cj < tiles[ci].length; cj++){
			
				if (tiles[ci][cj] < 10)
					sb.append("0");
				
				sb.append(tiles[ci][cj]);
			}
		}

		id = sb.toString();
	}

	@Override
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		
		for (int[] row: getTiles()){
			
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
		
		else if (getTiles().length != ((TilePuzzleState)other).getTiles().length)
			ans = false;
		
		for (int i = 0; i < getTiles().length && ans; i++){
		
			if (getTiles()[i].length != ((TilePuzzleState)other).getTiles()[i].length)
				ans = false;
		
			for (int j = 0; j < getTiles()[i].length && ans; j++)
				if (getTiles()[i][j] != ((TilePuzzleState)other).getTiles()[i][j])
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

	@Override
	public void setParent(ProblemState parent) {
		this.parent = parent;
		
	}

	public void setTiles(int[][] tiles) {
		this.tiles = tiles;
	}

	public int[][] getTiles() {
		return tiles;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public Vector<ProblemState> getPossibleMoves() {
		
		Vector<ProblemState> result = new Vector<ProblemState>();
		
		int ci = 0;
		int cj = 0;
		
		for (; ci < tiles.length; ci++)
			for (; cj < tiles[ci].length; cj++)
				if (tiles[ci][cj] == 0)
					break;
		
		if (ci != 0){	// down
			
			int[][] tTiles = tiles.clone();

			tTiles[ci][cj] = tTiles[ci-1][cj];
			tTiles[ci-1][cj] = 0;
			
			result.add(new TilePuzzleState(tTiles, heuristic));
		}
		
		if (ci != tiles.length - 1){ //up
		
			int[][] tTiles = tiles.clone();

			tTiles[ci][cj] = tTiles[ci+1][cj];
			tTiles[ci+1][cj] = 0;
			
			result.add(new TilePuzzleState(tTiles, heuristic));
		}
		
		if (cj != 0){ //right
		
			int[][] tTiles = tiles.clone();

			tTiles[ci][cj] = tTiles[ci][cj-1];
			tTiles[ci][cj-1] = 0;
			
			result.add(new TilePuzzleState(tTiles, heuristic));
		}
			
		if (cj != tiles.length - 1){ //left
		
			int[][] tTiles = tiles.clone();

			tTiles[ci][cj] = tTiles[ci][cj+1];
			tTiles[ci][cj+1] = 0;
			
			result.add(new TilePuzzleState(tTiles, heuristic));
		}
		
		return result;
	}
}
