package sortingAndSearching;

import java.util.Arrays;

public class PeaksAndValleys {

	public static void peaksAndValleys(int arr[])
	{
		Arrays.sort(arr);
		
		for(int i=1;i<arr.length;i=i+2)
		{
			swap(arr,i,i-1);
		}
	}
	public static void swap(int arr[], int a, int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	public static void main(String args[])
	{
		int arr[]= {1,7,9,0,4,8};
		peaksAndValleys(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
}
