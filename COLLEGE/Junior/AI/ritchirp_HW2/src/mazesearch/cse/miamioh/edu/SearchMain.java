package mazesearch.cse.miamioh.edu;


public class SearchMain {

	  public static void main(String args[]) {
		  testSearches("maze1.txt");
		  testSearches("maze2.txt");
		  testSearches("maze3.txt");
	  }
	  
	  public static void testSearches(String mazeName){
		  Maze maze = new Maze(mazeName);
		  BreadthFirstSearch BFS = new BreadthFirstSearch(maze);
		  BidirectionalSearch BDS = new BidirectionalSearch(maze);
		  DepthFirstSearch DFS = new DepthFirstSearch(maze);
		  AStarSearch AS = new AStarSearch(maze);
		  
		  System.out.println(mazeName);
		  System.out.println("BFS path: " + BFS.getPathFromStartToGoal());
		  System.out.println("BFS path length = " + BFS.getPathFromStartToGoal().size());
		  System.out.println("BFS explored states: " + BFS.getExploredSquares().size());
		  
		  System.out.println("DFS path: " + DFS.getPathFromStartToGoal());
		  System.out.println("DFS path length = " + DFS.getPathFromStartToGoal().size());
		  System.out.println("DFS explored states: " + DFS.getExploredSquares().size());
		  
		  System.out.println("A* path: " + AS.getPathFromStartToGoal());
		  System.out.println("A* path length = " + AS.getPathFromStartToGoal().size());
		  System.out.println("A* explored states: " + AS.getExploredSquares().size());
		  
		  System.out.println("BDS path: " + BDS.getPathFromStartToGoal());
		  System.out.println("BDS path length = " + BDS.getPathFromStartToGoal().size());
		  System.out.println("BDS explored states: " + BDS.getExploredSquares().size());
		  
		  System.out.println();
	  }
	  
	}


