package treesAndGraphs;

/*Given a 2d grid map of '1's (land) and '0's (water), 
 * count the number of islands. An island is surrounded by water 
 * and is formed by connecting adjacent lands horizontally or 
 * vertically. You may assume all four edges of the grid are all 
 * surrounded by water.
 */
public class NumberOfIslands {

	public static void main(String args[])
	{
		char grid[][]= {	{'1','1','1','1','0'},
							{'1','1','0','1','0'},
							{'1','1','0','0','0'},
							{'0','0','0','1','0'}};
		
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		int count=0;
		if(grid==null || grid.length==0) return 0;
		boolean visited[][]=new boolean[grid.length][grid[0].length];

		for(int row=0;row<grid.length;row++)
		{
			for(int column=0;column<grid[row].length;column++)
			{
				if(grid[row][column]=='1' && !visited[row][column])
				{
					DFS(grid,row,column,visited);
					count++;
				}
			}
		}
		return count;
	}

	public static void DFS(char[][]grid, int row, int column, boolean visited[][])
	{
		if(row<0 || column <0 || row>=grid.length || column>=grid[row].length || grid[row][column]!='1' || visited[row][column])
			return;

		visited[row][column]=true;

		DFS(grid,row-1,column,visited);
		DFS(grid,row+1,column,visited);
		DFS(grid,row,column-1,visited);
		DFS(grid,row,column+1,visited);
	}

}
