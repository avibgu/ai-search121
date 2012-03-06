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

		int tentative_g_score;

		addStateToOpenList(problem, 0, null, problem.getInitState());
				
//		int lastF = problem.getInitState().getF();

		while (!openSet.isEmpty()) {

			ProblemState x = openSet.poll();

//			System.out.println(x);
//			
//			if (lastF > x.getF())
//				try {
//					throw new Exception("NON ADMISSIBLE");
//				} catch (Exception e) {
//					System.err.println("lastF    = " + lastF);
//					System.err.println("x.getF() = " + x.getF());
//					return;
//				}
//			
//			lastF = x.getF();
						
			problem.setCurrentState(x);

			if (x.equals(problem.getGoalState())) {

				problem.setSolved(true);
				return;
			}

			closeSet.add(x);

			Vector<ProblemState> possible_moves = problem.getPossibleMoves(x);

			for (ProblemState possibleNextState : possible_moves) {

				tentative_g_score = x.getG()
						+ problem.getDist(x, possibleNextState);

				if (closeSet.contains(possibleNextState)) {
					if (tentative_g_score < possibleNextState.getG()) {

//						System.err.println(possibleNextState + " G = "
//								+ possibleNextState.getG() + " tentative = "
//								+ tentative_g_score);

						closeSet.remove(possibleNextState);
						addStateToOpenList(problem, tentative_g_score, x,
								possibleNextState);

					} else
						continue;
				}

				if (!openSet.contains(possibleNextState)) {
					addStateToOpenList(problem, tentative_g_score, x,
							possibleNextState);
				} else if (tentative_g_score < possibleNextState.getG()) {
					openSet.remove(possibleNextState);
					addStateToOpenList(problem, tentative_g_score, x,
							possibleNextState);
				}
			}
		}
	}

	private void addStateToOpenList(Problem problem, int tentative_g_score,
			ProblemState x, ProblemState possibleNextState) {

		possibleNextState.setParent(x);
		possibleNextState.setG(tentative_g_score);
		possibleNextState.f(problem.getGoalState());
		openSet.add(possibleNextState);

		problem.incNumOfNodesVisited();
	}
}
