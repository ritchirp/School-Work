
public class SudokuTester {

	public static void main(String[] args) {
		SudokuSolver solver = new SudokuSolver();
		
		for(int i=1; i<=5; i++) {
			System.out.println("test" + i + ":");
			long start = System.nanoTime();
			Node[][] temp = solver.solve("test" + i + ".txt");
			long end = System.nanoTime();
			printNodeArray(temp);
			System.out.println("Time taken: " + (end - start)/1000000.0 + " milliseconds");
			System.out.println();
		}

	}
	
	
	static void printNodeArray(Node[][] a) {
		for(int i = 0; i<a.length; i++) {
			for(int j = 0; j<a[i].length; j++) {
				System.out.print(a[i][j].value + " ");
			}
			System.out.println();
		}
	}
	
}