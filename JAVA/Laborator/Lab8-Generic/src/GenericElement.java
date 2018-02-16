import java.util.ArrayList;

public class GenericElement<T> {
private T obj;

public T getObj() {
	return obj;
}

public void setObj(T obj) {
	this.obj = obj;
}
public static <T, S> boolean searchElement(ArrayList<S> list, T element) {
	if (list.contains(element))
		return true;
	return false;
}
public static <T> boolean searchElement1(ArrayList<?> list, T element) {
	if (list.contains(element))
		return true;
	return false;
}
}
