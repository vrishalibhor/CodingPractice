package sortingAndSearching;

public class RotatedSearch {
	
	public static int searchInRotatedArrayBetter(int arr[], int item)
	{
		if(arr==null || arr.length==0) return -1;
		int low=0;
		int high=arr.length-1;
		
		while(low<=high)
		{
			int mid=low+(high-low)/2;
			
			if(item==arr[mid])
				return mid;
			
			if(arr[low]<=arr[mid]) //Left portion sorted
			{
				if(item<arr[low])
					low=mid+1;
				else if(item<arr[mid])
					high=mid-1;
				else
					low=mid+1;
			}
			else if(arr[mid]<=arr[high]) //Right portion sorted
			{
				if(item<arr[mid])
					high=mid-1;
				else if(item<arr[high])
					low=mid+1;
				else
					high=mid-1;
			}
		}
		return -1;
	}
	
	public static int searchInRotatedArray(int arr[], int low, int high, int item)
	{while(low<=high)
	{
		int mid=(low+high)/2;
		
		if(arr[mid]==item)
			return mid;
		
		if(arr[low]<arr[mid])
		{
			if(item>=arr[low] && item<arr[mid])
			{
				return searchInRotatedArray(arr,low,mid,item);
			}
			else
			{
				return searchInRotatedArray(arr,mid+1,high,item);
			}
		}
		else if(arr[low]>arr[mid])
		{
			if(item>arr[mid] && item<=arr[high])
			{
				return searchInRotatedArray(arr,mid+1,high,item);
			}
			else
			{
				return searchInRotatedArray(arr,low,mid,item);
			}
		}
		else if(arr[low]==arr[mid])
		{
			if(arr[mid]==arr[high])
			{
				int result=searchInRotatedArray(arr,mid+1,high,item);
				if(result==-1)
					return searchInRotatedArray(arr,low,mid-1,item);
				else
					return result;
			}
			else
			{
				return searchInRotatedArray(arr,mid+1,high,item);
			}
			
		}
	}
	return -1;
	}
	public static void main(String args[])
	{
		int arr[]= {4,5,6,7,0,1,2};
		System.out.println(searchInRotatedArray(arr, 0, arr.length-1, 4));
		System.out.println(searchInRotatedArrayBetter(arr, 4));
		int arr1[]= {2,2,2,2,0,1,1};
		System.out.println(searchInRotatedArray(arr1, 0, arr1.length-1, 0));
		System.out.println(searchInRotatedArrayBetter(arr, 0));
	}

}
