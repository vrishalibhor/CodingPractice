package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBFS {
	
	public static void printNodesBFS(Node root)
	{
		Queue<Node> que=new LinkedList<Node>();
		que.add(root);
		
		while(!que.isEmpty())
		{
			Node current=que.remove();
			current.visited=true;
			System.out.println(current.data);
			
			for(int i=0; i<current.neighbours.size(); i++)
			{
				if(current.neighbours.get(i).visited==false)
				{
					current.neighbours.get(i).visited=true;
					que.add(current.neighbours.get(i));
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

		printNodesBFS(one);

	}

}
