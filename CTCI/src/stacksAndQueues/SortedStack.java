package stacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class SortedStack 
{
	public static Stack sortStack(Stack<Integer> mainStack)
	{
		Stack<Integer> sorted=new Stack<Integer>();
		while(!mainStack.isEmpty())
		{
			int current=mainStack.pop();
			while(!sorted.isEmpty() && current>sorted.peek())
			{
				mainStack.push(sorted.pop());
			}
			sorted.push(current);
		}
		
		return sorted;
	}
	
	public static void main(String args[])
	{
		Stack s=new Stack();
		s.push(6);
		s.push(5);
		s.push(2);
		s.push(1);
		s.push(3);
		s.push(4);
		Stack sorted=sortStack(s);
		
		System.out.println(Arrays.toString(s.toArray()));
	}

}
