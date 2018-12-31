package treesAndGraphs;

/*
 * You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a ROOM, that room should remain filled with INF.

Example
Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
 0  -1 INF INF
return the result:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

 */

public class WallsAndGates {
	
	public static void main(String args[])
	{
		int grid[][]= {	{2147483647,-1,0,2147483647},
				{2147483647,2147483647,2147483647,-1},
				{2147483647,-1,2147483647,-1},
				{0,-1,2147483647,2147483647}};

		display(grid);
		wallsAndGates(grid);
		display(grid);
	}

	public static void wallsAndGates(int[][] rooms) {
		if(rooms==null || rooms.length==0) return;

		for(int row=0;row<rooms.length;row++)
		{
			for(int column=0;column<rooms[row].length;column++)
			{
				if(rooms[row][column]==0)
				{
					DFS(rooms,row,column,0);
				}
			}
		}
	}

	public static void DFS(int[][]grid, int row, int column, int count)
	{
		if(row<0 || column <0 || row>=grid.length || column>=grid[row].length || grid[row][column]<count)
			return;

		grid[row][column]=count;

		DFS(grid,row-1,column,count+1);
		DFS(grid,row+1,column,count+1);
		DFS(grid,row,column-1,count+1);
		DFS(grid,row,column+1,count+1);
	}
	
	
	public static void display(int arr[][])
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				if(arr[i][j]==Integer.MAX_VALUE)
					System.out.print("INF\t");
				else
					System.out.print(arr[i][j]+"\t");
			}
				
			System.out.println();
		}
		System.out.println();
	}
}