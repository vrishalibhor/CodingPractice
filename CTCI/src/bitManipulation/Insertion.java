package bitManipulation;

public class Insertion {
	
	public static void main(String args[])
	{
		int a = 1024;
		String strA=toFullBinaryString(a);
		System.out.println(toFullBinaryString(a));
		int b = 19;
		//String strB=toFullBinaryString(b);
		//System.out.println(toFullBinaryString(b));		
		int c = update(a, b, 25, 29);
		System.out.println(toFullBinaryString(c));
		//update(m,n,2,6);
		
		
	}
	public static String toFullBinaryString(int a) {
		String s = "";
		for (int i = 0; i < 32; i++) {
			Integer lsb = new Integer(a & 1);
			s = lsb.toString() + s;
			a = a >> 1;
		}
		return s;
	}
	public static int update(int m, int n, int i, int j)
	{
		int allOnes=~0;
		//System.out.println(toFullBinaryString(allOnes));
		
		int left=allOnes<<(32-i);
		//System.out.println(toFullBinaryString(left));
		
		int right=(1<<(32-j-1))-1;
		//System.out.println(toFullBinaryString(right));
		
		int mask=right|left;
		System.out.println(toFullBinaryString(mask));
		
		int cleared=m&mask;
		System.out.println(toFullBinaryString(cleared));
		
		int nShifted=n<<(31-j);
		System.out.println(toFullBinaryString(nShifted));
		int sol=cleared|nShifted;
		
		return sol;
	}
	
	public static int updateBit(int num, int position, int val)
	{
		if(val==1)
		{
			int mask= 1<<position;
			System.out.println(toFullBinaryString(mask));	
			return num|mask;
		}
		else
		{
			int mask= ~(1<<position);
			System.out.println(toFullBinaryString(mask));	
			return num&mask;
		}
	}
}

