package stringsArraylists;

public class ZeroRowColumn {

	public static void main(String[] args) {

		int arr[][]= 	{{1,2,3,4,5},
						{3,0,4,5,8},
						{1,1,0,9,6}};
		display(arr);
		zeroRowColumn(arr);
		System.out.println();
		display(arr);
	}
	
	public static void zeroRowColumn(int arr[][])
	{
		boolean rows[]=new boolean[arr.length];
		boolean columns[]=new boolean[arr[0].length];
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				if(arr[i][j]==0)
				{
					rows[i]=true;
					columns[j]=true;
				}
			}
		}
		
		for(int i=0;i<arr.length;i++)
		{
			if(rows[i])
			{
				for(int j=0;j<arr[i].length;j++)
				{
					arr[i][j]=0;
				}
			}
		}
		
		for(int i=0;i<arr[0].length;i++)
		{
			if(columns[i])
			{
				for(int j=0;j<arr.length;j++)
				{
					arr[j][i]=0;
				}
			}
		}
	}
	public static void display(int arr[][])
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
