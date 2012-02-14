package problem;


public class TilePuzzleWeightedHeuristic extends TilePuzzleHeuristic {

	private static final int DEFAULT_W = 2;
	
	protected int w;

	public TilePuzzleWeightedHeuristic() {
		this(DEFAULT_W);
	}
	
	public TilePuzzleWeightedHeuristic(int pW) {
		w = pW;
	}
	
	@Override
	public int calcH(ProblemState pCurrentState, ProblemState pGoalState) {

		return w * super.calcH(pCurrentState, pGoalState);
	}
}
