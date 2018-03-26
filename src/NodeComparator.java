import java.util.Comparator;


public class NodeComparator implements Comparator<Node> {
	
	private GridState goalState;
	
	public NodeComparator(GridState goal){
		goalState = goal;
	}
	
	
	//compares two nodes based on the evaluation function 
	@Override
	public int compare(Node node1, Node node2) {
		return f(node1) - f(node2);
	}
	
	
	//evaluation function f(n) is h(n) + g(n)
	public int f(Node n){
		return h(n) + g(n);
	}
	//heuristic function h(n) is manhattan distance to goal state
	public int h(Node n){
		return n.getState().manhattanDistanceTo(goalState);
	}
	//cost function g(n) is path cost
	public int g(Node n){
		return n.getPathCost();
	}
}
