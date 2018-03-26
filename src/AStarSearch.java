import java.util.ArrayList;


public class AStarSearch {
	public static final Node FAILURE = null;
	
	private GridState startState;
	private GridState goalState;
	
	public AStarSearch(GridState start, GridState goal) {
		startState = start;
		goalState = goal;
	}
	
	public Node search(){		
		Frontier frontier = new Frontier(goalState);
		ArrayList<Node> exploredNodes = new ArrayList<Node>();
		
		//frontier only holds the starting node at first
		Node startNode = new Node(startState);
		frontier.add(startNode);
		
		while(!frontier.isEmpty()){
			Node currentNode = frontier.pop();
			
			//GOAL TEST, return current node (the goal) if found
			if (currentNode.getState().equals(goalState))
				return currentNode;
			
			exploredNodes.add(currentNode);
			System.out.println("explored: " + exploredNodes.size());
			System.out.println("front: " + frontier.size());
//			if (frontier.size() == 1400 || frontier.size() == 2800 || frontier.size() == 3600 || frontier.size() == 4500) frontier.printsomething();
			
			//add the current node's children (successor states) to the frontier
			for (GridState successorState: currentNode.getState().listOfPossibleSuccessorStates()){
				Node child = new Node(successorState, currentNode);
				if (!frontier.contains(child) && !exploredNodes.contains(child))
					frontier.add(child);
				else
					frontier.replaceNodeIfPathCostIsSmaller(child);
			}
		}
		
		return FAILURE;
	}
	
	
	
}
