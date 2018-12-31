package stringsArraylists;

import java.util.Arrays;

public class URLify 
{
	public static void main(String args[])
	{
		System.out.println(urlify("Mr John Smith"));
		String s=urlifyBetter("Mr John Smith    ",13);
		System.out.println(s);
	}
	
	public static String urlifyBetter(String str, int trueSize)
	{
		char arr[]=str.toCharArray();
		int slowPtr=trueSize-1;
		int fastPtr=arr.length-1;
		while(slowPtr>-1)
		{
			if(arr[slowPtr]!=' ')
			{
				arr[fastPtr]=arr[slowPtr];
				fastPtr--;
				slowPtr--;
			}
			else
			{
				arr[fastPtr]='0';
				arr[fastPtr-1]='2';
				arr[fastPtr-2]='%';
				fastPtr=fastPtr-3;
				slowPtr--;
			}
		}
		return Arrays.toString(arr);
	}
	
	public static String urlify(String str)
	{
		StringBuilder url=new StringBuilder();
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
			{
				url.append("%20");
			}
			else
			{
				url.append(String.valueOf(str.charAt(i)));
			}
		}
		return url.toString();
	}
}
