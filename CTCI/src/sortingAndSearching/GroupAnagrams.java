package sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[]= {"eat", "tea", "tan", "ate", "nat", "bat"};
		groupAnagram(arr);
		display(arr);
	}
	//Utility method to display the elements of an array
		public static void display(String arr[])
		{
			for(int i=0;i<arr.length;i++)
			{
				System.out.print(arr[i]+" ");
			}
		}
	public static void groupAnagram(String arr[])
	{
		HashMap<String, ArrayList<String>> map=new HashMap<String, ArrayList<String>>();
		
		for(int i=0;i<arr.length;i++)
		{
			String s=sort(arr[i]);
			if(map.containsKey(s))
				map.get(s).add(arr[i]);
			else
			{
				ArrayList<String> list=new ArrayList<String>();
				list.add(arr[i]);
				map.put(s, list);
			}
		}
		int k=0;
		for(String key: map.keySet())
		{
			ArrayList<String> list=map.get(key);
			for(int i=0;i<list.size();i++)
			{
				arr[k]=list.get(i);
				k++;
			}
		}
	}
	public static String sort(String s)
	{
		char arr[]=s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}
