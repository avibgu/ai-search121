package problem;

import java.util.Vector;

public class TilePuzzleState implements ProblemState{

	protected String			id;
	protected ProblemState		parent;
	protected int[][]			tiles;
	protected int 				g;
	protected int 				f;
	protected Heuristic			heuristic;
	private int h;
	
	public TilePuzzleState(int[][] tTiles, Heuristic tHeuristic){
		
		setTiles(tTiles);
		heuristic = tHeuristic;
		calcId();
		h = -1;
		f=99999999;
		g=99999999;
	}
	
	public TilePuzzleState(String puzzle, Heuristic tHeuristic) {

		puzzle = puzzle.trim();
		
		String[] splitted = puzzle.split(" ");
		
		int n = (int) Math.sqrt(splitted.length);
		
		int[][] tiles = new int[n][n];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				tiles[i][j] = Integer.parseInt(splitted[i*n+j]);
		
		setTiles(tiles);
		heuristic = tHeuristic;
		calcId();
		h = -1;
		f=99999999;
		g=99999999;
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
		
//		StringBuffer sb = new StringBuffer();
//		
//		for (int[] row: getTiles()){
//			
//			for (int cellValue: row)
//				sb.append(cellValue + "\t");
//				
//			sb.append("\n");
//		}
//
//		sb.append("\n f(x)=" + f + "\n");
//		
//		return sb.toString();
		
		return Integer.toString(f);
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
		
		if (-1 == h)
			h = heuristic.calcH(this, goalState);
		
		f = g + h;
		
		return f;
	}
	
	public int getHeuristic(ProblemState goalState){
		if (-1 == h)
			h = heuristic.calcH(this, goalState);
		return h;
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
		
		boolean stop = false;
		
		for (ci = 0; ci < tiles.length; ci++){
			
			for (cj = 0; cj < tiles[ci].length; cj++){
				
				if (0 == tiles[ci][cj]){
					stop = true;
					break;
				}
			}
			
			if (stop) break;
		}

		if (ci != 0){	// down
			
			int[][] tTiles = cloneTiles();

			tTiles[ci][cj] = tTiles[ci-1][cj];
			tTiles[ci-1][cj] = 0;
			
			result.add(new TilePuzzleState(tTiles, heuristic));
		}
		
		if (ci != tiles.length - 1){ //up
		
			int[][] tTiles = cloneTiles();

			tTiles[ci][cj] = tTiles[ci+1][cj];
			tTiles[ci+1][cj] = 0;
			
			result.add(new TilePuzzleState(tTiles, heuristic));
		}
		
		if (cj != 0){ //right
		
			int[][] tTiles = cloneTiles();

			tTiles[ci][cj] = tTiles[ci][cj-1];
			tTiles[ci][cj-1] = 0;
			
			result.add(new TilePuzzleState(tTiles, heuristic));
		}
			
		if (cj != tiles.length - 1){ //left
		
			int[][] tTiles = cloneTiles();

			tTiles[ci][cj] = tTiles[ci][cj+1];
			tTiles[ci][cj+1] = 0;
			
			result.add(new TilePuzzleState(tTiles, heuristic));
		}
		
		return result;
	}

	protected int[][] cloneTiles() {
		
		if (0 == tiles.length)
			return new int[0][0];

		int[][] tTiles = new int[tiles.length][tiles[0].length];
		
		for (int ci = 0; ci < tiles.length; ci++)
			tTiles[ci] = tiles[ci].clone();
		
		return tTiles;
	}

	@Override
	public int getF() {
		return f;
	}

	@Override
	public void setF(int f) {
		this.f = f;
		
	}
}
