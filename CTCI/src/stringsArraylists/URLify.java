package stringsArraylists;

public class URLify 
{
	public static void main(String args[])
	{
		System.out.println(urlify("Mr John Smith"));
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
