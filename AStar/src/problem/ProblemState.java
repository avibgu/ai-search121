package problem;

import java.util.Vector;

public interface ProblemState {

	public ProblemState getParent();
	
	public void setParent(ProblemState parent);
	
	public boolean equals(ProblemState other);
	
	public int f(ProblemState goalState);
	
	public int getG();
		
	public void setG(int g);
	
	public void setF(int f);
	
	public void setId(String id);
	
	public String getId();

	public Vector<ProblemState> getPossibleMoves();

	public int getF();
	
	public int getHeuristic(ProblemState goalState);
	
}
