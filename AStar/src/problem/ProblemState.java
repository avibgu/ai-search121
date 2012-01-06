package problem;

public interface ProblemState {

	public ProblemState getParent();
	
	public void setParent(ProblemState parent);
	
	public boolean equals(ProblemState other);
	
	public int f(ProblemState goalState);
	
	public int getG();
		
	public void setG(int g);
}
