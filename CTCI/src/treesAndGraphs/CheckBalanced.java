package treesAndGraphs;

public class CheckBalanced {
	
	public static boolean checkBalanced(BSTNode root)
	{
		if(root==null)	return true;
		else
		{
			int height=getHeight(root.left)-getHeight(root.right);
			if(height>1)
				return false;
			else
				return checkBalanced(root.left) && checkBalanced(root.right);
		}
	}
	
	public static int getHeight(BSTNode root)
	{
		if(root==null)
			return -1;
		
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
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
		//two.left=one;
		BTreePrinter.printNode(nine);
		System.out.println(checkBalanced(nine));
	}

}
