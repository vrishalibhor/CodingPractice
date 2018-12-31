package stacksAndQueues;

public class Animal 
{
	String name;
	Animal next;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	Animal(String name)
	{
		this.name=name;
	}
	
}
