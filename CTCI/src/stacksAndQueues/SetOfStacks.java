package stacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;

public class SetOfStacks {

	ArrayList<MyStack> listOfStack;
	int currentStack;
	SetOfStacks(int size, int number)
	{
		listOfStack=new ArrayList<MyStack>();
		for(int i=0;i<number;i++)
		{
			listOfStack.add(new MyStack(new int[size]));
		}
		currentStack=0;
	}
	public void push(int item)
	{
		boolean pushed=false;
		for(int i=currentStack;i<listOfStack.size();i++)
		{
			if(listOfStack.get(i).isNotFull())
			{
				listOfStack.get(i).push(item);
				currentStack=i;
				pushed=true;
				break;
			}
		}
		for(int i=0;i<listOfStack.size();i++)
		{
			System.out.println("Currently printing "+i+" "+Arrays.toString(listOfStack.get(i).getArr()));
		}
		if(!pushed)
		{
			throw(new StackOverflowError("Overflow"));
		}
	}
	public int pop()
	{
		try
		{
			int item= listOfStack.get(currentStack).pop();
			if(listOfStack.get(currentStack).isEmpty())
			{
				currentStack--;
			}
			
			for(int i=0;i<listOfStack.size();i++)
			{
				System.out.println("Currently printing "+i+" "+Arrays.toString(listOfStack.get(i).getArr()));
			}
			return item;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public static void main(String args[])
	{
		SetOfStacks set=new SetOfStacks(5,3);
		set.push(1);
		set.push(2);
		set.push(3);
		set.push(4);
		set.push(5);
		set.push(6);
		set.push(7);
		set.push(8);
		set.push(9);
		set.push(10);
		set.push(11);
		set.push(12);
		set.push(13);
		set.push(14);
		set.push(15);
		
		System.out.println();
		
		set.pop();
		set.pop();
		set.pop();
		set.pop();
		set.pop();
		set.pop();
		set.pop();
		set.pop();
		
		
	}
	
}
