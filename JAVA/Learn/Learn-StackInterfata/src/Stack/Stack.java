package Stack;

public interface Stack {
	void push(Object item) throws StackException;

	void pop() throws StackException;

	Object peek() throws StackException;

	boolean empty();

	String toString();
}
