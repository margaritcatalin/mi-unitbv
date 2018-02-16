package margarit.catalin.stack;

import java.util.Iterator;
import java.lang.Iterable;
import margarit.catalin.Exceptii.StructureException;
import margarit.catalin.interfaces.StructureI;

public class StackImplement<T> implements StructureI<T> {
	class Node<T> {
		private T item;
		private Node link;

		Node(T item, Node link) {
			this.item = item;
			this.link = link;
		}
	}

	private Node<T> top = null;

	@Override
	public void push(T item) {
		// TODO Auto-generated method stub
		Node<T> node = new Node<T>(item, top);
		top = node;
	}

	@Override
	public void pop() throws StructureException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new StructureException("Stiva este vida!");
		top = top.link;

	}

	@Override
	public T peek() throws StructureException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new StructureException("Stiva este vida!");
		return top.item;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top == null);
	}

	public String toString() {
		String s = "";
		Node<T> node = top;
		while (node != null) {
			s += (node.item).toString() + "\n";
			node = node.link;
		}
		return s;
	}

	public Iterator<T> iterator() {
		return new StackIt();
	}
	private class StackIt implements Iterator<T> {
		private Node<T> node = top;
		public boolean hasNext() {
			return node != null; 
		}
		public T next() {
			T item = node.item;
			node = node.link;
			return item;
		}
	}
}
