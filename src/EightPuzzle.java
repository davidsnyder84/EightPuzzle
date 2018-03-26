//David Snyder a247a342 cs771 prog1
//main program
//generalized to solve (n^2 - 1) puzzle problem (extra credit)

import java.util.Scanner;

public class EightPuzzle {
	
	public static void main(String[] args) {
		
		final int CHOICE_INPUT = 1, CHOICE_DEMO_3 = 2, CHOICE_DEMO_5 = 3;
		System.out.println("\n(n^2 - 1)Puzzle Solver\n");
		System.out.println(
				"===Choose an option===\n"+
				"  1. Input start/goal/gridsize manually\n"+
				"  2. View demo (n=3)\n"+
				"  3. View demo (n=5)\n"+
				"choice: ");
		@SuppressWarnings("resource")
		int choice = (new Scanner(System.in)).nextInt();
		
		int gridSize;
		GridState startState = null, goalState = null;
		
		//pick start and goal states
		switch (choice){
		case CHOICE_INPUT:
			gridSize = askForSize();
			System.out.print("\n-----Enter START state configuration-----\n");
			startState = askForSquares(gridSize);
			System.out.print("\n-----Enter GOAL state configuration-----\n");
			goalState = askForSquares(gridSize);
			break;
		case CHOICE_DEMO_3:
			gridSize = 3;
			startState = DemoGrids.getStartDemoSize3();
			goalState = DemoGrids.getGoalDemoSize3();
			break;
		case CHOICE_DEMO_5:
			gridSize = 5;
			startState = DemoGrids.getStartDemoSize5();
			goalState = DemoGrids.getGoalDemoSize5();
			break;
		default:
			System.out.print("exiting program.........");
			return;
		}
		
		performSearch(startState, goalState);
	}
	
	
	private static void performSearch(GridState startState, GridState goalState){
		System.out.println("\nStarting state: \n" + startState +
					"\nDesired Goal state: \n" + goalState +
					"\n(Manhattan distance h(n) from start state to goal state: " + startState.manhattanDistanceTo(goalState) + ")"+
					"\nBeginning search...");
		
		//perform search
		AStarSearch searcher = new AStarSearch(startState, goalState);
		Node path = searcher.findPathToGoal();
		
		System.out.println("\n\n\n\n\n******SEARCH COMPLETE"+
					"\nNodes remaining in frontier: " + searcher.numberOfNodesRemainingInFrontier() +
					"\nTotal nodes explored: "+ searcher.numberOfNodesExplored());
		
		//print solution path
		if (path != null){
			System.out.println("\n************Solution found!************");
			System.out.println("Path to goal (printing backwards from goal to start state):\n" + path.getPathAsString());
		}
		else
			System.out.println("\nxxxxxxxxFAILURE. NO SOLUTION FOUND\n");
		
		System.out.println("========================================\n========================================\n========================================");		
	}
	
	
	
	//-----------user input methods
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
	
	public static int askForSize(){
		System.out.print("\n\nEnter grid size n (grid will contain n^2 - 1 squares): ");
		@SuppressWarnings("resource")
		int size = (new Scanner(System.in)).nextInt();
		
		return size;
	}
	
}
