package treesAndGraphs;

import java.util.ArrayList;

public class ValidateBST {

	static Integer lastElement=Integer.MIN_VALUE;
	
	public static boolean isValid(BSTNode root)
	{
		if(root==null)	return true;
		
		if(!isValid(root.left)) return false;
		
		if(root.data<=lastElement)	return false;
			
		lastElement=root.data;
		
		if(!isValid(root.right)) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		BSTNode two=new BSTNode(2);
		BSTNode five=new BSTNode(5);
		BSTNode thirteen=new BSTNode(13);
		BSTNode four=new BSTNode(4);
		BSTNode eight=new BSTNode(8);
		BSTNode nine=new BSTNode(9);
		BSTNode eleven=new BSTNode(11);
		BSTNode seventeen=new BSTNode(17);
		BSTNode one=new BSTNode(1);
		
		nine.left=five;
		nine.right=thirteen;
		five.left=four;
		five.right=eight;
		four.left=two;
		thirteen.left=eleven;
		thirteen.right=seventeen;
		BTreePrinter.printNode(nine);
		System.out.println(isValid(nine));
	}

}
