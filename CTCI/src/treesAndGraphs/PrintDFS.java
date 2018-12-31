package treesAndGraphs;

import java.util.ArrayList;
import java.util.Stack;

public class PrintDFS {

	public static void topSort(Stack<Node> stack, Node root)
	{
		if(!root.neighbours.isEmpty())
		{
			for(int i=0;i<root.neighbours.size();i++)
			{
				Node current=root.neighbours.get(i);
				if(current.visited==false)
				{
					current.visited=true;
					topSort(stack,current);
				}
			}
		}
		stack.push(root);
		root.visited=true;
	}
	
	public static void topSortUtil(ArrayList<Node> graph)
	{
		Stack<Node> stack=new Stack<Node>();
		 
		for(int i=0;i<graph.size();i++)	//handles the case when the graph is not connected
		{
			if(graph.get(i).visited==false)
				topSort(stack,graph.get(i));
		}
		
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop().data);
		}
	}

	public static void printNodesDFS(Node root)
	{
		System.out.println(root.data);
		root.visited=true;
		if(!root.neighbours.isEmpty())
		{
			for(int i=0;i<root.neighbours.size();i++)
			{
				Node current=root.neighbours.get(i);
				if(current.visited==false)
				{
					printNodesDFS(current);
				}
			}
		}
	}
	public static void main(String[] args) {
		Node one=new Node(1);
		Node two=new Node(2);
		Node three=new Node(3);
		Node four=new Node(4);
		Node five=new Node(5);
		Node six=new Node(6);

		ArrayList<Node> oneNeigh=new ArrayList<Node>();
		oneNeigh.add(two);
		oneNeigh.add(three);
		oneNeigh.add(six);
		one.setNeighbours(oneNeigh);
		
		ArrayList<Node> twoNeigh=new ArrayList<Node>();
		twoNeigh.add(three);
		twoNeigh.add(six);
		two.setNeighbours(oneNeigh);

		ArrayList<Node> threeNeigh=new ArrayList<Node>();
		threeNeigh.add(five);
		three.setNeighbours(threeNeigh);

		ArrayList<Node> fourNeigh=new ArrayList<Node>();
		fourNeigh.add(three);
		four.setNeighbours(fourNeigh);

		ArrayList<Node> sixNeigh=new ArrayList<Node>();
		sixNeigh.add(four);
		six.setNeighbours(sixNeigh);

		printNodesDFS(one);
		
		/*ArrayList<Node> graph = new ArrayList<Node>();
		graph.add(one);
		graph.add(two);
		graph.add(three);
		graph.add(four);
		graph.add(five);
		graph.add(six);
		
		ArrayList<Node> threeNeigh=new ArrayList<Node>();
		threeNeigh.add(four);
		three.setNeighbours(threeNeigh);

		ArrayList<Node> fourNeigh=new ArrayList<Node>();
		fourNeigh.add(one);
		four.setNeighbours(fourNeigh);
		
		ArrayList<Node> fiveNeigh=new ArrayList<Node>();
		fiveNeigh.add(one);
		fiveNeigh.add(two);
		five.setNeighbours(fiveNeigh);
		
		ArrayList<Node> sixNeigh=new ArrayList<Node>();
		sixNeigh.add(one);
		sixNeigh.add(three);
		six.setNeighbours(sixNeigh);
		
		topSortUtil(graph);*/
	}

}
