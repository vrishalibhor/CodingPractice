package treesAndGraphs;

public class FirstCommonAncestor {

	public static int depth(BSTNode n)
	{
		int depth=0;
		while(n!=null)
		{
			n=n.parent;
			depth++;
		}
		return depth;
	}
	
	public static BSTNode goUpBy(int depth, BSTNode n)
	{
		while(depth!=0)
		{
			n=n.parent;
			depth--;
		}
		
		return n;
	}
	
	public static BSTNode getCommonAncestor(BSTNode one, BSTNode two)
	{
		int depth=depth(one)-depth(two); //Get the difference in depth
		BSTNode deeper=null;
		BSTNode shallower=null;
		
		if(depth>0)
		{
			deeper=one;
			shallower=two;
		}
		else
		{
			deeper=two;
			shallower=one;
		}
		deeper=goUpBy(Math.abs(depth), deeper); //Match up to same levels so that we can go upwards one by one
		
		while(deeper!=shallower && deeper!=null && shallower!=null)
		{
			deeper=deeper.parent;
			shallower=shallower.parent;
		}
		
		if(deeper==null || shallower==null)
			return null;
		else
			return deeper;
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
		
		five.parent=nine;
		four.parent=five;
		eight.parent=five;
		thirteen.parent=nine;
		eleven.parent=thirteen;
		seventeen.parent=thirteen;
		two.parent=four;
		
		BTreePrinter.printNode(nine);
		
		BSTNode ans=getCommonAncestor(two, seventeen);
		
		if(ans!=null)
			System.out.println(ans.data);
		else
			System.out.println("Null");
	}

}
