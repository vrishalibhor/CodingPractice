package stacksAndQueues;

import java.util.Stack;

public class QueueUsingStacks {
	
	Stack<Integer> mainStack;
	Stack<Integer> tempStack;
	
	QueueUsingStacks()
	{
		mainStack=new Stack<Integer>();
		tempStack=new Stack<Integer>();
	}
	
	public void enqueue(int item)
	{
		mainStack.push(item);
	}

	public int dequeue() 
	{
		if(tempStack.isEmpty())
		{
			while(!mainStack.isEmpty())
			{
				tempStack.push(mainStack.pop());
			}
		}
		int item=tempStack.pop();
		return item;
	}
	
	public static void main(String args[])
	{
		QueueUsingStacks q=new QueueUsingStacks();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
		q.enqueue(6);
		q.enqueue(7);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
