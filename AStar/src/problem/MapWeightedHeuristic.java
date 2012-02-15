package problem;

public class MapWeightedHeuristic extends MapHeuristic {

private static final int DEFAULT_W = 2;
	
	protected int w;

	public MapWeightedHeuristic() {
		this(DEFAULT_W);
	}
	
	public MapWeightedHeuristic(int pW) {
		w = pW;
	}
	
	@Override
	public int calcH(ProblemState pCurrentState, ProblemState pGoalState) {

		return w * super.calcH(pCurrentState, pGoalState);
	}
}
