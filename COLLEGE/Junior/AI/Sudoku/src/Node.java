import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Node {
	List<Integer> domain; 
	int value;
	Set<Node> children;
	int row, col;
	
	public Node(){
		super();
		this.children = new HashSet<Node>();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}


	@Override
	public String toString() {
		if(this.value == 0) return "-";
		return "" + value;
	}
	
	
}
