package recursionAndDP;

import java.util.Stack;

class Tower
{
	Stack<Integer> stack;
	String name;
	
	Tower(String name)
	{
		stack=new Stack<Integer>();
		this.name=name;
	}
	
	void add(int disk)
	{
		if(!stack.isEmpty() && stack.peek()<disk)
			System.out.println("Error placing disk "+disk+" on top of "+stack.peek());
		else
			 stack.add(disk);
	}
	
	void moveTop(Tower destination)
	{
		if(this.stack.isEmpty()==false)
		{
			int topDisk=stack.pop();
			destination.add(topDisk);
		}
	}
	
	public void print() {
		System.out.println("Contents of Tower " + name + ": " + stack.toString());
	}
	
	void moveDisk(int numDisks, Tower destination, Tower buffer)
	{
		if(numDisks<=0)
			return;
		this.moveDisk(numDisks-1, buffer, destination);
		System.out.println("Move " + stack.peek() + " from " + this.name + " to " + destination.name);
		this.moveTop(destination);
		buffer.moveDisk(numDisks-1, destination, this);
	}
}

public class TowersOfHanoi {

	public static void main(String[] args) {
		int num=3;
		Tower one=new Tower("one");
		Tower two=new Tower("two");
		Tower three=new Tower("three");
		
		for(int i=num;i>0;i--)
		{
			one.add(i);
		}
		
		one.print();
		two.print();
		three.print();
		
		one.moveDisk(num, three, two);
		
		one.print();
		two.print();
		three.print();
	}

}
