package problem;

import java.util.HashMap;
import java.util.Vector;

public class Map implements Problem {

	protected	ProblemState						_initState;
	protected	ProblemState						_currentState;
	protected	ProblemState						_goalState;
	protected	Heuristic							_heuristic;
	protected	boolean								_solved;
	protected	java.util.Map<String, ProblemState>	_alreadyInitialized;
	protected	int									_numOfNodesVisited;
	protected	long								_runningTime;
	
	public Map(ProblemState initState, ProblemState goalState, Heuristic heuristic){
		
		_initState = initState;
		_currentState = initState;;
		_goalState = goalState;
		
		_heuristic = heuristic;
		
		_solved = false;
		
		_alreadyInitialized = new HashMap<String, ProblemState>();
		
		_numOfNodesVisited = 0;
	}
	
	//TODO remove from interface
	@Override
	public int getDist(ProblemState from, ProblemState to) {
		return 1;
	}

	@Override
	public ProblemState getGoalState() {
		return _goalState;
	}

	@Override
	public Vector<ProblemState> getPossibleMoves(ProblemState ps) {

		Vector<ProblemState> moves = ps.getPossibleMoves();
		
		Vector<ProblemState> ans = new Vector<ProblemState>();
		
		for (ProblemState state : moves){
			
			ProblemState x = _alreadyInitialized.get(state.getId());
			
			if (null == x){
				
				ans.add(state);
				_alreadyInitialized.put(state.getId(), state);
			}
			
			else ans.add(x);
		}
		
		return ans;
	}

	@Override
	public boolean isSolved() {
		return _solved;
	}

	//TODO remove from interface
	@Override
	public ProblemState move(ProblemState desiredState) {
		return null;
	}

	@Override
	public void printSolution() {
		
		if (!_currentState.equals(_goalState))
			System.err.println("There is no solution yet..");
		
		else System.out.println(_currentState + "," + _numOfNodesVisited + "," + _runningTime);
	}

	@Override
	public void setCurrentState(ProblemState x) {
		_currentState = x;
	}

	@Override
	public void setSolved(boolean b) {
		_solved = b;
	}

	@Override
	public ProblemState getInitState() {
		return _initState;
	}
	
	@Override
	public void incNumOfNodesVisited() {
		_numOfNodesVisited++;
	}
	
	@Override
	public int getNumOfNodesVisited() {
		return _numOfNodesVisited;
	}
	
	@Override
	public void setNumOfNodesVisited(int x) {
		_numOfNodesVisited = x;
	}

	@Override
	public void setRunningTime(long runningTime) {
		this._runningTime = runningTime;
		
	}
}
