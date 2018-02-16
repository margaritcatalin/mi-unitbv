package Shape;

import java.util.Comparator;

public class SortShape implements Comparator<Shape>{
	public int compare(Shape s, Shape s2) {
		if (s.aria() > s2.aria())
			return 1;
		else if (s.aria() < s2.aria())
			return -1;
		else
			return 0;
	}
}
