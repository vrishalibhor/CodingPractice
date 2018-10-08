package stringsArraylists;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CompressString 
{
	public static void main(String args[])
	{
		System.out.println(getCompressedString("abcde"));
		
	}
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
		Iterator itr=map.keySet().iterator();
		StringBuilder s=new StringBuilder();
		while(itr.hasNext())
		{
			String key=(String)itr.next();
			int value=map.get(key);
			s.append(key).append(String.valueOf(value));
		}
		if(str.length()<s.length())
			return str;
		else
			return s.toString();
	}

}
