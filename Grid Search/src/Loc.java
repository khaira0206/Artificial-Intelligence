
public class Loc {

	Coordinates parent;
	final Coordinates current;
	boolean goal, e, w, s, n;

	double cost, hCost; // for uniform cost

	public Loc(String str, int x, int y) {
		// Checks the incoming string of the form 1010(NESW) and return true/false based on the 0/1 
		// where 0 means true(that the node in that direction can be explored)
		this.n = (str.charAt(0) == '0') ? true : false;
		this.e = (str.charAt(1) == '0') ? true : false;
		this.s = (str.charAt(2) == '0') ? true : false;
		this.w = (str.charAt(3) == '0') ? true : false;
		this.current = new Coordinates(x, y);
		cost = 0;
		hCost = Math.sqrt((Math.pow((10 - x), 2) + Math.pow((12 - y), 2)));
	}
}