package stack;

public class Stack {

	private Node first;
	
	public Stack() {
		first = null;
	}
	
	public void push(Integer wert)
	{
		// Objekt erzeugen
		Node newElement = new Node(wert);
		
		// Neues Element mit dem obersten verknüpfen
		newElement.setNext(first);
		
		// Neues Element als oberstes festlegen
		first = newElement;
	}
	
	public Integer pop() throws StackEmptyException
	{
		if (first == null)
		{
			throw new StackEmptyException();
		}
		
		Integer rueckgabe = first.getZahl();
		
		first = first.getNext();
		// Achtung, bei letzten Node wird first auf NULL gesetzt, da getNext() den Wert NULL liefert
		
		return rueckgabe;
	}

	
	
	
	
}
