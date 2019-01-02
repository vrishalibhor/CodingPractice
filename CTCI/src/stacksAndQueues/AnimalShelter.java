package stacksAndQueues;

import java.util.Iterator;
import java.util.LinkedList;

public class AnimalShelter {

	LinkedList<Animal> cats;
	LinkedList<Animal> dogs;
	int order;
	
	AnimalShelter()
	{
		cats=new LinkedList<Animal>();
		dogs=new LinkedList<Animal>();
		order=1;
	}
	
	void enqueue(Animal animal)
	{
		if(animal instanceof Cat)	enqueueCat((Cat)animal);
		else	enqueueDog((Dog)animal);
	}
	
	void enqueueCat(Cat cat)
	{
		cat.order=order++;
		cats.add(cat);
	}
	
	void enqueueDog(Dog dog)
	{
		dog.order=order++;
		dogs.add(dog);
	}
	
	Animal dequeueCat()
	{
		return cats.removeFirst();
	}
	
	Animal dequeueDog()
	{
		return dogs.removeFirst();
	}
	
	Animal dequeueAny()
	{
		if(cats.getFirst().order<dogs.getFirst().order)
			return cats.removeFirst();
		else
			return dogs.removeFirst();
	}
	
	public static void main(String args[])
	{
		AnimalShelter shelter=new AnimalShelter();
		shelter.enqueue(new Cat("c1"));
		shelter.enqueue(new Dog("d1"));
		shelter.enqueue(new Dog("d2"));
		shelter.enqueue(new Cat("c2"));
		shelter.enqueue(new Cat("c3"));
		shelter.enqueue(new Cat("c4"));
		shelter.enqueue(new Dog("d3"));
		shelter.enqueue(new Dog("d4"));
		
		displayLinkedList(shelter.cats);
		displayLinkedList(shelter.dogs);
		
		shelter.dequeueDog();
		
		displayLinkedList(shelter.cats);
		displayLinkedList(shelter.dogs);
		
		shelter.dequeueAny();
		shelter.dequeueAny();
		
		displayLinkedList(shelter.cats);
		displayLinkedList(shelter.dogs);
		
		shelter.enqueue(new Dog("d5-"));
		
		displayLinkedList(shelter.cats);
		displayLinkedList(shelter.dogs);
		
	}
	public static void displayLinkedList(LinkedList<Animal> list)
	{
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			Animal an=(Animal)it.next();
			System.out.print("("+an.name+","+an.order+") -> ");
		}
		System.out.println("NULL");
	}
}
