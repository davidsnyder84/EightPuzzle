
public class EightPuzzle {
	
	
	public static void main(String[] args) {
		System.out.println("\nPuzzle\n");
		
		int gridSize = pickGridSize();
		GridState startState = pickStartState(gridSize);
		GridState goalState = pickGoalState(gridSize);
		
		System.out.println(startState);
		System.out.println(goalState);
		
		System.out.println("Manhattan distance of start state: " + startState.manhattanDistanceTo(goalState));
		
		
		Node path = findPathToGoal(startState, goalState);
		if (path != null){
			System.out.println("\n******Solved!");
			System.out.println("Path length: " + path.getPathCost());
		}
		
		
		

//		System.out.println(DemoGrids.getStartDemoSize3() + "\n\n");
//		System.out.println(DemoGrids.getGoalDemoSize3() + "\n\n");
//		System.out.println(DemoGrids.getStartDemoSize5() + "\n\n");
//		System.out.println(DemoGrids.getGoalDemoSize5() + "\n\n");
		
		System.out.println("\n\n\nSuccessors of start");
		for (GridState g: startState.listOfPossibleSuccessorStates())
			System.out.println(g);
		System.out.println("\n\n\nSuccessors of goal");
		for (GridState g: goalState.listOfPossibleSuccessorStates())
			System.out.println(g);
		
	}
	
	
	private static Node findPathToGoal(GridState start, GridState goal){
		
		
		return new Node(goal, new Node(goal));
	}
	
	
	private static int pickGridSize(){
		int size = GridState.DEFAULT_SIZE;
//		size = UserInputGetter.askForSize();
		return size;
	}
	
	private static GridState pickStartState(int size){
		GridState startState;
//		startState = UserInputGetter.askForStartState(size);
		startState = DemoGrids.getStartDemoSize3();
		
		return startState;
	}
	
	private static GridState pickGoalState(int size){
		GridState goalState;
//		goalState = UserInputGetter.askForGoalState(size);
		goalState = DemoGrids.getGoalDemoSize3();
		
		return goalState;
	}
	
}
