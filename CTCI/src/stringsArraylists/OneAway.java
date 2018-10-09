package stringsArraylists;

public class OneAway {

	public static void main(String[] args) 
	{
		/*System.out.println(oneAway("pale","ple"));
		System.out.println(oneAway("pales","pale"));
		System.out.println(oneAway("pale","bale"));*/
		System.out.println(oneAway("pale","ball"));
	}
	
	public static boolean oneAway(String s1, String s2)
	{
		int n=s1.length();
		int m=s2.length();
		if(n==m) //check for replace case
		{
			int diffCount=0;
			for(int i=0;i<m;i++)
			{
				if(s1.charAt(i)!=s2.charAt(i))
					diffCount++;
			}
			if(diffCount>1)
				return false;
			else
				return true;
		}
		else if(m<=(n+1) && m>=(n-1)) //insert or remove case
		{
			String primary, secondary;
			if(n>m)
			{
				primary=s1;
				secondary=s2;
			}
			else
			{
				primary=s2;
				secondary=s1;
			}
			
			for(int i=0;i<primary.length();i++)
			{
				StringBuilder part=new StringBuilder(primary);
				part.deleteCharAt(i);
				if(part.toString().equals(secondary))
				{
					return true;
				}
			}
			return false;
		}
		return false;
	}

}
