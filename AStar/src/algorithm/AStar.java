package algorithm;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Vector;

import problem.Problem;
import problem.ProblemState;
import problem.ProblemStateComparator;

public class AStar implements Algorithm {

	protected PriorityQueue<ProblemState> openSet;
	protected Set<ProblemState> closeSet;

	public AStar() {

		super();

		closeSet = new HashSet<ProblemState>();

		openSet = new PriorityQueue<ProblemState>(11,
				new ProblemStateComparator());
	}

	@Override
	public void solve(Problem problem) {
		long startTime = System.currentTimeMillis();
		int tentative_g_score;
		int tentative_f_score;

		openSet.add(problem.getInitState());
		problem.getInitState().setG(0);
		problem.getInitState().f(problem.getGoalState());

		while (!openSet.isEmpty()) {

			ProblemState x = openSet.poll();

			problem.setCurrentState(x);

			if (x.equals(problem.getGoalState())) {

				problem.setSolved(true);
				problem.setRunningTime((System.currentTimeMillis() - startTime));
				return;
			}

			closeSet.add(x);
						
			Vector<ProblemState> possible_moves = problem.getPossibleMoves(x);

			for (ProblemState possibleNextState : possible_moves) {

				tentative_g_score = x.getG() + problem.getDist(x, possibleNextState);

				tentative_f_score = tentative_g_score + possibleNextState.getHeuristic(problem.getGoalState());
			
				if (closeSet.contains(possibleNextState)) {
				
					if (tentative_f_score < possibleNextState.getF()) {
						closeSet.remove(possibleNextState);
						possibleNextState.setParent(x);
						possibleNextState.setG(tentative_g_score);
						possibleNextState.setF(tentative_f_score);
						openSet.add(possibleNextState);
					} else
						continue;
				}

				else if (!openSet.contains(possibleNextState)) {
					addStateToOpenList(problem, tentative_g_score, x,
							possibleNextState,tentative_f_score);
				} else if (tentative_f_score < possibleNextState.getF()) {
					openSet.remove(possibleNextState);
					possibleNextState.setParent(x);
					possibleNextState.setG(tentative_g_score);
					possibleNextState.setF(tentative_f_score);
					openSet.add(possibleNextState);
				}
			}
		}
		
	}

	private void addStateToOpenList(Problem problem, int tentative_g_score,
			ProblemState x, ProblemState possibleNextState,int tentative_f_score) {

		possibleNextState.setParent(x);
		possibleNextState.setG(tentative_g_score);
		possibleNextState.setF(tentative_f_score);
		openSet.add(possibleNextState);

		problem.incNumOfNodesVisited(); 
	}
	

}
