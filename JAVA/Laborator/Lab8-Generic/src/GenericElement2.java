
public class GenericElement2<T, S> {
private T left;
private S right;
public T getLeft() {
	return left;
}
public void setLeft(T left) {
	this.left = left;
}
public S getRight() {
	return right;
}
public void setRight(S right) {
	this.right = right;
}
@Override
public String toString() {
	return "GenericElement2 [left=" + left + ", right=" + right + "]";
}

}
