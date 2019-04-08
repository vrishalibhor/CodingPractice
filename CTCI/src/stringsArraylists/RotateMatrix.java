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
//		rotate90(matrix);
//		display(matrix);

//10	11	12	1	
//9	16	13	2	
//8	15	14	3	
//7	6	5	4	

		rotate90Better(matrix);
		display(matrix);
	}
	
	public static void rotate90Better(int matrix[][])
	{
		int size=matrix.length-1;
		for(int level=0;level<(matrix.length+1)/2;level++)
		{
			for(int i=level;i<size-level;i++)
			{
				int temp=matrix[level][i]; //Save top
				matrix[level][i]=matrix[size-i][level]; //Left to top
				matrix[size-i][level]=matrix[size-level][size-i]; //Bottom to left
				matrix[size-level][size-i]=matrix[i][size-level]; //Right to bottom
				matrix[i][size-level]=temp; //Saved top to right
			}
		}
	}
	
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
			
			//System.out.println("Layer "+layer);
			//display(matrix);
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
