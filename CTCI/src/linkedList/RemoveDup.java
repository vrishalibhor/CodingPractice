 package linkedList;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class Node
{
	Node next;
	Node prev;
	int value;
	
	Node(int val)
	{
		this.value=val;
	}
}
public class RemoveDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<ListNode> list=new LinkedList<Node>();
	}

	public static void noDupsList(LinkedList list)
	{
		Hashtable table=new Hashtable();
		ListIterator<Integer> itr=list.listIterator();
		while(itr.hasNext())
		{
			Object current=itr.next();
			if(table.contains(current))
			{
				//itr.previousIndex().
			}
		}
		
	}
}
