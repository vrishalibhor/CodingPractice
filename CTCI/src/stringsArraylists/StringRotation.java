package stringsArraylists;

public class StringRotation {

	public static void main(String[] args) 
	{
		String s1="waterbottle";
		String s2="erbottlewati";
		
		System.out.println(isRotation(s1, s2));
	}
	public static boolean isRotation(String s1, String s2)
	{
		if(s1.length()!=s2.length())
			return false;
		String s=s1+s1;
		if(isSubstring(s, s2))
			return true;
		else
			return false;
	}
	public static boolean isSubstring(String s1, String s2)
	{
		if(s1.contains(s2))
			return true;
		else
			return false;
	}
}
