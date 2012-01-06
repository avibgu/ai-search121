package problem;

public interface ProblemState {

	public ProblemState getParent();
	
	public boolean equals(ProblemState other);
	
	public int f(TilePuzzleState goalState);
}
