//David Snyder a247a342 cs771 prog1

import java.util.ArrayList;

public class AStarSearch {
	public static final Node FAILURE = null;
	
	private GridState startState;
	private GridState goalState;
	private Frontier frontier;
	private ArrayList<Node> exploredNodes;
	
	public AStarSearch(GridState start, GridState goal) {
		startState = start;
		goalState = goal;
		frontier = new Frontier(goalState);
		exploredNodes = new ArrayList<Node>();
	}
	
	//A* search
	public Node findPathToGoal(){		
		frontier = new Frontier(goalState);
		exploredNodes = new ArrayList<Node>();
		
		//frontier only holds the starting node at first
		Node startNode = new Node(startState);
		frontier.add(startNode);
		
		while(!frontier.isEmpty()){
			Node currentNode = frontier.pop();
			
			//GOAL TEST, return current node (the goal) if found
			if (currentNode.getState().equals(goalState))
				return currentNode;
			
			exploredNodes.add(currentNode);
			
			//add the current node's children (successor states) to the frontier
			for (GridState successorState: currentNode.getState().listOfPossibleSuccessorStates()){
				Node child = new Node(successorState, currentNode);
				if (!frontier.contains(child) && !exploredNodes.contains(child))
					frontier.add(child);
				else
					frontier.replaceNodeIfPathCostIsSmaller(child);
			}
		}
		
		//return failure if the frontier is empty (no goal found)
		return FAILURE;
	}
	
	public int numberOfNodesRemainingInFrontier(){return frontier.size();}
	public int numberOfNodesExplored(){return exploredNodes.size();}
}
