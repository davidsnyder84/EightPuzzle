import java.util.ArrayList;
import java.util.Collections;

//priority queue ordered by evaluation function
public class Frontier extends ArrayList<Node>{
	private static final long serialVersionUID = -440663375692450499L;
	private static final int FRONT = 0;
	
	private GridState goalState;
	private NodeComparator nodeComparator;
	
	
	public Frontier(GridState goal){
		goalState = goal;
		//comparator used to order nodes by their evaluation function value
		nodeComparator = new NodeComparator(goalState);
	}
	
	
	@Override
	public boolean add(Node n){
		super.add(n);
		//sort frontier (ordered by evaulation function) after adding a node
		Collections.sort(this, nodeComparator);
		return true;
	}
	
	
	public Node pop(){return remove(FRONT);}
	
	
	//checks if a state already exists in the frontier, and replaces it if the new node containing that state's path cost is smaller
	public void replaceNodeIfPathCostIsSmaller(Node newNode){
		if (!contains(newNode)) return;
		
		Node originalNode = get(indexOf(newNode));
		if (originalNode.getPathCost() > newNode.getPathCost()){
			remove(originalNode);
			add(newNode);
		}
	}
}
