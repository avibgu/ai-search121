package problem;

import java.util.Vector;

public interface Problem {

	public Vector<ProblemState> getPossibleMoves(ProblemState ps);

	public ProblemState move(ProblemState desiredState);
	
	public boolean isSolved();
	
	public void printSolution();
	
	public int getDist(ProblemState from, ProblemState to);

	public void setSolved(boolean b);
}
