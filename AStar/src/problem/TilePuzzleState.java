package problem;

public class TilePuzzleState implements ProblemState{

	protected int[][] _tiles;
	
	public TilePuzzleState(int[][] _tiles){
		
	}
	
	@Override
	public String toString(){
		
		StringBuffer sb = new StringBuffer();
		
		for (int[] row: _tiles){
			
			for (int cellValue: row)
				sb.append(cellValue + "\t");
				
			sb.append("\n");
		}

		sb.append("\n");
		
		return sb.toString();
	}

	@Override
	public boolean equals(ProblemState other) {

		boolean ans = true;
		
		if (!(other instanceof TilePuzzleState))
			ans = false;
		
		else if (_tiles.length != ((TilePuzzleState)other)._tiles.length)
			ans = false;
		
		for (int i = 0; i < _tiles.length && ans; i++){
		
			if (_tiles[i].length != ((TilePuzzleState)other)._tiles[i].length)
				ans = false;
		
			for (int j = 0; j < _tiles[i].length && ans; j++)
				if (_tiles[i][j] != ((TilePuzzleState)other)._tiles[i][j])
					ans = false;					
		}
		
		return ans;
	}
}
