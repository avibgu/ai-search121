package algorithm;

import java.util.Vector;

import problem.Problem;

public class AStar implements Algorithm{
	
	private Vector<Integer> closeSet = new Vector<Integer>();
	private Vector<Integer> openSet = new Vector<Integer>();
	//private came_from := the empty map    // The map of navigated nodes.
	 
  //  private int g_score[start] = 0;    // Cost from start along best known path.
   // private int h_score[start] = heuristic_cost_estimate(start, goal)
   // private int f_score[start] = g_score[start] + h_score[start]    // Estimated total cost from start to goal through y.
                                               
	@Override
	public void solve(Problem tp) {
		// TODO Auto-generated method stub
		
	}

	public void setCloseSet(Vector<Integer> closeSet) {
		this.closeSet = closeSet;
	}

	public Vector<Integer> getCloseSet() {
		return closeSet;
	}

	public void setOpenSet(Vector<Integer> openSet) {
		this.openSet = openSet;
	}

	public Vector<Integer> getOpenSet() {
		return openSet;
	}

}
