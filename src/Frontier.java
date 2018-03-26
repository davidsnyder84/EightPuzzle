import java.util.ArrayList;
import java.util.Collections;


public class Frontier extends ArrayList<Node>{
	private static final long serialVersionUID = -440663375692450499L;
	private static final int TOP = 0;
	
	private NodeComparator nodeComparator;
	
	
	public Frontier(GridState goalState){
		nodeComparator = new NodeComparator(goalState);
	}
	
	
	@Override
	public boolean add(Node n){
		
		Collections.sort(this, nodeComparator);
		
		super.add(n);
		return true;
	}
	
	
	public Node pop(){
		return remove(TOP);
	}
	
}
