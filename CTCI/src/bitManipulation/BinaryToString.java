package bitManipulation;

public class BinaryToString {
	public static void main(String args[])
	{
		double num=0.125;
		double num2=0.72;
		//print(0.125);
		print(0.0625);
	}
	public static void print(double num)
	{
		
		if(num<0 || num > 1)
			System.out.println("ERROR");
		
		StringBuilder s=new StringBuilder();
		
		while(num>0)
		{
			if(num*2>=1)
			{
				s.append("1");
				num=num*2-1;
			}
			else
			{
				s.append("0");
				num=num*2;
			}
		}
		if(s.length()>32)
			System.out.println("ERROR");
		else
			System.out.println(s);
	}
}
