

public class FinalRun {

	public static void main(String[] args) {
		
		Coordinates starPoint1 = new Coordinates(0,0);
		
		
		System.out.println("\n"+" ********* First Trial ********* "+"\n");
		
		System.out.println("\n"+"Output for Breadth First Search"+"\n");
		BreadthFirstSearch bfs1 = new BreadthFirstSearch(starPoint1);
		bfs1.bfs();
		System.out.println("\n"+"Output for Uniform Cost Search"+"\n");
		UniformCS ufcs1 = new UniformCS(starPoint1);
		ufcs1.uniformCS();
		System.out.println("\n"+"Output for Greedy Search"+"\n");
		Greedy greedy1 = new Greedy(starPoint1);
		greedy1.greedy();
		System.out.println("\n"+"Output for Astar Search"+"\n");
		Astar astar1 = new Astar(starPoint1);
		astar1.astar();
		
		System.out.println("\n"+" ********* Second Trial ********* "+"\n");
		
		Coordinates starPoint2 = new Coordinates(1,1);
		
		System.out.println("\n"+"Output for Breadth First Search"+"\n");
		BreadthFirstSearch bfs2 = new BreadthFirstSearch(starPoint2);
		bfs2.bfs();
		System.out.println("\n"+"Output for Uniform Cost Search"+"\n");
		UniformCS ufcs2 = new UniformCS(starPoint2);
		ufcs2.uniformCS();
		System.out.println("\n"+"Output for Greedy Search"+"\n");
		Greedy greedy2 = new Greedy(starPoint2);
		greedy2.greedy();
		System.out.println("\n"+"Output for Astar Search"+"\n");
		Astar astar2 = new Astar(starPoint2);
		astar2.astar();
		
		
		
		
	}
	
}