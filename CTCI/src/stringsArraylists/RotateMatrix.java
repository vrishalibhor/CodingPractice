package stringsArraylists;

public class RotateMatrix
{
	public static void main(String args[])
	{
		int matrix[][]= {	{1,2,3,4},
							{12,13,14,5},
							{11,16,15,6},
							{10,9,8,7}};
		
		display(matrix);
		rotate90(matrix);
		display(matrix);
	}
	
	/*public static boolean rotate90Better(int matrix[][])
	{
		if(matrix.length!=matrix[0].length)
			return false;
		
		int size=matrix.length;
		
		for(int layer=0;layer<size/2;layer++)
		{
			int first=layer;
			int last=size-1-layer;
			
			for(int i=first;i<last;i++)
			{
				int temp=matrix[first][i];
				
				matrix[first][i]=matrix[last][layer];
			}
		}
	}*/
	
	public static void rotate90(int matrix[][])
	{
		int m=matrix.length;
		
		for(int layer=0;layer<m/2;layer++)
		{
			//Save the top row
			int temp[]=new int[matrix[layer].length];
			
			for(int j=layer;j<m;j++)
			{
				temp[j]=matrix[layer][j];
			}
			
			//Left to top
			for(int j=m-1-layer;j>=layer;j--)
			{
				matrix[layer][j]=matrix[m-1-j][layer];
			}
			
			//Bottom to left
			for(int j=layer;j<=m-1-layer;j++)
			{
				matrix[j][layer]=matrix[m-1-layer][j];
			}
			
			//Right to bottom
			for(int j=layer;j<=m-1-layer;j++)
			{
				matrix[m-1-layer][j]=matrix[m-1-j][m-1-layer];
			}
			
			//Right to temp
			for(int j=layer;j<temp.length-layer;j++)
			{
				matrix[j][m-1-layer]=temp[j];
			}
			
			System.out.println("Layer "+layer);
			display(matrix);
		}
	}
	public static void display(int arr[][])
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
		System.out.println();
	}
}
