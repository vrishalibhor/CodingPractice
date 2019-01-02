package linkedList;

class Node
{
	Node next;
	int size;
	int value;
	
	Node(int val)
	{
		this.value=val;
		this.next=null;
	}
	
	@Override
	public String toString() {
		if(this==null)
			return "Null";
		else
			return String.valueOf(this.value);
	}
}