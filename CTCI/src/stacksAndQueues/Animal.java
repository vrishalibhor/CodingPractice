package stacksAndQueues;

public class Animal 
{
	String name;
	Animal next;
	int order;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Animal(String name)
	{
		this.name=name;
	}

	public Animal getNext() {
		return next;
	}

	public void setNext(Animal next) {
		this.next = next;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
}
