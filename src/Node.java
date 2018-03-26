
public class Node {
	
	private GridState state;
	private Node parent;
	private int pathCost;
	
	public Node() {
	}
	
	
	
	
	
	public Node getParent(){return parent;}
	public boolean isRoot(){return parent == null;}
	
	public int getPathCost(){return pathCost;}
	public GridState getState(){return state;}
	
	
}
