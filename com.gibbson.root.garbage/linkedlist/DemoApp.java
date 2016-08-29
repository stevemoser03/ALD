package linkedlist;

public class DemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list =new LinkedList();
		
		list.add(2);
		list.add(5);
		list.add(9);
		
		Node current = list.getFirst();
		do
		{
			System.out.println(current.getValue());
		} while ((current = current.getNext()) != null);
		
	}

}
