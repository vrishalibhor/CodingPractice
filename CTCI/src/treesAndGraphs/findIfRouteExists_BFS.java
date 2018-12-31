package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*class Node
{
	int data;
	boolean visited;
	List<Node> neighbours;
	
	Node(int data)
	{
		this.data=data;
		this.neighbours=new ArrayList<Node>();
		this.visited=false;
	}
	
	Node(int data, ArrayList<Node> neighbours)
	{
		this.data=data;
		this.neighbours=neighbours;
		this.visited=false;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Node> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}
}*/
public class findIfRouteExists_BFS {
	public static boolean findRouteBFS(Node source, Node destination)
	{
		boolean pathFound=false;
		
		if(source.data==destination.data)
			return true;
		
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(source);
		
		while(!queue.isEmpty())
		{
			Node current=queue.remove();
			current.visited=true;
			if(!current.neighbours.isEmpty())
			{
				for(int i=0;i<current.neighbours.size();i++)
				{
					Node n=current.neighbours.get(i);
					if(n.visited==false)
					{
						n.visited=true;
						queue.add(n);
						if(n.data==destination.data)
						{
							pathFound=true;
							break;
						}
					}
					
				}
			}
		}		
		return pathFound;
	}
	
	public static void main(String args[])
	{
		Node one=new Node(1);
		Node two=new Node(2);
		Node three=new Node(3);
		Node four=new Node(4);
		Node five=new Node(5);
		Node six=new Node(6);
		
		ArrayList<Node> oneNeigh=new ArrayList<Node>();
		oneNeigh.add(two);
		oneNeigh.add(three);
		//oneNeigh.add(four);
		one.setNeighbours(oneNeigh);
		
		ArrayList<Node> twoNeigh=new ArrayList<Node>();
		twoNeigh.add(five);
		two.setNeighbours(twoNeigh);
		
		ArrayList<Node> threeNeigh=new ArrayList<Node>();
		threeNeigh.add(four);
		threeNeigh.add(five);
		three.setNeighbours(threeNeigh);
		
		/*ArrayList<Node> fourNeigh=new ArrayList<Node>();
		fourNeigh.add(five);
		four.setNeighbours(fourNeigh);
		
		ArrayList<Node> fiveNeigh=new ArrayList<Node>();
		fiveNeigh.add(six);
		six.setNeighbours(fiveNeigh);*/
		
		System.out.println(findRouteBFS(two,four));
	}
}
