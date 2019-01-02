package treesAndGraphs;

public class MaxAreaOfIsland {

	public static int getMaxArea(int grid[][])
	{
		if(grid==null||grid.length==0||grid[0].length==0) return 0;

		int maxCount=0;

		for(int row=0;row<grid.length;row++)
		{
			for(int column=0;column<grid[row].length;column++)
			{
				if(grid[row][column]==1)
				{
					maxCount=Math.max(DFS(grid,row,column), maxCount);
				}
			}
		}
		return maxCount;
	}

	public static int DFS(int grid[][], int row, int column)
	{
		if(row<0 || column<0 || row>=grid.length || column>=grid[row].length || grid[row][column]==0)
			return 0;

		grid[row][column]=0;

		return DFS(grid,row-1,column)+DFS(grid,row+1,column)+DFS(grid,row,column-1)+DFS(grid,row,column+1)+1;
	}

	public static void main(String[] args) {
		int grid[][]= {		{0,0,1,0,0,0,0,1,0,0,0,0,0},
							{0,0,0,0,0,0,0,1,1,1,0,0,0},
							{0,1,1,0,1,0,0,0,0,0,0,0,0},
							{0,1,0,0,1,1,0,0,1,0,1,1,0},
							{0,1,0,0,1,1,0,0,1,1,1,0,0},
							{0,0,0,0,0,0,0,0,0,0,1,0,0},
							{0,0,0,0,0,0,0,1,1,1,0,0,0},
							{0,0,0,0,0,0,0,1,1,0,0,0,0}};

		System.out.println(getMaxArea(grid));
	}

}
