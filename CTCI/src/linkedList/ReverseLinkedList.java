package linkedList;

public class ReverseLinkedList {

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
		
		displayLinkedList(head1);
		Node h=reverse(head1);
		displayLinkedList(h);
	}
	
	public static Node reverse(Node head)
	{
		Node next=null, prev=null;
		while(head!=null)
		{
			next=head.next;
			head.next=prev;
			prev=head;
			head=next;
		}
		return prev;
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
