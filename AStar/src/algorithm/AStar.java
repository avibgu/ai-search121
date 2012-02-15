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
	
//	private ProblemState findFMin() {
//		
//		int min  = Integer.MAX_VALUE;
//		
//		ProblemState result = null;
//		
//		for (ProblemState state : openSet){
//			
//			int f_result = state.f(goal);
//			
//			if (f_result < min){
//				
//				min = f_result;
//				result = state;
//			}
//		}
//		
//		return result;
//	}

	@Override
	public void solve(Problem tp) {
		
		int tentative_g_score;
//		boolean tentative_is_better;
		
		openSet.add(tp.getInitState());
		
		while (!openSet.isEmpty()){
			 
//			ProblemState x = findFMin();
			
			ProblemState x = openSet.poll();
			
			tp.setCurrentState(x);

			//TODO: just for debug
			System.err.println("f(x) = " + x.getF() + ", g(x) = " + x.getG());
			
			if (x.equals(tp.getGoalState())){
			//	 return reconstruct_path(goal.getParent());
				 tp.setSolved(true);
				 return;
			 }
			 
//			 openSet.remove(x);
		     closeSet.add(x);
		     
		     Vector<ProblemState> possible_moves = tp.getPossibleMoves(x);
		     
		     for (ProblemState possibleNextState: possible_moves){
				
		    	 if (closeSet.contains(possibleNextState)){
	                 continue;
	             }
	             
		    	 tentative_g_score = x.getG() + tp.getDist(x,possibleNextState); 
	 
	             if (!openSet.contains(possibleNextState)){
	                 possibleNextState.setParent(x);
	                 possibleNextState.setG(tentative_g_score);
	                 possibleNextState.f(tp.getGoalState());
	            	 openSet.add(possibleNextState);
//	                 tentative_is_better = true;
	             }
	             else if (tentative_g_score < possibleNextState.getG()){
	                 openSet.remove(possibleNextState);
	                 possibleNextState.setParent(x);
	                 possibleNextState.setG(tentative_g_score);
	                 possibleNextState.f(tp.getGoalState());
	                 openSet.add(possibleNextState);
//	                 tentative_is_better = true;
	             }
//	             else{
//	                 tentative_is_better = false;
//	             }
//	             
//	             if (tentative_is_better){
//	                 possibleNextState.setParent(x);
//	                 possibleNextState.setG(tentative_g_score);
//	             }
		     }
		 }
	}

	

	public void reconstruct_path(ProblemState current_node){
	  /* if (current_node.getParent() != null){
		   Integer p = reconstruct_path(came_from[current_node]);
		   return (p + current_node);
	   } else{
		   return current_node; }*/ 
	}
 

}


