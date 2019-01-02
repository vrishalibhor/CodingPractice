package linkedList;

public class LinkedListPalindrome {

	public static boolean isPalindrome(Node head)
	{
		Node slow=head, fast=head;
		Node reversePoint=null;
		while(fast.next!=null && fast.next.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		reversePoint=slow.next;
		slow.next=null;	//Separate two halves
		Node head2=reversLinkedList(reversePoint);
		while(head2!=null)
		{
			if(head.value!=head2.value)
				return false;
			head=head.next;
			head2=head2.next;
		}
		return true;
	}
	public static Node reversLinkedList(Node head)
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

	public static void main(String[] args) {
		Node head=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(2);
		Node n5=new Node(1);
		Node n6=new Node(1);

		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		//n5.next=n6;

		displayLinkedList(head);
		System.out.println(isPalindrome(head));
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
