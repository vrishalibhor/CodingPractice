package linkedList;

public class Partition {

	public static Node partitionList(Node node, int x)
	{
		Node firstEnd=null, secondEnd=null, firstStart=null, secondStart=null;
		while(node!=null)
		{
			if(node.value<x)
			{
				if(firstEnd==null)
				{
					firstEnd=node;
					firstStart=firstEnd;
				}
				else
				{
					firstEnd.next=node;
					firstEnd=firstEnd.next;
				}
			}
			else
			{
				if(secondEnd==null) 
				{
					secondEnd=node;
					secondStart=secondEnd;
				}
				else 
				{
					secondEnd.next=node;
					secondEnd=secondEnd.next;
				}
			}
			node=node.next;
		}
		if(firstEnd!=null) firstEnd.next=secondStart;
		else firstStart=secondStart;
		if(secondEnd!=null) secondEnd.next=null;
		return firstStart;
	}
	
	public static void main(String[] args) {
		Node head=new Node(8);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(1);
		Node n5=new Node(4);
		Node n6=new Node(1);
		
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		
		displayLinkedList(head);
		head=partitionList(head, 2);
		displayLinkedList(head);
	}
	public static void displayLinkedList(Node head)
	{
		while(head!=null)
		{
			System.out.print(head.value+" -> ");
			head=head.next;
		}
		System.out.println("NULL");
	}

}
