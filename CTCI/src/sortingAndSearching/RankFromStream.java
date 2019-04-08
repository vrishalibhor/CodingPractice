package sortingAndSearching;

class Tree
{
	NodeWithRank root;

	Tree()
	{
		this.root=null;
	}

	void insert(int data)
	{
		if(root==null)
			root=new NodeWithRank(data);
		else
			root.insertNode(data);
	}

	int getRank(int data)
	{
		return root.getNodeRank(data);
	}

	void inOrder()
	{
		if(root.left!=null)
			root.left.inOrder();
		System.out.println(root.data+" "+root.leftSize);
		if(root.right!=null)
			root.right.inOrder();
	}
}

class NodeWithRank
{
	int data;
	int leftSize;
	NodeWithRank left;
	NodeWithRank right;

	NodeWithRank(int data)
	{
		this.data=data;
		left=null;
		right=null;
		leftSize=0;
	}

	void insertNode(int d)
	{
		if(d<=this.data)
		{
			if(this.left==null)
				this.left=new NodeWithRank(d);
			else
				this.left.insertNode(d);
			this.leftSize++;
		}
		else
		{
			if(this.right==null)
				this.right=new NodeWithRank(d);
			else
				this.right.insertNode(d);
		}
	}

	int getNodeRank(int data)
	{
		if(this.data==data)
			return this.leftSize;
		if(data<this.data)
		{
			if(this.left==null)
				return -1;
			else
			{
				return this.left.getNodeRank(data);
			}
		}
		else
		{
			if(this.right==null)
				return -1;
			else
			{
				return this.leftSize+1+this.right.getNodeRank(data);
			}
		}
	}

	void inOrder()
	{
		if(this.left!=null)
			this.left.inOrder();
		System.out.println(this.data+" "+this.leftSize);
		if(this.right!=null)
			this.right.inOrder();
	}
}
public class RankFromStream {

	public static void main(String args[])
	{
		int arr[] = { 5, 1, 4, 4, 5, 9, 7, 13, 3 }; 
		int n = 9 ;
		int x = 4; 

		Tree tree=new Tree();
		for (int i = 0; i < n; i++) 
			tree.insert(arr[i]); 

		tree.inOrder();
		System.out.println();

		System.out.println(tree.getRank(4));

		for (int i = 0; i < n; i++) 
			System.out.println("Rank of "+arr[i]+" is "+tree.getRank(arr[i]));

	}
}
