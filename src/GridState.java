import java.awt.Point;
import java.util.ArrayList;



public class GridState {
	public static final int DEFAULT_SIZE = 3;
	private static final int BLANK_SQUARE = 0;
	
	//number of squares in grid = size^2 -1.
	private int size = DEFAULT_SIZE;
	private int[][] squares;
	
	
	public GridState(int gridsize) {
		size = gridsize;
		squares = new int[size][size];
	}
	public GridState(){this(DEFAULT_SIZE);}
	//copy constructor
	public GridState(GridState other){
		size = other.size;
		squares = new int[size][size];
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				setSquare(i, j, other.getSquare(i, j));
	}
	
	
	
	public void setSquare(int i, int j, int setValue){squares[i][j] = setValue;}
	public void setSquare(Point p, int setValue){setSquare(p.x, p.y, setValue);}	
	public int getSquare(int i, int j){return squares[i][j];}
	public int getSquare(Point p){return getSquare(p.x, p.y);}
	
	
	
	
	
	//returns the manhattan distance from this state to the given state
	public int manhattanDistanceTo(GridState goal){
		int totalDistance = 0;

		for (int currentDigit = 1; currentDigit < size*size; currentDigit++){
			Point digitCoordsInThis = this.coordinatesOfDigit(currentDigit);
			Point digitCoordsInGoal = goal.coordinatesOfDigit(currentDigit);
			
			int distanceForCurrentDigit = Math.abs(digitCoordsInThis.y - digitCoordsInGoal.y) + Math.abs(digitCoordsInThis.x - digitCoordsInGoal.x);
			totalDistance += distanceForCurrentDigit;
//			System.out.println(currentDigit + ": " + distanceForCurrentDigit);
		}
		
		return totalDistance;
	}
	
	
	//returns the coordinate position of the given digit ("Where is 4? It is in position (x,y)")
	public Point coordinatesOfDigit(int digit){
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				if (getSquare(i, j) == digit)
					return new Point(i,j);
		return null;
	}
	
	
	
	
	public ArrayList<GridState> listOfPossibleSuccessorStates(){
		ArrayList<GridState> successorStates = new ArrayList<GridState>();
		
		//find the blank square
		Point positionOfBlank = coordinatesOfDigit(BLANK_SQUARE);
		
		//coordinates of all possible neighbors of the blank square
		ArrayList<Point> neighborsOfBlank = new ArrayList<Point>();
		neighborsOfBlank.add(new Point(positionOfBlank.x - 1, positionOfBlank.y));
		neighborsOfBlank.add(new Point(positionOfBlank.x + 1, positionOfBlank.y));
		neighborsOfBlank.add(new Point(positionOfBlank.x, positionOfBlank.y - 1));
		neighborsOfBlank.add(new Point(positionOfBlank.x, positionOfBlank.y + 1));
		
		//generate successor states by swapping the blank square with its neighbors
		for (Point coordinatesOfNeighbor: neighborsOfBlank)
			if (validCoordinate(coordinatesOfNeighbor)){
				GridState swappedState = new GridState(this);
				swappedState.swapSquares(positionOfBlank, coordinatesOfNeighbor);
				successorStates.add(swappedState);
			}
		
		return successorStates;
	}
	
	private void swapSquares(Point p1, Point p2){
		int temp = getSquare(p1);
		setSquare(p1, getSquare(p2));
		setSquare(p2, temp);
	}
	
	//returns true if the coordinate exists on the grid (it is within the grid's boundaries)
	private boolean validCoordinate(Point p){
		return (p.x >= 0 && p.y >= 0 && p.x < size && p.y < size);
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean equals(Object o){
		GridState other = (GridState) o;
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
