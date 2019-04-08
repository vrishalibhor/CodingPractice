package recursionAndDP;

import java.util.ArrayList;

public class EightQueens {

	public static void printBoard(ArrayList<Integer[]> results)
	{
		for(int i=0;i<results.size();i++)
		{
			Integer[] arr=results.get(i);
			for(int j=0;j<8;j++)
			{
				for(int k=0;k<8;k++)
				{
					if(k==arr[j])
					{
						System.out.print("Q|");
					}
					else
						System.out.print(" |");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void eightQueens(ArrayList<Integer[]> results)
	{
		Integer columns[]= new Integer[8];
		for(int i=0;i<columns.length;i++)
		{
			columns[i]=-1;
		}
		placeQueen(0, columns, results);
	}
	
	public static void placeQueen(int row, Integer columns[], ArrayList<Integer[]> results)
	{
		if(row==8)
		{
			results.add(columns.clone());
		}
		else
			for(int column=0; column<columns.length; column++)
			{
				if(valid(row, column, columns))
				{
					columns[row]=column;
					placeQueen(row+1, columns, results);
				}
			}
	}
	public static boolean valid(int row, int column, Integer columns[])
	{
		for(int r=0;r<row;r++)
		{
			int currColumn=columns[r];

			if(column==currColumn) return false;

			int rowDist=row-r;
			int colDist=Math.abs(column-currColumn);

			if(rowDist==colDist)
				return false;
		}
		return true;
	}
	
	
	
	public static void main(String args[])
	{
		ArrayList<Integer[]> results=new ArrayList<Integer[]>();
		eightQueens(results);
		printBoard(results);
	}
}

