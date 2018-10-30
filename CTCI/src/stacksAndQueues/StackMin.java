package stacksAndQueues;

import java.util.Arrays;

public class StackMin {

	public static void main(String[] args) {
		
		StackWithMin s=new StackWithMin();
		s.push(5);
		s.push(2);
		s.push(3);
		s.push(5);
		s.push(2);
		s.push(7);
		
		System.out.println(Arrays.toString(s.toArray()));
		System.out.println(Arrays.toString(s.minStack.toArray()));
		
		System.out.println("Minimum is "+s.min());
		s.pop();
		
		System.out.println("Minimum is "+s.min());
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		
		System.out.println("Minimum is "+s.min());
		
		System.out.println(Arrays.toString(s.toArray()));
		System.out.println(Arrays.toString(s.minStack.toArray()));
		
	}
	
}
