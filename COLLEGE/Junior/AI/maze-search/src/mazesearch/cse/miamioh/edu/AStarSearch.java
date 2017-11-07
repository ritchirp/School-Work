package mazesearch.cse.miamioh.edu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class AStarSearch extends SearchStrategy {

	public AStarSearch(Maze maze) {
		super(maze);
	}

	@Override
	public void solve() {
		PriorityQueue<AStarNode> frontier = new PriorityQueue<AStarNode>();
		frontier.add(new AStarNode(this.maze.getStart()));
		LinkedList<AStarNode> tempExplored = new LinkedList<AStarNode>(); // We will use a list for now so that we may access the entries
		
		while(!frontier.isEmpty())
		{
			AStarNode n = frontier.poll();
			
			Square[] children = n.getChildren();
			for(Square s : children)
			{
				
				if (!this.maze.isBlocked(s))
				{
					
					
					// Create a new node and assign its heuristic and path cost
					AStarNode child = new AStarNode(s);
					child.setVisitedFrom(n);
					child.setG(n.getG() + distance(child, n));
					child.setF(child.getG() + h(child));
					
					if(child.equals(this.maze.getGoal())) 
					{
						LinkedList<Square> tempPath = new LinkedList<Square>();
						while(child != null)
						{
							tempPath.addLast(child);
							child = child.getVisitedFrom();
						}
						explored = new HashSet<Square>(tempExplored);
						path = tempPath;
						return;
					}
					
					if (frontier.contains(child) && hasLowerF(child, frontier.iterator()))
						continue;
					if (tempExplored.contains(child) && hasLowerF(child, tempExplored.iterator()))
						continue;

					frontier.add(child);
				}
			}
			tempExplored.add(n);
		}
		
		
	}
	
	private boolean hasLowerF(AStarNode n, Iterator<AStarNode> i){
		AStarNode current;
		while(i.hasNext())
		{
			current = i.next();
			if(current.equals(n))
			{
				if(current.getF() < n.getF())
					return true;
				else
					return false;
			}
		}
		return false;
	}
	
	private float h(Square s){ // The Manhattan Distance Heuristic
		return distance(s, this.maze.getGoal());
	}
	
	private float distance(Square s1, Square s2){
		return Math.abs(s1.getColumn() - s2.getColumn()) + Math.abs(s1.getRow() - s2.getRow());
	}
}
