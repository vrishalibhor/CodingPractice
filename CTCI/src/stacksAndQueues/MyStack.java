package stacksAndQueues;

public class MyStack {
	
	int arr[];
	int top;
	
	MyStack(int arr[])
	{
		this.arr=arr;
		this.top=-1;
	}
	
	public void push(int item)
	{
		if(top<arr.length)
		{
			arr[++top]=item;
		}
		else
		{
			throw(new StackOverflowError("Overflow"));
		}
	}
	
	public int pop()
	{
		if(top>=0)
		{
			int item=arr[top];
			arr[top]=0;
			top--;
			return item;
		}
		else
		{
			throw(new StackOverflowError("Underflow"));
		}
	}

	public boolean isFull()
	{
		if(top==arr.length-1)
			return true;
		else
			return false;
	}

	public boolean isNotFull()
	{
		if(top==arr.length-1)
			return false;
		else
			return true;
	}
	
	public boolean isEmpty()
	{
		if(top==-1)
			return true;
		else
			return false;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

}
