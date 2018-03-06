
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Greedy extends Search {

	public Greedy(Coordinates starPoint) {
		this.starPoint = starPoint;
		createMaze();
	}

	public void greedy() {
		List<Loc> queue = new ArrayList<Loc>();
		queue.add(points[starPoint.x][starPoint.y]);

		while (!queue.isEmpty()) {
			//compares the two comparable objects
			Collections.sort(queue, new Comparator<Loc>() {

				public int compare(Loc p1, Loc p2) {
					return p1.hCost > p2.hCost ? 1 : -1;
				}
			});
			Loc a = queue.remove(0);

			if (a.goal) {
				printSolution(a);
				return;
			}

			visitedList.add(a);
			if (a.e && !visitedList.contains(points[a.current.x][a.current.y + 1])
					&& !queue.contains(points[a.current.x][a.current.y + 1])) {
				points[a.current.x][a.current.y + 1].parent = new Coordinates(a.current.x, a.current.y);
				queue.add(points[a.current.x][a.current.y + 1]);
			}
			if (a.s && !visitedList.contains(points[a.current.x + 1][a.current.y])
					&& !queue.contains(points[a.current.x + 1][a.current.y])) {
				points[a.current.x + 1][a.current.y].parent = new Coordinates(a.current.x, a.current.y);
				queue.add(points[a.current.x + 1][a.current.y]);
			}
			if (a.w && !visitedList.contains(points[a.current.x][a.current.y - 1])
					&& !queue.contains(points[a.current.x][a.current.y - 1])) {
				points[a.current.x][a.current.y - 1].parent = new Coordinates(a.current.x, a.current.y);
				queue.add(points[a.current.x][a.current.y - 1]);
			}
			if (a.n && !visitedList.contains(points[a.current.x - 1][a.current.y])
					&& !queue.contains(points[a.current.x - 1][a.current.y])) {
				points[a.current.x - 1][a.current.y].parent = new Coordinates(a.current.x, a.current.y);
				queue.add(points[a.current.x - 1][a.current.y]);
			}
		}
	}

}