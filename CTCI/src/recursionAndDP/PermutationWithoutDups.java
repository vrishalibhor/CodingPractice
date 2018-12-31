package recursionAndDP;

import java.util.ArrayList;

public class PermutationWithoutDups {

	public static void main(String[] args) {

	}
	public static ArrayList<String> getPerms(String str)
	{
		ArrayList<String> solution=new ArrayList<String>();
		if(str.length()==0)
			return solution;
		
		for(int i=0;i<str.length();i++)
		{
			char first=str.charAt(i);
			
			String remaining=str.substring(1);
			
			ArrayList<String> intermediate=getPerms(remaining);
			
			for(int j=0;j<intermediate.size();j++)
			{
				
			}
		}
	}
	public static String insertCharAt(String s,int i, char c)
	{
		String start=s.substring(0, i);
		String end=s.substring(i+1);
		return start+c+end;
	}
}
