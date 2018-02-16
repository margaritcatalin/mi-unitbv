package Stack;

public class StackImpl2 implements Stack {
	class Node {
		Object item;
		Node link;

		Node(Object item, Node link) {
			this.item = item;
			this.link = link;
		}
	}

	private Node top = null;

	@Override
	public void push(Object item) {
		// TODO Auto-generated method stub
		Node node = new Node(item, top);
		top = node;
	}

	@Override
	public void pop() throws StackException {
		// TODO Auto-generated method stub
		if (empty())
			throw new StackException("Stiva este vida!");
		top=top.link;

	}

	@Override
	public Object peek() throws StackException {
		// TODO Auto-generated method stub
		if (empty())
			throw new StackException("Stiva este vida!");
		return top.item;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return (top==null);
	}
public String toString() {
	String s="";
	Node node=top;
	while(node!=null) {
		s+=(node.item).toString()+" ";
		node=node.link;
	}
	return s;
}
}
