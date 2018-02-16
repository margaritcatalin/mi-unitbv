package Stack;

public class StackImpl1 implements Stack {
	private Object items[];
	private int n = 0;

	public StackImpl1(int max) {
		// TODO Auto-generated constructor stub
		items = new Object[max];
	}

	public StackImpl1() {
		this(100); // TODO Auto-generated constructor stub
	}

	@Override
	public void push(Object item) throws StackException {
		// TODO Auto-generated method stub
		if (n == items.length)
			throw new StackException("Stiva este plina!");
		items[n++] = item;
	}

	@Override
	public void pop() throws StackException {
		// TODO Auto-generated method stub
		if (empty())
			throw new StackException("Stiva este vida!");
		items[--n] = null;
	}

	@Override
	public Object peek() throws StackException {
		// TODO Auto-generated method stub
		if (empty())
			throw new StackException("Stiva este vida!");
		return items[n - 1];
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return (n == 0);
	}

	public String toString() {
		String s = "";
		for (int i = n - 1; i >= 0; i--)
			s += items[i].toString() + " ";
		return s;
	}
}
