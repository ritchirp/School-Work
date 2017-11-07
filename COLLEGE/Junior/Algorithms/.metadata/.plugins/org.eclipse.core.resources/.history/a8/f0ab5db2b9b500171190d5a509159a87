package ritchirp.miamioh.edu;

import java.util.Arrays;

public class TSPDemo {

	public static void main(String[] args) {
		
//		PermIterator p = new PermIterator(5);
//		
//		while(p.hasNext()){
//			System.out.println(Arrays.toString(p.next()));
//		}
		
		TSPParser parser = new TSPParser();
		try {
			DumbSolver solver = new DumbSolver(parser.parseFile("ulyssesN.tsp"));
			long start = System.currentTimeMillis();
			solver.solve();
			long end = System.currentTimeMillis();
			System.out.println("" + (end - start)/1000.0 + " seconds");
			System.out.println(solver.getBestRouteLength());
			System.out.println(Arrays.toString(solver.getBestRoute()));
			System.out.println(solver.toLatexString());
			
		} catch (TSPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
