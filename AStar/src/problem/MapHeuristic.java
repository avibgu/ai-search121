package problem;

public class MapHeuristic implements Heuristic {
	
	
	@Override
	public int calcH(ProblemState currentState, ProblemState goalState) {

		MapState cs = (MapState)currentState;
		MapState gs = (MapState)goalState;
		
		int x1 = cs.getX();
		int y1 = cs.getY();
		
		int x2 = gs.getX();
		int y2 = gs.getY();
		
		return (int) Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
}
