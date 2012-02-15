package algorithm;

import java.util.PriorityQueue;
import java.util.Vector;

import problem.Problem;
import problem.ProblemState;
import problem.ProblemStateComparator;

public class AStar implements Algorithm{
	
	protected PriorityQueue<ProblemState> openSet;
	protected Vector<ProblemState> closeSet;
                                              
	public AStar() {
		
		super();
	
		closeSet = new Vector<ProblemState>();
		
		openSet = new PriorityQueue<ProblemState>
			(11, new ProblemStateComparator());
	}

	@Override
	public void solve(Problem problem) {
		
		int tentative_g_score;

		openSet.add(problem.getInitState());
		
		while (!openSet.isEmpty()){

			ProblemState x = openSet.poll();
			
			problem.setCurrentState(x);

			//TODO: just for debug
			System.err.println("f(x) = " + x.getF() + ", g(x) = " + x.getG() + " " + x);
			
			if (x.equals(problem.getGoalState())){

				System.err.println("FINISH");
				problem.setSolved(true);
				return;
			 }

		     closeSet.add(x);
		     
		     Vector<ProblemState> possible_moves = problem.getPossibleMoves(x);
		     
		     for (ProblemState possibleNextState: possible_moves){
				
		    	 if (closeSet.contains(possibleNextState)){
	                 continue;
	             }
	             
		    	 tentative_g_score = x.getG() + problem.getDist(x,possibleNextState); 
	 
	             if (!openSet.contains(possibleNextState)){
	                 addStateToOpenList(problem, tentative_g_score, x,
							possibleNextState);
	             }
	             else if (tentative_g_score < possibleNextState.getG()){
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


