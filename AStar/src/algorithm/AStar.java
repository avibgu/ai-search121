package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

import problem.Problem;
import problem.ProblemState;

public class AStar implements Algorithm{
	
	protected ProblemState start;
	protected ProblemState goal;
	
	protected PriorityQueue<ProblemState> openSet;
	protected Vector<ProblemState> closeSet;
                                              
	public AStar(final ProblemState pStart, final ProblemState pGoal) {
		
		super();
		
		this.start = pStart;
		this.goal = pGoal;
		
		closeSet = new Vector<ProblemState>();
		
		openSet = new PriorityQueue<ProblemState>(11, new Comparator<ProblemState>() {

			@Override
			public int compare(ProblemState o1, ProblemState o2) {
				
				int o1FGoal = o1.f(pGoal);
				int o2FGoal = o2.f(pGoal);
				
				if (o1FGoal < o2FGoal) return -1;
				
				else if(o1FGoal > o2FGoal) return 1;
				
				return 0;
			}
		});
		
		openSet.add(pStart);
		
		pStart.setG(0);
	}
	
	private ProblemState findFMin() {
		
		int min  = Integer.MAX_VALUE;
		
		ProblemState result = null;
		
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
			 
//			ProblemState x = findFMin();
			
			ProblemState x = openSet.poll();
			 
			 if (x.equals(goal)){
			//	 return reconstruct_path(goal.getParent());
				 tp.setSolved(true);
				 return;
			 }
			 
//			 openSet.remove(x);
		     closeSet.add(x);
		     
		     Vector<ProblemState> possible_moves = tp.getPossibleMoves(x);
		     
		     for (int i = 0; i < possible_moves.size(); ++i){
	            
		    	 ProblemState problemState = possible_moves.get(i);
				
		    	 if (closeSet.contains(problemState)){
	                 continue;
	             }
	             
		    	 tentative_g_score = x.getG() + tp.getDist(x,problemState); 
	 
	             if (!openSet.contains(problemState)){
	                 openSet.add(problemState);
	                 tentative_is_better = true;
	             }
	             else if (tentative_g_score < problemState.getG()){
	                 tentative_is_better = true;
	             }
	             else{
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


