package problem;

import java.util.Comparator;

public class ProblemStateComparator implements Comparator<ProblemState> {
	
	@Override
	public int compare(ProblemState o1, ProblemState o2) {
		
		int o1FGoal = o1.getF();
		int o2FGoal = o2.getF();
		
		if (o1FGoal < o2FGoal) return -1;
		
		else if(o1FGoal > o2FGoal) return 1;
		
		return 0;
	}
}
