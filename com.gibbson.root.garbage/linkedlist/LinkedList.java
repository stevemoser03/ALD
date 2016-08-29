package linkedlist;

public class LinkedList {

	private Node first;
	private Node last;
	
	public Node getFirst()
	{
		return first;
	}
	
	public LinkedList()
	{
		first = null;
		last = null;
	}
	
	public void add(Integer value)
	{
		Node node = new Node(value);
		
		if (first == null)
		{
			first = node;
			last = first;
		}
		else
		{
			/*Node current = first;
			while (current.getNext() != null)
			{
				current = current.getNext();
			}
			// Wir sind am letzten Node angekommen
			current.setNext(node);
			*/
			last.setNext(node);
			last = node;
		}
	}
		
}
