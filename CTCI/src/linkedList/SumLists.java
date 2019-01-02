package linkedList;

public class SumLists {

	public static Node getSumLists(Node head1, Node head2)
	{
		Node head=null,current=null;
		int carry=0;
		while(head1!=null && head2!=null)
		{
			int val=head1.value+head2.value+carry;
			if(val>9)
			{
				carry=1;
				val-=10;
			}
			else
			{
				carry=0;
			}
			Node n=new Node(val);
			if(head==null)
			{
				head=n;
				current=head;
			}
			else
			{
				current.next=n;
				current=current.next;
			}
			head1=head1.next;
			head2=head2.next;
		}

		if(carry==1)
		{
			int val=carry;
			Node n=null;
			if(head1!=null)
			{
				val+=head1.value;
				n=new Node(val);
				current.next=n;
				current=current.next;
				head1=head1.next;
			}
			else if(head2!=null) 
			{
				val+=head2.value;
				n=new Node(val);
				current.next=n;
				current=current.next;
				head2=head2.next;
			}
			else
			{
				n=new Node(val);
				current.next=n;
				current=current.next;
			}
		}

		while(head1!=null)
		{
			current.next=head1;
			current=current.next;
			head1=head1.next;
		}

		while(head2!=null)
		{
			current.next=head2;
			current=current.next;
			head2=head2.next;
		}

		return head;
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

		displayLinkedList(head1);
		displayLinkedList(head2);
		Node head=getSumLists(head1,head2);
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
