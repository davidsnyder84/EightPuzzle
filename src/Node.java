
public class Node {
	//step cost always costs 1 (one tile is swapped with the blank spot)
	private final static int STEP_COST = 1;
	
	private GridState state;
	private Node parent;
	private int pathCost;
	
	public Node(GridState gridstate, Node parentNode){
		state = gridstate;
		parent = parentNode;
		
		if (isRoot())
			pathCost = 0;
		else
			pathCost = parentNode.getPathCost() + STEP_COST;
		
	}
	public Node(GridState gridstate){this(gridstate, null);}
	
	
	
	
	
	public Node getParent(){return parent;}
	public boolean isRoot(){return parent == null;}
	
	public int getPathCost(){return pathCost;}
	public GridState getState(){return state;}
	
	
	//nodes are "equal" if they have the same state
	@Override
	public boolean equals(Object other){
		return state.equals(((Node)other).getState());
	}
}
