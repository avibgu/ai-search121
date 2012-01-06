package problem;

import java.util.Vector;

public class TilePuzzle implements Problem {

	protected ProblemState _initState;
	protected ProblemState _currentState;
	protected ProblemState _goalState;
	
	protected Heuristic  _heuristic;
	
	protected boolean _solved;
	
	public TilePuzzle(ProblemState initState, ProblemState goalState){
		
		_initState = initState;
		_currentState = initState;;
		_goalState = goalState;
		
		_heuristic = new TilePuzzleHeuristic();
		
		_solved = false;
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
		return _solved;
	}

	@Override
	public void printSolution() {

		if (!_currentState.equals(_goalState))
			System.err.println("There is no solution yet..");
		
		System.out.println(_goalState);
	}
}
