package linkedList;

public class ReturnKthToLast {

	public static Node getKthToLast(Node head, int k)
	{
			Node slow=head,fast=head;
			for(int i=0;i<k;i++)
			{
				if(fast.next!=null)
				{
					fast=fast.next;
				}
				else
					return null;
			}
			
			while(fast!=null)
			{
				fast=fast.next;
				slow=slow.next;
			}
			return slow;
	}
	
	public static void main(String[] args) {
		Node head=new Node(1);
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
		Node n=getKthToLast(head,5);
		if(n==null) System.out.println("Null");
		else System.out.println(n.toString());
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
