package sortingAndSearching;

class Listy
{
	int arr[];
	
	Listy(int arr[])
	{
		this.arr=arr;
	}
	
	int elementAt(int index)
	{
		if(index<arr.length)
			return arr[index];
		else
			return -1;
	}
}

public class GroupSortedSearch {

	public static void main(String args[])
	{
		int arr[]= {1,2,8,11,12,13,16,18,20,21};
		Listy list=new Listy(arr);
		int high=getSize(list);
		System.out.println(modifiedBinarySearch(list,13,0,9));
		display(list.arr);

	}
	//Utility method to display the elements of an array
	public static void display(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	public static int modifiedBinarySearch(Listy list, int element, int low, int high)
	{			
		while(low<high)
		{
			int mid=(low+high)/2;
			
			if(list.elementAt(mid)==element)
				return mid;
			
			if(list.elementAt(mid)<element && list.elementAt(mid)!=-1)
			{
				return modifiedBinarySearch(list,element,mid+1,high);
			}
			else
			{
				return modifiedBinarySearch(list,element,low,mid);
			}
		}
		return -1;
	}
	
	public static int getSize(Listy list)
	{
		int i=1;
		
		while(list.elementAt(i)!=-1)
		{
			i*=2;
		}
		return i;
	}
}
