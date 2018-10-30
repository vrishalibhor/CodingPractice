package stacksAndQueues;

import java.util.Stack;

public class StackWithMin extends Stack{

	Stack<Integer> minStack;
	
	StackWithMin()
	{
		this.minStack=new Stack();
	}
	
	public void push(int item)
	{
		if(minStack.isEmpty() || item<=minStack.peek())
			minStack.push(item);
		super.push(item);
	}
	
	public Object pop()
	{
		if(this.peek()==minStack.peek())
		{
			minStack.pop();
		}
		return super.pop();
	}
	
	public Object min()
	{
		return minStack.peek();	
	}

}

