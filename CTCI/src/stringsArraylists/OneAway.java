package stringsArraylists;

public class OneAway {

	public static void main(String[] args) 
	{
		System.out.println(oneAwayBetter("adb","Adb"));
		System.out.println(oneAwayBetter("pales","pale"));
		System.out.println(oneAwayBetter("pale","bale"));
		System.out.println(oneAwayBetter("pale","ball"));
	}
	
	public static boolean oneAwayBetter(String s1, String s2)
	{
		int l1=s1.length();
		int l2=s2.length();
				
		if(Math.abs(l1-l2)>1)
			return false;
		
		int i=0,j=0;
		boolean diffFound=false;
		
		while(i<l1 && j<l2)
		{
			if(s1.charAt(i)!=s2.charAt(j))
			{
				if(!diffFound)
				{
					if(l1==l2) //replace case
					{
						i++; j++;
					}
					else if(l1<l2)
					{
						j++;
					}
					else
					{
						i++;
					}
					diffFound=true;
				}
				else
					return false;
			}
			else
			{
				i++;
				j++;
			}
		}
		return true;
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
