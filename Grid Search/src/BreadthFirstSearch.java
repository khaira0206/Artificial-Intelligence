
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends Search {

	public BreadthFirstSearch(Coordinates starPoint) {
		this.starPoint = starPoint;
		createMaze();
	}

	public void bfs() {
		Queue<Loc> queue = new LinkedList<Loc>();
		queue.add(points[starPoint.x][starPoint.y]);

		while (!queue.isEmpty()) {
			Loc a = queue.remove();
			visitedList.add(a);

			if (a.goal) {
				printSolution(a);

				return;
			}  
			//If condition checks if the element in the East can be visited 
			//or otherwise if the goal point is reached then print the solution.
			if (a.e && !visitedList.contains(points[a.current.x][a.current.y + 1])
					&& !queue.contains(points[a.current.x][a.current.y + 1])) {
				points[a.current.x][a.current.y + 1].parent = new Coordinates(a.current.x, a.current.y);
				if (points[a.current.x][a.current.y + 1].goal) {
					printSolution(points[a.current.x][a.current.y + 1]);
					return;
				}
				queue.add(points[a.current.x][a.current.y + 1]);
			}
			if (a.s && !visitedList.contains(points[a.current.x + 1][a.current.y])
					&& !queue.contains(points[a.current.x + 1][a.current.y])) {
				points[a.current.x + 1][a.current.y].parent = new Coordinates(a.current.x, a.current.y);
				if (points[a.current.x + 1][a.current.y].goal) {
					printSolution(points[a.current.x + 1][a.current.y]);
					return;
				}
				queue.add(points[a.current.x + 1][a.current.y]);
			}
			if (a.w && !visitedList.contains(points[a.current.x][a.current.y - 1])
					&& !queue.contains(points[a.current.x][a.current.y - 1])) {
				points[a.current.x][a.current.y - 1].parent = new Coordinates(a.current.x, a.current.y);
				if (points[a.current.x][a.current.y - 1].goal) {
					printSolution(points[a.current.x][a.current.y - 1]);
					return;
				}
				queue.add(points[a.current.x][a.current.y - 1]);
			}
			if (a.n && !visitedList.contains(points[a.current.x - 1][a.current.y])
					&& !queue.contains(points[a.current.x - 1][a.current.y])) {
				points[a.current.x - 1][a.current.y].parent = new Coordinates(a.current.x, a.current.y);
				if (points[a.current.x - 1][a.current.y].goal) {
					printSolution(points[a.current.x - 1][a.current.y]);
					return;
				}
				queue.add(points[a.current.x - 1][a.current.y]);
			}
		}
	}

}