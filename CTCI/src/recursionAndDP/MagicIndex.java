package recursionAndDP;

public class MagicIndex {

	public static void main(String[] args) {

		int arr[]= {-5,-1,2,8,10,15,20};
		System.out.println(getMagicIndexDistinct(arr, 0, arr.length-1));

		int arr2[]= {-10,-5,2,2,2,3,4,7,9,12,13};
		System.out.println(getMagicIndexRepeat(arr2, 0, arr2.length-1));
	}
	public static int getMagicIndexDistinct(int arr[],int low, int high)
	{
		while(low<high)
		{
			int mid=(low+high)/2;

			if(arr[mid]==mid)
				return mid;

			if(arr[mid]>mid)
				return getMagicIndexDistinct(arr, low, mid);
			else
				return getMagicIndexDistinct(arr, mid+1, high);
		}
		return -1;
	}
	public static int getMagicIndexRepeat(int arr[],int low,int high)
	{
		while(low<high)
		{
			int mid=(low+high)/2;

			if(arr[mid]==mid)
				return mid;

			int leftIndex=Math.min(mid-1, arr[mid]);
			int left= getMagicIndexRepeat(arr, low, leftIndex);
			if(left>=0) return left;

			int max=Math.max(mid+1, arr[mid]);
			if(max<=high)
				return getMagicIndexRepeat(arr, max, high);
		}
		return -1;
	}
}
