package treesAndGraphs;

import java.util.HashSet;

/*
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid 
 * are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only 
if one island can be translated (and not rotated or reflected) to equal the other.
 */

public class NumberOfDistinctIslands {

	public static void DFS(int grid[][], int row, int column, int baseX, int baseY, HashSet<String> set)
	{
		if(row<0 || column<0 || row>=grid.length || column>=grid[row].length || grid[row][column]==0)
			return;

		String s=String.valueOf(row-baseX)+"_"+String.valueOf(column-baseY);
		set.add(s);

		grid[row][column]=0; //Instead of having a visited array

		DFS(grid,row-1,column,baseX,baseY,set);
		DFS(grid,row+1,column,baseX,baseY,set);
		DFS(grid,row,column-1,baseX,baseY,set);
		DFS(grid,row,column+1,baseX,baseY,set);
	}
	public static int countDistinctIslands(int grid[][])
	{
		if(grid==null || grid.length==0 || grid[0].length==0) return 0;
		HashSet<String> result=new HashSet<String>();
		for(int row=0;row<grid.length;row++)
		{
			for(int column=0;column<grid[row].length;column++)
			{
				HashSet<String> set=new HashSet<String>();
				if(grid[row][column]==1)
				{
					DFS(grid,row,column,row,column,set);
					System.out.println(set.toString());
					result.add(set.toString());
				}
			}
		}
		return result.size();
	}
	public static void main(String[] args) {
		int grid[][]= {	{1,1,0,1,1},
						{1,0,0,0,0},
						{0,0,0,0,1},
						{1,1,0,1,1}};

		System.out.println(countDistinctIslands(grid));

	}

}
