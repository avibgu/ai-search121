package problem;

import java.util.Vector;

public interface Problem {

	public Vector<ProblemState> getPossibleMoves(ProblemState ps);

	public ProblemState move(ProblemState desiredState);
	
	public boolean isSolved();
	
	public void printSolution();
	
	public int getDist(ProblemState from, ProblemState to);

	public void setSolved(boolean b);

	public ProblemState getGoalState();

	public void setCurrentState(ProblemState x);

	public ProblemState getInitState();

	public void incNumOfNodesVisited();

	int getNumOfNodesVisited();

	void setNumOfNodesVisited(int x);
}
