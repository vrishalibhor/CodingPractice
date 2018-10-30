package stacksAndQueues;

class MyStack1 {
	
	int arr[];
	int start;
	int end;
	int top;
	
	MyStack1(int arr[], int start, int end)
	{
		this.arr=arr;
		this.start=start;
		this.end=end;
		this.top=this.start-1;
	}
	
	public void push(int item)
	{
		if(top<end)
		{
			arr[++top]=item;
		}
		else
		{
			System.out.println("Stack overflow");
		}
	}
	
	public int pop()
	{
		if(top>=start)
		{
			int item=arr[top];
			arr[top]=0;
			top--;
			return item;
		}
		else
		{
			System.out.println("Stack underflow");
			return -1;
		}
	}
}

public class ThreeInOne {

	public static void main(String[] args) {
		int arr[]=new int[12];
		
		int sizeOfEach=arr.length/3;
		
		int s1Start=0;
		int s2Start=s1Start+sizeOfEach;
		int s3Start=s2Start+sizeOfEach;
		
		MyStack1 s1=new MyStack1(arr,s1Start,s2Start-1);
		MyStack1 s2=new MyStack1(arr,s2Start,s3Start-1);
		MyStack1 s3=new MyStack1(arr,s3Start,arr.length-1);
		
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s2.push(5);
		s3.push(6);
		
		display(arr);
		
		//s1.pop();
		s2.pop();
		s2.pop();
		
		display(arr);
		
	}
	
	public static void display(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
}
