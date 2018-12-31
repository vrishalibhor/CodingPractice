package sortingAndSearching;

public class SparseSearch {

	public static void main(String args[])
	{
		String arr[]= {"at","","","","ball","","","car","","","dad","",""};
		System.out.println(modifiedBinary(arr,0,12,"dad"));
	}
	
	public static int getMid(String arr[],int low,int high)
	{
		int mid=(low+high)/2;
		
		if(arr[mid]=="")
		{
			int midRight=mid+1;
			int midLeft=mid-1;
			
			while(true)
			{
				if(midLeft>=0 && arr[midLeft].length()!=0)
					return midLeft;
				if(midRight<arr.length && arr[midRight].length()!=0)
					return midRight;
			}
			
		}
		else
			return mid;
	}
	
	public static int modifiedBinary(String arr[],int low,int high,String element)
	{
		int mid=getMid(arr,low,high);
		
		while(low<high)
		{
			if(element.equalsIgnoreCase(arr[mid]))
			{
				return mid;
			}
			else if(element.compareTo(arr[mid])<0)
			{
				return modifiedBinary(arr,low,mid,element);
			}
			else
			{
				return modifiedBinary(arr,mid+1,high,element);
			}
		}
		return -1;		
	}
}
