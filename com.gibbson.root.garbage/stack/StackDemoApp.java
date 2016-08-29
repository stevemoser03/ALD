package stack;

public class StackDemoApp {

	public static void main(String[] args) throws StackEmptyException {
		// TODO Auto-generated method stub

		Stack stack = new Stack();
		
		stack.push(3);
		stack.push(8);
		stack.push(2);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
