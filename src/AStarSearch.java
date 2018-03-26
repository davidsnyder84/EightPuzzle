import java.util.ArrayList;


public class AStarSearch {

	public AStarSearch() {
	}
	
	public void search(Frontier frontier, ArrayList<Node> exploredNodes){
		
		
		
	}
	
	
	public int f(Node n){
		return h(n) + g(n);
	}
	public int h(Node n){
		return 0;////////////
	}
	public int g(Node n){
		return n.getPathCost();
	}
}
