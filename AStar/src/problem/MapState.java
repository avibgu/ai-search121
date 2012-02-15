package problem;

import java.util.Vector;

public class MapState implements ProblemState {

	protected int			x;
	protected int			y;
	
	protected int[][]		map;
	
	protected int			f;
	protected int			g;

	protected String		id;
	protected ProblemState	parent;

	protected Heuristic		heuristic;
	
	public MapState(int pX, int pY, int[][] pMap, Heuristic pHeuristic) {

		x = pX;
		y = pY;		
		
		map = pMap;
		
		f = 0;
		g = 0;
		
		id = x + "." + y;

		parent = null;

		heuristic = pHeuristic;
	}
	
	@Override
	public boolean equals(ProblemState other) {

		if (!(other instanceof MapState))
			return false;

		return (((MapState)other).x == x && ((MapState)other).y == y);
	}

	@Override
	public int f(ProblemState goalState) {
		
		f = g + heuristic.calcH(this, goalState);
		
		return f;
	}
	
	@Override
	public Vector<ProblemState> getPossibleMoves() {

		Vector<ProblemState> result = new Vector<ProblemState>();
		
		if (x != 0)	// left
			if (0 == map[y][x-1])
				result.add(new MapState(x-1, y, map, heuristic));

		if (map.length > 0 && x != map[0].length - 1)	// right
			if (0 == map[y][x+1])
				result.add(new MapState(x+1, y, map, heuristic));
		
		if (y != 0)	// up
			if (0 == map[y-1][x])
				result.add(new MapState(x, y-1, map, heuristic));
		
		if (y != map.length - 1)	// down
			if (0 == map[y+1][x])
				result.add(new MapState(x, y+1, map, heuristic));
		
		return result;
	}

	@Override
	public int getF() {
		return f;
	}

	@Override
	public int getG() {
		return g;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public ProblemState getParent() {
		return parent;
	}

	@Override
	public void setG(int pG) {
		g = pG;
	}

	@Override
	public void setId(String pID) {
		id = pID;
	}

	@Override
	public void setParent(ProblemState pParent) {
		parent = pParent;
	}
	
	@Override
	public String toString() {
		return "f(x) = " + f + ", g(x) = " + g + " " + "(" + x + "," + y + ")";
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
