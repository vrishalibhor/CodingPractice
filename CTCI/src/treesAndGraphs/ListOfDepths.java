package treesAndGraphs;

import java.util.ArrayList;

public class ListOfDepths {

	public static void getListOfDepths(BSTNode node, ArrayList<ArrayList<BSTNode>> lists, int level)
	{
		ArrayList<BSTNode> current=null;
		if(lists.size()==level)
		{
			ArrayList<BSTNode> newLevel= new ArrayList<BSTNode>();
			lists.add(newLevel);
		}
		current=lists.get(level);
		
		current.add(node);
		if(node.left!=null)
			getListOfDepths(node.left, lists, level+1);
		if(node.right!=null)
			getListOfDepths(node.right, lists, level+1);
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
		
		nine.left=five;
		nine.right=thirteen;
		five.left=four;
		five.right=eight;
		four.left=two;
		thirteen.left=eleven;
		thirteen.right=seventeen;
	
		ArrayList<ArrayList<BSTNode>> lists=new ArrayList<ArrayList<BSTNode>>();
		
		getListOfDepths(nine,lists,0);
		
		for(int i=0;i<lists.size();i++)
		{
			ArrayList<BSTNode> current=lists.get(i);
			for(int j=0;j<current.size();j++)
			{
				System.out.print(current.get(j).data+" ");
			}
			System.out.println();
		}
	}

}
