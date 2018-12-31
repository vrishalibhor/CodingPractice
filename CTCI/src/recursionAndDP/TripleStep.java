package recursionAndDP;

public class TripleStep {

	public static void main(String[] args) {

		System.out.println(countSteps(4));
	}
	public static int countSteps(int n)
	{
		int memo[]=new int[n+1];
		
		if(n<0) return 0;
		else if(n==0||n==1) return 1;
		else 
		{
			memo[0]=1;
			memo[1]=1;
			memo[2]=2;
			
			for(int i=3;i<=n;i++)
			{
				memo[i]=memo[i-1]+memo[i-2]+memo[i-3];
			}
			
			return memo[n];
		}
	}
}
