package treesAndGraphs;
/*
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O''s into 'X''s in that surrounded region.
 */
public class SurroundedRegions {

	public static void surroundedRegions(char grid[][])
	{
		for(int row=0;row<grid.length;row++)
		{
			if(grid[row][0]=='O')
				DFS(grid,row,0);
			if(grid[row][grid[row].length-1]=='O')
				DFS(grid,row,grid[row].length-1);
		}
		for(int column=0;column<grid[0].length;column++)
		{
			if(grid[0][column]=='O')
				DFS(grid,0,column);
			if(grid[grid.length-1][column]=='O')
				DFS(grid,grid.length-1,column);
		}
		for(int row=0;row<grid.length;row++)
		{
			for(int column=0;column<grid[row].length;column++)
			{
				if(grid[row][column]=='O')
					grid[row][column]='X';
				else if(grid[row][column]=='#')
					grid[row][column]='O';
			}
		}
	}
	public static void DFS(char grid[][], int row, int column)
	{
		if(row<0 ||  column<0 || row>=grid.length || column>=grid[row].length || grid[row][column]!='O')
			return;

		grid[row][column]='#';

		DFS(grid,row-1,column);
		DFS(grid,row+1,column);
		DFS(grid,row,column-1);
		DFS(grid,row,column+1);

	}
	public static void main(String[] args) {
		char grid[][]= {	{'X','X','X','X','O'},
							{'X','X','O','X','O'},
							{'X','X','X','O','X'},
							{'O','O','O','X','O'}};
		display(grid);
		surroundedRegions(grid);
		display(grid);
	}

	public static void display(char arr[][])
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}

			System.out.println();
		}
		System.out.println();
	}

}
