package linkedList;

public class Intersection {

	public static Node getTailAndSize(Node head)
	{
		int size=0;
		while(head.next!=null)
		{
			head=head.next;
			size++;
		}
		head.size=size;
		return head;
	}
	
	public static Node goAheadBy(Node head, int numNodes)
	{
		while(numNodes>0)
		{
			if(head!=null)
			{
				head=head.next;
				numNodes--;
			}
			else return null;
		}
		return head;
	}
	
	public static Node getIntersection(Node head1, Node head2)
	{
		Node tail1=getTailAndSize(head1);
		Node tail2=getTailAndSize(head2);
		
		if(tail1==null || tail2==null || tail1!=tail2)
		{
			return null;
		}
		
		Node smaller=head1;
		Node longer=head2;
		
		if(tail1.size>tail2.size)
		{
			longer=goAheadBy(head1, tail1.size-tail2.size);
			smaller=head2;
		}
		else
		{
			longer=goAheadBy(head2, tail2.size-tail1.size);
			smaller=head1;
		}
		
		while(smaller!=longer)
		{
			smaller=smaller.next;
			longer=longer.next;
		}
		
		return smaller;
	}
	
	public static void main(String[] args) {
		Node head1=new Node(7);
		Node n1=new Node(1);
		Node n2=new Node(6);
		Node n3=new Node(3);
		Node n6=new Node(5);

		head1.next=n1;
		n1.next=n2;
		n2.next=n3;
		n3.next=n6;

		Node head2=new Node(5);
		Node n4=new Node(9);
		Node n5=new Node(3);

		head2.next=n4;
		n4.next=n5;
		n5.next=n3;

		displayLinkedList(head1);
		displayLinkedList(head2);
		System.out.println(getIntersection(head1, head2));
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
