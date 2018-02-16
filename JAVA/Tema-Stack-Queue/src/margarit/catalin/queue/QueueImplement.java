package margarit.catalin.queue;

import java.util.Iterator;

import margarit.catalin.Exceptii.StructureException;
import margarit.catalin.interfaces.StructureI;
public class QueueImplement<T> implements StructureI<T> {
	class Node<T> {
		private T item;
		private Node link;

		Node(T item) {
			this.item = item;
		}
	}

	private Node<T> first = null, last = null;

	@Override
	public void push(T item) {
		// TODO Auto-generated method stub
		Node<T> node = new Node<T>(item);
		if (isEmpty()) {
			first = node;
		} else {
			if (first.link == null) {
				first.link = node;
			} else {
				last.link = node;
			}

			last = node;
		}
	}

	@Override
	public void pop() throws StructureException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new StructureException("Coada este vida!");
		}
		first = first.link;
	}

	@Override
	public T peek() throws StructureException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new StructureException("Coada este vida!");
		return first.item;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (first == null);
	}

	public String toString() {
		String s = "";
		Node node = first;
		while (node != null) {
			s += (node.item).toString() + " ";
			node = node.link;
		}
		return s;
	}
	public Iterator<T> iterator() {
		return new QueueIt();
	}
	private class QueueIt implements Iterator<T> {
		private Node<T> node = first;
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