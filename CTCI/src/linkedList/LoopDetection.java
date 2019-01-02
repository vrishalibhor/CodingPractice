package linkedList;

public class LoopDetection {
	
	public static Node getLoopStart(Node head)
	{
		Node slow=head,fast=head;
		
		while(slow!=null && fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) //Collision point
				break;
		}
		
		if(fast.next==null || fast.next.next==null)
			return null;
		
		slow=head;
		
		while(slow!=fast)
		{
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
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
		n6.next=n2;
		
		//displayLinkedList(head1);
		System.out.println(getLoopStart(head1));
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
