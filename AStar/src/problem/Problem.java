package problem;

import java.util.Vector;

public interface Problem {

	public Vector<ProblemState> getPossibleMoves();

	public ProblemState move(ProblemState desiredState);

	public boolean isSolved();
	
	public void printSolution();
}
