package linkedList;

public class DeleteMiddleNode {

	public static void deleteAnyNode(Node node)
	{
		if(node!=null)
		{
			node.value=node.next.value;
			node.next=node.next.next;
		}
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
		deleteAnyNode(n4);
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
