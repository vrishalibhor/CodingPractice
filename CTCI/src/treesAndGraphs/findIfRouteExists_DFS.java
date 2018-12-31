package treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

class Node
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
}

public class findIfRouteExists_DFS {
	public static boolean findRoute(Node source, Node destination)
	{
		boolean pathFound=false;

		if(source.data==destination.data)
			return true;

		source.visited=true;

		if(!source.getNeighbours().isEmpty())
		{
			for(int i=0;i<source.neighbours.size();i++)
			{
				Node current=source.neighbours.get(i);
				if(current.visited==false)
				{
					current.visited=true;
					if(findRoute(current, destination))
					{
						pathFound=true;
						break;
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
		oneNeigh.add(four);
		one.setNeighbours(oneNeigh);

		ArrayList<Node> threeNeigh=new ArrayList<Node>();
		threeNeigh.add(two);
		three.setNeighbours(threeNeigh);

		ArrayList<Node> fourNeigh=new ArrayList<Node>();
		fourNeigh.add(five);
		four.setNeighbours(fourNeigh);

		ArrayList<Node> fiveNeigh=new ArrayList<Node>();
		fiveNeigh.add(six);
		six.setNeighbours(fiveNeigh);

		System.out.println(findRoute(three,six));
	}
}
