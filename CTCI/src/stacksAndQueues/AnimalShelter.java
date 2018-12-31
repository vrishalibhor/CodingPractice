package stacksAndQueues;

import java.util.LinkedList;

public class AnimalShelter {

	LinkedList<Animal> shelter;
	Animal head;
	
	AnimalShelter()
	{
		shelter=new LinkedList<Animal>();
		head=null;
		//shelter.
	}
	
	void enqueue(Animal animal)
	{
		if(head==null)
		{
			head=animal;
		}
	}
}
