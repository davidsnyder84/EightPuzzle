import java.util.Scanner;


public class EightPuzzle {
	private static final int CHOICE_INPUT = 1, CHOICE_DEMO_3 = 2, CHOICE_DEMO_5 = 3;
	
	
	public static void main(String[] args) {
		
		System.out.println("\nPuzzle\n");
		System.out.println(
				"===Choose an option===\n"+
				"  1. Input start/goal/gridsize manually\n"+
				"  2. View demo (n=3)\n"+
				"  3. View demo (n=5)\n"+
				"choice: "
				);
		@SuppressWarnings("resource")
		int choice = (new Scanner(System.in)).nextInt();
		if (choice < 1 || choice > 3) return;
		
		int gridSize;
		GridState startState = null, goalState = null;
		
		//pick start and goal states
		if (choice == CHOICE_INPUT){
			gridSize = askForSize();
			System.out.print("\n-----Enter START state configuration-----\n");
			startState = askForSquares(gridSize);
			System.out.print("\n-----Enter GOAL state configuration-----\n");
			goalState = askForSquares(gridSize);
		}
		else if (choice == CHOICE_DEMO_3){
			gridSize = 3;
			startState = DemoGrids.getStartDemoSize3();
			goalState = DemoGrids.getGoalDemoSize3();
		}
		else if (choice == CHOICE_DEMO_5){
			gridSize = 5;
			startState = DemoGrids.getStartDemoSize5();
			goalState = DemoGrids.getGoalDemoSize5();			
		}
		
		System.out.println("\nStarting state: \n" + startState);
		System.out.println("Goal state: \n" + goalState);
		System.out.println("\nBeginning search...");
		
		
		performSearch(startState, goalState);
	}
	
	private static void performSearch(GridState startState, GridState goalState){
		AStarSearch searcher = new AStarSearch(startState, goalState);
		Node path = searcher.findPathToGoal();
		
		if (path != null){
			System.out.println("\n******Solution found!");
			path.printPath();
		}
		else{
			System.out.println("\nxxxxxxxxFAILURE");			
		}
	}
	
	
	
	//user input
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
	
	//user input
	public static int askForSize(){
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print("\n\nEnter grid size n (grid will contain n^2 - 1 squares): ");
		int size = keyboard.nextInt();
		
		return size;
	}
	
}
