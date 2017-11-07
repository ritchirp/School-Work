package mazesearch.cse.miamioh.edu;

import java.util.LinkedList;

public class BreadthFirstSearch extends SearchStrategy {
	
	BreadthFirstSearch(Maze maze){
		super(maze);
	}
	@Override
	public void solve() {
		LinkedList<Node> frontier = new LinkedList<Node>();
		frontier.add(new Node(this.maze.getStart()));
		
		while(!frontier.isEmpty())
		{
			Node n = frontier.pollFirst();
			if(explored.contains(n.getSquare()))
				continue;
			explored.add(n.getSquare());
			
			Square[] children = n.getChildren();
			for(Square s : children)
			{
				Node child = new Node(s);
				child.setVisitedFrom(n);
				if (s.equals(this.maze.getGoal())) {
					LinkedList<Square> tempPath = new LinkedList<Square>();
					while (child != null) {
						tempPath.addLast(child.getSquare());
						child = child.getVisitedFrom();
					}
					this.path = tempPath;
					return;
				}
				if (!this.maze.isBlocked(s) && !explored.contains(s)) {
						frontier.addLast(child);
				}
			}
			
			
			
			
			
		}
		
	}
	

}
