package mazesearch.cse.miamioh.edu;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class DepthFirstSearch extends SearchStrategy {
	

	
	public DepthFirstSearch(Maze maze)
	{
		super(maze);
	}
	
	@Override
	public void solve() 
	{
		Solve(new Node(this.maze.getStart()));
	}
	
	private void Solve(Node n)
	{
		Square s = n.getSquare();
		
		if(s.equals(this.maze.getGoal()))
		{
			LinkedList<Square> solution = new LinkedList<Square>();
			
			while(n != null)
			{
				solution.addLast(n.getSquare());
				n = n.getVisitedFrom();
			}
			
			path = solution;
			return;
		}
		else
		{
			Square[] children = n.getChildren();
			explored.add(s);
			for(Square child : children){
				if(!this.maze.isBlocked(child) && !explored.contains(child))
				{
					Node newNode = new Node(child);
					newNode.setVisitedFrom(n);
					Solve(newNode);
				}
			}
			


		}
	}
}
