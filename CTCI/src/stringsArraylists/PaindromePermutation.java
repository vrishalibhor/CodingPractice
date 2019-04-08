package stringsArraylists;

public class PaindromePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindromePermutation("Taco cat"));
	}
	
	public static boolean isPalindromePermutation(String s)
	{
		int map[]=new int[26];
		boolean oddFound=false;
		s=s.toLowerCase();
		
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch!=' ')
				map[(int)ch-97]++;
		}
		
		for(int i=0;i<26;i++)
		{
			if(map[i]%2!=0)
			{
				if(oddFound)
					return false;
				else
					oddFound=true;
			}
		}
		return true;
	}

}
