package recursionAndDP;

import java.util.ArrayList;

public class PermutationWithoutDups {

	public static void main(String[] args) {
		System.out.println(getPerms("ab"));
	}
	public static ArrayList<String> getPerms(String str)
	{
		ArrayList<String> solution=new ArrayList<String>();
		if(str.length()==0)
		{
			solution.add("");
			return solution;
		}

		char first=str.charAt(0);
		String remaining=str.substring(1);
		ArrayList<String> intermediate=getPerms(remaining);
		for(int j=0;j<intermediate.size();j++)
		{
			String word=intermediate.get(j);
			for(int k=0;k<=word.length();k++)
			{
				String s=insertCharAt(word, k, first);
				solution.add(s);
			}
		}
		return solution;
	}
	public static String insertCharAt(String s,int i, char c)
	{
		String start=s.substring(0, i);
		String end=s.substring(i);
		return start+c+end;
	}
}
