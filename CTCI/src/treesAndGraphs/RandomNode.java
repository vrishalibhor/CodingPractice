package treesAndGraphs;

class NodeWithChildren
{
	int data;
	NodeWithChildren left;
	NodeWithChildren right;
	int children;
	
	NodeWithChildren(int data)
	{
		this.data=data;
	}
	
}

public class RandomNode {
	
	public static int getChildren(NodeWithChildren node)
	{
		if(node==null) return 0;
		else
		{
			return getChildren(node.left)+getChildren(node.right)+1;
		}
	}

	public static void main(String[] args) {

	}

}
