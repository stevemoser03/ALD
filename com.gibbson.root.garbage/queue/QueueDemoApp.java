package queue;

public class QueueDemoApp {

	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		Queue queue = new Queue();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
