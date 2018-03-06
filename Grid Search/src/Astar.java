
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Astar extends Search {

	public Astar(Coordinates startPoint) {
		this.starPoint = startPoint;
		createMaze();
	}

	public void astar() {
		List<Loc> queue = new ArrayList<Loc>();
		queue.add(points[starPoint.x][starPoint.y]);

		while (!queue.isEmpty()) {
			//compares the two comparable objects
			Collections.sort(queue, new Comparator<Loc>() {

				public int compare(Loc p1, Loc p2) {
					return p1.cost > p2.cost ? 1 : -1;
				}
			});
			Loc a = queue.remove(0);
			double cost = 0;
			if (a.parent != null) {
				cost = points[a.parent.x][a.parent.y].cost + 1 + a.hCost;
			}

			visitedList.add(a);
			if (a.goal) {
				printSolution(a);
				return;
			}

			if (a.e && !visitedList.contains(points[a.current.x][a.current.y + 1])
					&& !queue.contains(points[a.current.x][a.current.y + 1])) {
				points[a.current.x][a.current.y + 1].parent = new Coordinates(a.current.x, a.current.y);
				points[a.current.x][a.current.y + 1].cost = cost;
				queue.add(points[a.current.x][a.current.y + 1]);
			}
			if (a.s && !visitedList.contains(points[a.current.x + 1][a.current.y])
					&& !queue.contains(points[a.current.x + 1][a.current.y])) {
				points[a.current.x + 1][a.current.y].parent = new Coordinates(a.current.x, a.current.y);
				points[a.current.x + 1][a.current.y].cost = cost;
				queue.add(points[a.current.x + 1][a.current.y]);
			}
			if (a.w && !visitedList.contains(points[a.current.x][a.current.y - 1])
					&& !queue.contains(points[a.current.x][a.current.y - 1])) {
				points[a.current.x][a.current.y - 1].parent = new Coordinates(a.current.x, a.current.y);
				points[a.current.x][a.current.y - 1].cost = cost;
				queue.add(points[a.current.x][a.current.y - 1]);
			}
			if (a.n && !visitedList.contains(points[a.current.x - 1][a.current.y])
					&& !queue.contains(points[a.current.x - 1][a.current.y])) {
				points[a.current.x - 1][a.current.y].parent = new Coordinates(a.current.x, a.current.y);
				points[a.current.x - 1][a.current.y].cost = cost;
				queue.add(points[a.current.x - 1][a.current.y]);
			}
		}
	}

}