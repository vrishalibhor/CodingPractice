package sortingAndSearching;

public class SortedMerge {

	public static void main(String[] args) {
		int A[]= {1,3,8,9,15,19,20,0,0,0};
		int B[]= {5,10,17};

		merge(A,B,7,3);
		display(A);

	}
	//Utility method to display the elements of an array
	public static void display(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	public static void merge(int A[],int B[], int numA, int numB)
	{
		int index=A.length-1;

		int lastA=numA-1;
		int lastB=numB-1;

		while(lastB>=0)
		{
			if(lastA>=0 && A[lastA]>B[lastB])
			{
				A[index]=A[lastA];
				lastA--;
			}
			else
			{
				A[index]=B[lastB];
				lastB--;
			}
			index--;
		}
	}
}
