import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;


public class NodeComparator implements Comparator<Node> {
	
	private GridState goalState;
	
	public NodeComparator(GridState goal){
		goalState = goal;
	}
	
	@Override
	public int compare(Node arg0, Node arg1) {
		return f(arg0) - f(arg1);
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
