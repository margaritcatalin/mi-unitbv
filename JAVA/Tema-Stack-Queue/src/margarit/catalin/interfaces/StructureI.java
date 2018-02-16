package margarit.catalin.interfaces;

import margarit.catalin.Exceptii.StructureException;

public interface StructureI<T> {
	void push(T element);

	void pop() throws StructureException;

	T peek() throws StructureException;

	boolean isEmpty();

	String toString();
}
