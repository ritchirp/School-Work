package mazesearch.cse.miamioh.edu;

public class Node {
	private Square tile;
	private Square[] children;
	private Node visitedFrom;
	
	public Node(Square s){
		this.tile = s;
		this.visitedFrom = null;
		generateChildren();
	}
	

	/*
	 * Does not take into account obstacles or maze size
	 * these will be considered in the algorithms
	 */
	private void generateChildren(){
		this.children = new Square[4];
		int row = this.tile.getRow();
		int column = this.tile.getColumn();
		
		children[0] = new Square(row + 1, column);
		children[1] = new Square(row - 1, column);
		children[2] = new Square(row, column + 1);
		children[3] = new Square(row, column - 1);
	}
	
	public Square getSquare(){
		return this.tile;
	}
	
	public Square[] getChildren(){
		return this.children;
	}

	public Node getVisitedFrom() {
		return visitedFrom;
	}

	public void setVisitedFrom(Node visitedFrom) {
		this.visitedFrom = visitedFrom;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Node)
			return this.tile.equals(((Node) obj).tile);
		return false;
	}
	
}
