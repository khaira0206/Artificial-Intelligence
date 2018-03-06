
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Search {

	protected Coordinates starPoint;
	protected Loc[][] points = new Loc[10][12];
	protected List<Loc> visitedList = new ArrayList<Loc>();

	int sol[][] = new int[10][12];

	public Search() {
		this.starPoint = new Coordinates(0, 0);
	}

	/*
	 * Creates maze from the input. sample row of maze is
	 * 1001-1100-1001-1010-1000-1010-1010-1100 order of each column is N-E-S-W 
	 *  1 means no move in that direction, 0 can move in that direction
	 */

	public void createMaze() {

		try {

			String lines = "1001-1000-1000-1111-1000-1000-1000-1000-1000-1000-1000-1100" + "\n"
					+ "0001-0010-0000-1000-0010-0010-0000-0010-0010-0000-0000-0100" + "\n"
					+ "0101-1111-0001-0100-1111-1111-0111-1111-1111-0001-0000-0100" + "\n"
					+ "0101-1111-0001-0000-1100-1111-1111-1000-1000-0000-0000-0100" + "\n"
					+ "0101-1111-0001-0000-0000-1000-1000-1111-0011-0010-0000-0100" + "\n"
					+ "0101-1111-0001-0000-0000-0000-0000-1000-1111-1111-0001-0100" + "\n"
					+ "0001-1000-0000-0000-0000-0000-0000-0000-1100-1111-0001-0100" + "\n"
					+ "0001-0000-0000-0000-0000-0000-0000-0000-0000-1000-0000-0100" + "\n"
					+ "0001-0000-0000-0000-0000-0000-0000-0000-0000-0000-0000-0100" + "\n"
					+ "0011-0010-0010-0010-0010-0010-0010-0010-0010-0010-0010-0110";
			BufferedReader br = new BufferedReader(new StringReader(lines));
			int row = 0;
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] columns = line.split("-");

				for (int i = 0; i < columns.length; i++) {
					points[row][i] = new Loc(columns[i], row, i);
				}
				row++;

			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		} 
		// Final goal points
		points[6][8].goal = true;
		points[3][9].goal = true;

	}

	public void printSolution(Loc a) {

		try {

			int totalCost = 1;
			totalCost = printSolutionPath(a, totalCost);
			System.out.print("Total Cost:" + totalCost + "\n");
			
			printVisited(visitedList);

			for (int i = 0; i <= 9; i++) {
				for (int j = 0; j <= 11; j++) {

					if ((i == 0 && j == 3) || (i == 2 && j == 4) || (i == 2 && j == 5) || (i == 3 && j == 5)
							|| (i == 3 && j == 6) || (i == 4 && j == 7) || (i == 2 && j == 7) || (i == 2 && j == 8)
							|| (i == 5 && j == 8) || (i == 5 && j == 9) || (i == 6 && j == 9) || (i == 2 && j == 1)
							|| (i == 3 && j == 1) || (i == 4 && j == 1) || (i == 5 && j == 1)) {
						System.out.print("W ");
					}
					

					else {
						System.out.print(sol[i][j] + " ");
					}

				}
				System.out.print("\n");

			}

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}
	
	private void printVisited(List<Loc> visitedlist)
	{
		int i=0;
		for(Loc loc: visitedlist)
		{
			i++;
		}
		System.out.println("Number of nodes visited: "+i +"\n");
	}
	

	public int printSolutionPath(Loc r, Integer totalCost) {
		int i,j;
	       
        i= r.current.x;
		 j= r.current.y;
      
		 if (       (i ==7  && j ==0 ) || (i ==7  && j ==1 ) || (i ==7  && j ==2 ) 
					|| (i ==7  && j ==3 ) || (i ==7  && j ==4 ) || (i ==5  && j ==2 ) 
					|| (i ==8  && j ==0 ) || (i ==8  && j ==1 ) || (i ==8  && j ==2 ) 
					|| (i ==8  && j ==3 ) || (i ==8  && j ==4 ) || (i ==9  && j ==2 ) 
					|| (i ==5  && j ==3 ) || (i ==6  && j ==2 ) || (i ==6  && j ==3 ) 
					|| (i ==9  && j ==3 ) || (i ==6  && j ==4 ) || (i ==9  && j ==4 ) 
					|| (i ==0  && j ==5 ) || (i ==0  && j ==6 ) || (i ==0  && j ==7 ) 
					|| (i ==0  && j ==8 ) || (i ==0  && j ==9 ) || (i ==0  && j ==10 ) 
					|| (i ==0  && j ==11 ) || (i ==1  && j ==5 ) || (i ==1  && j ==6 ) 
					|| (i ==1  && j ==7 ) || (i ==1  && j ==8 ) || (i ==1  && j ==9 ) 
					|| (i ==1  && j ==10 ) || (i ==1  && j ==11 )   ){
			 sol[r.current.x][r.current.y] = 2;
			}
			else
			{
				sol[r.current.x][r.current.y] = 1;
			}
		 
		 
		
		if (r.parent != null) {
			 i= r.parent.x;
			 j= r.parent.y;
			if (       (i ==7  && j ==0 ) || (i ==7  && j ==1 ) || (i ==7  && j ==2 ) 
					|| (i ==7  && j ==3 ) || (i ==7  && j ==4 ) || (i ==5  && j ==2 ) 
					|| (i ==8  && j ==0 ) || (i ==8  && j ==1 ) || (i ==8  && j ==2 ) 
					|| (i ==8  && j ==3 ) || (i ==8  && j ==4 ) || (i ==9  && j ==2 ) 
					|| (i ==5  && j ==3 ) || (i ==6  && j ==2 ) || (i ==6  && j ==3 ) 
					|| (i ==9  && j ==3 ) || (i ==6  && j ==4 ) || (i ==9  && j ==4 ) 
					|| (i ==0  && j ==5 ) || (i ==0  && j ==6 ) || (i ==0  && j ==7 ) 
					|| (i ==0  && j ==8 ) || (i ==0  && j ==9 ) || (i ==0  && j ==10 ) 
					|| (i ==0  && j ==11 ) || (i ==1  && j ==5 ) || (i ==1  && j ==6 ) 
					|| (i ==1  && j ==7 ) || (i ==1  && j ==8 ) || (i ==1  && j ==9 ) 
					|| (i ==1  && j ==10 ) || (i ==1  && j ==11 )   ){
			totalCost = printSolutionPath(points[r.parent.x][r.parent.y], totalCost+2);
			}
			else
			{
				totalCost = printSolutionPath(points[r.parent.x][r.parent.y], ++totalCost);
			}
		}
		return totalCost;
	}
}