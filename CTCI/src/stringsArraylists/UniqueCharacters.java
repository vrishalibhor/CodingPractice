package stringsArraylists;

public class UniqueCharacters
{
	public static void main(String args[])
	{
		System.out.println(isUnique("abcde"));
		System.out.println(isUnique("abcdd"));
		
		System.out.println(isUniqueOther("abcde"));
		System.out.println(isUniqueOther("abcdd"));
	}
	
	//The complexity of this method is n*n where n is the length of the string 
	public static boolean isUnique(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			char character=str.charAt(i);
			String subStr=str.substring(i+1, str.length());
			if(subStr.indexOf(character)>-1)
			{
				//break;
				return false;
			}
		}
		return true;
	}
	//Assuming string contains only ascii character set
	//The time complexity for this method is O(n) where n is the length of the string
	//The space complexity is O(1) since we've an array of size 128 always
	public static boolean isUniqueOther (String str)
	{
		boolean arr[]=new boolean[128];
		
		for(int i=0;i<str.length();i++)
		{
			char character=str.charAt(i);
			if(arr[(int)character])
			{
				return false;
			}
			else
			{
				arr[(int)character]=true;
			}
		}
		
		return true;
	}
}
