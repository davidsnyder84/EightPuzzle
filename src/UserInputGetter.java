import java.util.Scanner;


public class UserInputGetter {
	
	
	public static int askForSize(){
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print("\n\nEnter grid size n (grid will contain n^2 - 1 squares): ");
		int size = keyboard.nextInt();
		
		return size;
	}
	
	
	public static GridState askForStartState(int size){
		System.out.print("\n-----Enter START state configuration-----\n");
		return askForSquares(size);
	}
	public static GridState askForGoalState(int size){
		System.out.print("\n\n-----Enter GOAL state configuration-----\n");
		return askForSquares(size);
	}
	
	private static GridState askForSquares(int size){
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		
		GridState gridState = new GridState(size);
		for (int i=size-1; i>=0; i--){
			for (int j=0; j<size; j++){
				System.out.printf("Enter value for the square located at (%d, %d): ", i, j);
				int squareValue = keyboard.nextInt();
				gridState.setSquare(i, j, squareValue);
			}
		}
		
		return gridState;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
