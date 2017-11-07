package mazesearch.cse.miamioh.edu;


public class AStarNode extends Square implements Comparable<AStarNode> {
	
	private float f, g;
	private Square[] children;
	private AStarNode visitedFrom;
	
	public AStarNode(Square s) {
		super(s.getRow(), s.getColumn());
		this.visitedFrom = null;
		generateChildren();
	}


	@Override
	public int compareTo(AStarNode arg0) {
		// TODO Auto-generated method stub
		return (int) Math.floor(this.f - arg0.f);
	}
	
	private void generateChildren(){
		this.children = new Square[4];
		int row = this.getRow();
		int column = this.getColumn();
		
		children[0] = new Square(row + 1, column);
		children[1] = new Square(row - 1, column);
		children[2] = new Square(row, column + 1);
		children[3] = new Square(row, column - 1);
	}


	
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}


	public float getF() {
		return f;
	}


	public void setF(float f) {
		this.f = f;
	}


	public float getG() {
		return g;
	}


	public void setG(float g) {
		this.g = g;
	}


	public AStarNode getVisitedFrom() {
		return visitedFrom;
	}


	public void setVisitedFrom(AStarNode visitedFrom) {
		this.visitedFrom = visitedFrom;
	}


	public Square[] getChildren() {
		return children;
	}
}
