package stringsArraylists;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CompressString 
{
	public static void main(String args[])
	{
		System.out.println(getCompressedString("aabbccddeee"));
		
	}
	
	//Time Complexity: O(n) Space Complexity: O(k) where k is the number of distinct characters
	//This algo can be done in O(1) space by using a String builder and keeping count of characters using a variable
	public static String getCompressedString(String str)
	{
		Map<String,Integer> map=new HashMap<String,Integer>();
		for(int i=0;i<str.length();i++)
		{
			if(map.containsKey(String.valueOf(str.charAt(i))))
			{
				int newCount=map.get(String.valueOf(str.charAt(i)))+1;
				map.replace(String.valueOf(str.charAt(i)), newCount);
			}
			else
			{
				map.put(String.valueOf(str.charAt(i)), 1);
			}
		}
		//Check if the compression would result into a smaller string
		if(map.size()*2>=str.length())
			return str;
		
		Iterator itr=map.keySet().iterator();
		StringBuilder s=new StringBuilder();
		while(itr.hasNext())
		{
			String key=(String)itr.next();
			int value=map.get(key);
			s.append(key).append(String.valueOf(value));
		}
		return s.toString();
	}

}
