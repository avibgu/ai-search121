package algorithm;

import java.util.Vector;

import problem.Problem;
import problem.ProblemState;

public class AStar implements Algorithm{
	
	private Vector<ProblemState> closeSet = new Vector<ProblemState>();
	private Vector<ProblemState> openSet = new Vector<ProblemState>();
	private ProblemState start;
	private ProblemState goal;
	
                                              
	public AStar(ProblemState start, ProblemState goal) {
		super();
		this.start = start;
		this.goal = goal;
		start.setG(0);
		openSet.add(start);
		
	}
	
	private ProblemState findFMin() {
		int min  = 99999999;
		ProblemState result=null;
		for (ProblemState state : openSet){
			int f_result = state.f(goal);
			if (f_result < min){
				min = f_result;
				result = state;
			}
		}
		return result;
	}



	@Override
	public void solve(Problem tp) {
		int tentative_g_score;
		boolean tentative_is_better;
		while (!openSet.isEmpty()){
			 ProblemState x = findFMin();
			 if (x == goal){
			//	 return reconstruct_path(goal.getParent());
				 return;
			 }
			 openSet.remove(x);
		     closeSet.add(x);
		     Vector<ProblemState> possible_moves = tp.getPossibleMoves();
		     for (int i=0; i<possible_moves.size(); ++i){
	             ProblemState problemState = possible_moves.get(i);
				if (closeSet.contains(problemState)){
	                 continue;
	             }
	             tentative_g_score = x.getG() + tp.getDist(x,problemState); 
	 
	             if (!openSet.contains(problemState)){
	                 openSet.add(problemState);
	                 tentative_is_better = true;
	             } else if (tentative_g_score < problemState.getG()){
	                 tentative_is_better = true;
	             }else{
	                 tentative_is_better = false;
	             }
	             if (tentative_is_better){
	                 problemState.setParent(x);
	                 problemState.setG(tentative_g_score);
	             }
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
