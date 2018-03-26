import java.util.ArrayList;


public class GridState {
	public static final int DEFAULT_SIZE = 3;
	
	//number of squares in grid = size^2 -1.
	private int size = DEFAULT_SIZE;
	
	private int[][] squares;
	
	
	public GridState(int gridsize) {
		size = gridsize;		
		squares = new int[size][size];
	}
	public GridState() {
		this(DEFAULT_SIZE);
	}
	
	
	
	public void setSquare(int i, int j, int setValue){
		squares[i][j] = setValue; 
	}
	public int getSquare(int i, int j){
		return squares[i][j];
	}
	
	
	
	//returns the manhattan distance from this state to the given state
	public int manhattanDistanceTo(GridState goal){
		int totalDistance = 0;
		
		for (int digit = 1; digit < size*size; digit++){
			int thisY=0, thisX=0, goalY=0, goalX=0;
			
			for (int i=0; i<size; i++){
				for (int j=0; j<size; j++){
					if (this.getSquare(i, j) == digit){
						thisY = i;
						thisX = j;
					}
					if (goal.getSquare(i, j) == digit){
						goalY = i;
						goalX = j;
					}
				}
			}
			int distanceForCurrentDigit = Math.abs(thisY - goalY) + Math.abs(thisX - goalX);
			System.out.println(digit + ": " + distanceForCurrentDigit);
			totalDistance += distanceForCurrentDigit;
		}
		
		
		return totalDistance;
	}
	
	
	
	public boolean equals(GridState other){
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				if (this.getSquare(i, j) != other.getSquare(i, j))
					return false;
		return true;
	}
	
	public String toString(){
		String gridstring = "";
		for (int i=size-1; i>=0; i--){
			for (int j=0; j<size; j++)
				gridstring += String.format("%3d", getSquare(i, j));
			gridstring += "\n";
		}
		
		return gridstring;
	}
}
