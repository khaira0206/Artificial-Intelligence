
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UniformCS extends Search {

	public UniformCS(Coordinates starPoint) {
		this.starPoint = starPoint;
		createMaze();
	}

	public void uniformCS() {
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
			if (a.goal) {
				printSolution(a);
				return;
			}
			double cost = 0;
			if (a.parent != null) {
				cost = points[a.parent.x][a.parent.y].cost + 1;
			}
			visitedList.add(a);
			if (a.e && !visitedList.contains(points[a.current.x][a.current.y + 1])
					&& !queue.contains(points[a.current.x][a.current.y + 1])) {
				points[a.current.x][a.current.y + 1].parent = new Coordinates(a.current.x, a.current.y);

				queue.add(points[a.current.x][a.current.y + 1]);
			} else if (a.e && queue.contains(points[a.current.x][a.current.y + 1])
					&& points[a.current.x][a.current.y + 1].cost > cost) {
				points[a.current.x][a.current.y + 1].cost = cost;
				points[a.current.x][a.current.y + 1].parent = new Coordinates(a.current.x, a.current.y);
			}
			if (a.s && !visitedList.contains(points[a.current.x + 1][a.current.y])
					&& !queue.contains(points[a.current.x + 1][a.current.y])) {
				points[a.current.x + 1][a.current.y].parent = new Coordinates(a.current.x, a.current.y);

				queue.add(points[a.current.x + 1][a.current.y]);
			} else if (a.s && queue.contains(points[a.current.x + 1][a.current.y])
					&& points[a.current.x + 1][a.current.y].cost > cost) {
				points[a.current.x + 1][a.current.y].cost = cost;
				points[a.current.x + 1][a.current.y].parent = new Coordinates(a.current.x, a.current.y);
			}
			if (a.w && !visitedList.contains(points[a.current.x][a.current.y - 1])
					&& !queue.contains(points[a.current.x][a.current.y - 1])) {
				points[a.current.x][a.current.y - 1].parent = new Coordinates(a.current.x, a.current.y);

				queue.add(points[a.current.x][a.current.y - 1]);
			} else if (a.w && queue.contains(points[a.current.x][a.current.y - 1])
					&& points[a.current.x][a.current.y - 1].cost > cost) {
				points[a.current.x][a.current.y - 1].cost = cost;
				points[a.current.x][a.current.y - 1].parent = new Coordinates(a.current.x, a.current.y);
			}
			if (a.n && !visitedList.contains(points[a.current.x - 1][a.current.y])
					&& !queue.contains(points[a.current.x - 1][a.current.y])) {
				points[a.current.x - 1][a.current.y].parent = new Coordinates(a.current.x, a.current.y);

				queue.add(points[a.current.x - 1][a.current.y]);
			} else if (a.n && queue.contains(points[a.current.x - 1][a.current.y])
					&& points[a.current.x - 1][a.current.y].cost > cost) {
				points[a.current.x - 1][a.current.y].cost = cost;
				points[a.current.x - 1][a.current.y].parent = new Coordinates(a.current.x, a.current.y);
			}

		}
	}

}