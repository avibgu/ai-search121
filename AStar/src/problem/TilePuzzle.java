package problem;

import java.util.Vector;

public class TilePuzzle implements Problem {

	protected ProblemState _initState;
	protected ProblemState _currentState;
	protected ProblemState _goalState;
	
	public TilePuzzle(ProblemState initState, ProblemState goalState){
		
		_initState = initState;
		_currentState = initState;;
		_goalState = goalState;
	}

	@Override
	public Vector<ProblemState> getPossibleMoves(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ProblemState move(ProblemState desiredState){
		// TODO Auto-generated method stub		
		return null;
	}

	@Override
	public boolean isSolved() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void printSolution() {
		// TODO Auto-generated method stub
	}
}
