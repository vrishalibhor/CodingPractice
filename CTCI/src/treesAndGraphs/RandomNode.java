package treesAndGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
class BTreePrinter1 {

	public static <T extends Comparable<?>> void printNode(RandomNode root) {
		int maxLevel = BTreePrinter1.maxLevel(root);

		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static <T extends Comparable<?>> void printNodeInternal(List<RandomNode> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || BTreePrinter1.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		BTreePrinter1.printWhitespaces(firstSpaces);

		List<RandomNode> newNodes = new ArrayList<RandomNode>();
		for (RandomNode node : nodes) {
			if (node != null) {
				System.out.print(node.data);
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			BTreePrinter1.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				BTreePrinter1.printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					BTreePrinter1.printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					BTreePrinter1.printWhitespaces(1);

				BTreePrinter1.printWhitespaces(i + i - 1);

				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					BTreePrinter1.printWhitespaces(1);

				BTreePrinter1.printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static <T extends Comparable<?>> int maxLevel(RandomNode node) {
		if (node == null)
			return 0;

		return Math.max(BTreePrinter1.maxLevel(node.left), BTreePrinter1.maxLevel(node.right)) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}

}

class RandomNode
{
	int data;
	RandomNode left;
	RandomNode right;
	int size;

	RandomNode(int data)
	{
		this.data=data;
		this.size=1;
	}

	void insertNode(int data)
	{
		if(data<this.data)
		{
			if(this.left==null)
				this.left=new RandomNode(data);
			else
				this.left.insertNode(data);
		}
		else
		{
			if(this.right==null)
				this.right=new RandomNode(data);
			else
				this.right.insertNode(data);
		}
		this.size++;
	}

	RandomNode find(int data)
	{
		if(this.data==data)
		{
			return this;
		}
		else if(data<this.data)
		{
			if(this.left!=null)
				return this.left.find(data);
		}
		else if(data>this.right.data)
		{
			if(this.right!=null)
				return this.right.find(data);
		}
		return null;
	}

	void deleteNode(int data)
	{
		if(data<this.left.data)
		{
			if(data==this.left.data)
			{
				this.left=null;
			}
			else
			{
				this.left.deleteNode(data);
			}
			this.left.size--;
		}
		else
		{
			if(data==this.right.data)
			{
				this.right=null;
			}
			else
			{
				this.right.deleteNode(data);
			}
			this.right.size--;
		}
	}

	RandomNode getRandomNode()
	{
		int leftSize = left == null ? 0 : left.size;
		Random random = new Random();
		int index = random.nextInt(size);
		if (left!=null && index < leftSize)
		{
			return left.getRandomNode();
		}
		else if (index == leftSize) 
		{
			return this;
		} 
		else 
		{
			return right.getRandomNode();
		}
	}

	public static void main(String[] args) {
		int[] counts = new int[10];
		Tree tree = new Tree();
		for (int i = 0; i < 2; i++) {

			int[] array = {1, 0, 6, 2, 3};
			for (int x : array) {
				tree.insert(x);
			}
			int d = tree.root.getRandomNode().data;
			counts[d]++;
		}
		BTreePrinter1.printNode(tree.root);
		for (int i = 0; i < counts.length; i++) {
			System.out.println(i + ": " + counts[i]);
		}
	}
}

class Tree
{
	RandomNode root;

	Tree()
	{
		this.root=null;
	}

	Tree(RandomNode root)
	{
		this.root=root;
	}

	void insert(int data)
	{
		if(this.root==null)
			root=new RandomNode(data);
		else
			root.insertNode(data);
	}

	RandomNode find(int data)
	{
		return root.find(data);
	}

	void deleteNode(int data)
	{
		if(root!=null && root.find(data)!=null)
		{
			if(root.data==data)
			{
				root=null;
			}
			else if(data<root.left.data)
			{
				if(root.left.data==data)
				{
					root.left=null;
				}
				else
				{
					root.left.deleteNode(data);
				}
			}
			else
			{
				if(root.right.data==data)
				{
					root.right=null;
				}
				else
				{
					root.right.deleteNode(data);
				}
			}
			root.size--;
		}
	}


	public RandomNode getRoot() {
		return root;
	}

	public void setRoot(RandomNode root) {
		this.root = root;
	}
}

