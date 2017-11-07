package mazesearch.cse.miamioh.edu;

import java.util.HashSet;
import java.util.LinkedList;

public class BidirectionalSearch extends SearchStrategy {

	public BidirectionalSearch(Maze maze) {
		super(maze);
	}

	@Override
	public void solve() {
		LinkedList<Node> goalFrontier = new LinkedList<Node>();
		LinkedList<Node> startFrontier = new LinkedList<Node>();


		// Put the goal and start into their respective frontiers and mark them as explored
		goalFrontier.add(new Node(maze.getGoal()));
//		explored.add(maze.getGoal());
		startFrontier.add(new Node(maze.getStart()));
//		explored.add(maze.getStart());


		while(!goalFrontier.isEmpty() && !startFrontier.isEmpty())
		{

			Node x = goalFrontier.removeFirst();
			
			if (!explored.contains(x.getSquare())) {

				explored.add(x.getSquare());
				if (x.getSquare().equals(maze.getStart()) || startFrontier.contains(x)) { // a common square has been found

					LinkedList<Square> solution = new LinkedList<Square>();
					Node current = x; // The common node or start found in the goal frontier

					while (current != null) {
						solution.addFirst(current.getSquare());
						current = current.getVisitedFrom();
					}

					// If x is the start then this check will allow us to skip the next loop
					int i = startFrontier.indexOf(x);
					if (i != -1) {
						current = startFrontier.get(i).getVisitedFrom();
					}

					while (current != null) {
						solution.addLast(current.getSquare());
						current = current.getVisitedFrom();
					}

					this.path = solution;
					return;

				}
				addChildren(x, goalFrontier);
			}
			
			
			x = startFrontier.removeFirst();


			if(explored.contains(x.getSquare()))
				continue;
			explored.add(x.getSquare());

			// This if statement is very similar to the one above
			// and serves the same purpose, but for the start frontier
			if(x.getSquare().equals(maze.getGoal()) || goalFrontier.contains(x))
			{
				LinkedList<Square> solution = new LinkedList<Square>();
				Node current = x; // The common node or goal found in the start frontier


				while(current != null){
					solution.addLast(current.getSquare());
					current = current.getVisitedFrom();
				}

				int i = goalFrontier.indexOf(x);
				if (i != -1) {
					current = goalFrontier.get(i).getVisitedFrom();
				}

				while(current != null){
					solution.addFirst(current.getSquare());
					current = current.getVisitedFrom();
				}

				this.path = solution;
				return;
			}
			addChildren(x, startFrontier);

		}
	}

	/*
	 * Adds the children of a node to a specified frontier
	 */
	private void addChildren(Node x, LinkedList<Node> frontier)
	{
		Square[] children = x.getChildren();
		for(Square s : children)
		{
			if(!maze.isBlocked(s) && !explored.contains(s))
			{
				Node n = new Node(s);
				n.setVisitedFrom(x);
				frontier.add(n);
			}
		}
	}

}
