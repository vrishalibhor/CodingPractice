package recursionAndDP;

public class MultiplyNumbers {

	public static int multiply(int num1, int num2)
	{
		int result=0;
		while(num2!=0)
		{
			if((num2&1)!=0)
			{
				result+=num1;
			}
			num2=num2>>1;
			num1=num1<<1;
		}
		return result;
	}
	
	public static int multiplyBetter(int num1, int num2)
	{
		int smaller=0, bigger=0;
		if(num1>=num2) 
		{
			smaller=num2;
			bigger=num1;
		}
		else
		{
			smaller=num1;
			bigger=num2;
		}
		
		if(smaller==0)
			return 0;
		if(smaller==1)
			return bigger;
		
		int halfproduct = multiplyBetter(smaller/2,bigger);
		if(smaller%2==0)
			return halfproduct+halfproduct;
		else
			return halfproduct+halfproduct+bigger;
	}
	
	public static void main(String[] args) {
		System.out.println(multiply(5, 8));
		System.out.println(multiplyBetter(4, 8));
	}

}
