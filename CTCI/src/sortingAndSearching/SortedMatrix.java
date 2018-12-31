package sortingAndSearching;

public class SortedMatrix {

	public static void main(String args[])
	{
		int arr[][]= {{0,1,2,3},{4,5,6,7},{8,9,10,11}}; 
		System.out.println(find(arr,12));
		display(find(arr,12));
	}
	
	public static int[] find(int arr[][],int element)
	{
		int i=0,j=0;
		int sol[]=new int[2];
		for(i=0;i<arr.length;i++)
		{
			j=i;
			if(arr[i][j]==element)
			{
				sol[0]=i;
				sol[1]=j;
				return sol; //diagonal element is the required one
			}
			else if(arr[i][j]>element)
			{
				break;
			}	
		}
		if((i==0 && j==0) || (i>=arr.length) || (j>=arr[i].length)) //Element not present
		{
			return null;
		}
		else
		{
			for(int m=i-1;m<=i;m++) //If (i,j):(2,2) start searching from (1,1) t0 (2,2)
			{
				for(int n=j-1;n<arr[i].length;n++)
				{
					if(arr[m][n]==element)
					{
						sol[0]=m;
						sol[1]=n;
						return sol;
					}
				}
			}
		}
		return null; //element not present
	}
	//Utility method to display the elements of an array
		public static void display(int arr[])
		{
			for(int i=0;i<arr.length;i++)
			{
				System.out.print(arr[i]+" ");
			}
		}
}

