package queue;


public class Queue {
	
	private Node first = null;
	private Node last = null;
	

	public int dequeue() throws QueueEmptyException 
	{
		if (first == null)
		{
			throw new QueueEmptyException();
		}
		
		Integer ergebnis = first.getZahl();
		
		first = first.getNext();
		if (first == null)
		{
			// letzte Objektreferenz leeren
			last = null;
		}
		
		return ergebnis;
	}
	    
	public void enqueue(int i) {
		
		Node newElement = new Node(i); 
		
		if (first == null)
		{
			// Queue ist noch leer, als erstes Element setzen
			first = newElement;
		}
		else
		{
			// Am Ende anhängen
			last.setNext(newElement);
		}
		
		// Das neue "letzte" Element festlegen
		last = newElement;
	}
}
