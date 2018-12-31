package treesAndGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BSTNode<T extends Comparable<?>> 
{
	int data;
	BSTNode left;
	BSTNode right;
	BSTNode parent;
	
	BSTNode(int data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
		this.parent=null;
	}
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(BSTNode<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<BSTNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<BSTNode<T>> newNodes = new ArrayList<BSTNode<T>>();
        for (BSTNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(BSTNode<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}

public class MinimalBinarySearchTree {

	public static void main(String args[])
	{
		int arr[]= {2,4,5,8,9,11,13,17};
		BSTNode root=getRootNode(arr,0,arr.length-1);
		BTreePrinter.printNode(root);
	}
	public static BSTNode getRootNode(int arr[], int low, int high)
	{
		BSTNode node=null;
		if(low==high)
		{
			node=new BSTNode(arr[low]);
		}
		else if(low<high)
		{
			int mid=((low+high)+1)/2;
			node=new BSTNode(arr[mid]);
			node.left=getRootNode(arr, low, mid-1);
			node.right=getRootNode(arr, mid+1, high);
		}
		return node;	
	}
	public static void print(BSTNode root) 
	{
	    inOrder(root);
	}
	
	public static void inOrder(BSTNode node) 
	{
		if (node == null) 
		{
			return;
			
		}
		inOrder(node.left); 
		System.out.println("   "+node.data); 
		inOrder(node.right);
	}

	
	public static void printHelper(BSTNode root, String indent) 
	{
	    if (root == null) 
	    {
	      System.out.println(indent + "null");
	      return;
	    }

	    // Pick a pretty indent.
	    String newIndent;
	    if (indent.equals("")) {
	      newIndent = ".. ";
	    }
	    else {
	      newIndent = "..." + indent;
	    }

	    printHelper(root.left, newIndent);
	    System.out.println(indent + root.data);
	    printHelper(root.right, newIndent);
	  }
}
