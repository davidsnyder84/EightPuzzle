import java.util.ArrayList;
import java.util.Collections;

//priority queue ordered by evaluation function
public class Frontier extends ArrayList<Node>{
	private static final long serialVersionUID = -440663375692450499L;
	private static final int FRONT = 0;
	
	private NodeComparator nodeComparator;
	
	
	public Frontier(GridState goalState){
		nodeComparator = new NodeComparator(goalState);
	}
	
	
	@Override
	public boolean add(Node n){				
		super.add(n);
		//sort frontier (ordered by evaulation function) after adding a node
		Collections.sort(this, nodeComparator);
		
		return true;
	}
	
	
	public Node pop(){
		return remove(FRONT);
	}
	
	public void replaceNodeIfPathCostIsSmaller(Node newNode){
		if (!contains(newNode)) return;
		Node originalNode = get(indexOf(newNode));
		//replace the existing node with the new node if the new node has a lower path cost
		if (originalNode.getPathCost() > newNode.getPathCost()){
			remove(originalNode);
			add(newNode);
		}
	}
	
}
