package problem;

public interface Heuristic {

	int calcH(ProblemState _currentState, ProblemState _goalState);
}
