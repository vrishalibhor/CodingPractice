package stringsArraylists;

import java.util.Arrays;

public class StringPermutation 
{
	public static void main(String args[])
	{
		String str1="god";
		String str2="dod";
		String str3="dog";
		String str4="godd";

	/*	System.out.println(isPermutation(str1, str2));
		System.out.println(isPermutation(str1, str3));
		System.out.println(isPermutation(str3, str2));
		System.out.println(isPermutation(str1, str4));
		
		System.out.println(isPermBetter(str1, str2));
		System.out.println(isPermBetter(str1, str3));
		System.out.println(isPermBetter(str3, str2));
		System.out.println(isPermBetter(str1, str4));*/
		//System.out.println(power(5,3));
	}
	//Complexity: a log a+ b log b + (a) 
	public static boolean isPermutation(String a, String b)
	{
		boolean isPermutation=false;
		if(a.length()!=b.length())
			isPermutation=false;
		else
		{
			char arrA[]=a.toCharArray();
			char arrB[]=b.toCharArray();
			Arrays.sort(arrA); //Complexity n log n
			Arrays.sort(arrB); //Complexity n log n
			if(Arrays.equals(arrA, arrB)) // Complexity n
				isPermutation=true;
			else
				isPermutation=false;
		}
		return isPermutation;
	}
	
	//Complexity = a*b
	public static boolean isPermBetter(String a, String b)
	{
		boolean isPermutation=true;
		if(a.length()!=b.length())
			isPermutation=false;
		else
		{
			int letters[]=new int[128];
			for(int i=0;i<a.length();i++)
			{
				int c=a.charAt(i);
				letters[(int)c]++;
			}
			for(int i=0;i<b.length();i++)
			{
				int c=b.charAt(i);
				letters[(int)c]--;
				if(letters[(int)c] < 0)
					isPermutation=false;
			}
		}
		return isPermutation;
	}
	public static int power(int x, int n)
	{
		int pow=1;
		if(n>0)
		{
			
			System.out.println("n "+n);
			return pow=x*power(x,n-1);
			//n--;
		}
		else
			return pow;
		
	}
}
