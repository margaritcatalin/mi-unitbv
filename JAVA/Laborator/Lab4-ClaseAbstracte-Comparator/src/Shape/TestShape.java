package Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestShape {
	public static void main(String[] args) {
		ArrayList<Shape> figuri = new ArrayList<Shape>();
		Shape s = new Circle("Eustache", 4);
		Shape s2 = new Rectangle("Dorel", 2, 5);
		Shape s3 = new Rectangle("Mirel", 5, 8);
		Shape s4 = new Circle("Gigel", 9);
		figuri.add(s);
		figuri.add(s2);
		figuri.add(s3);
		figuri.add(s4);
	/*	Collections.sort(figuri, new Comparator<Shape>() {
			@Override
			public int compare(Shape s, Shape s2) {
				if (s.aria() > s2.aria())
					return 1;
				else if (s.aria() < s2.aria())
					return -1;
				else
					return 0;
			}
		});*///e bun
		Collections.sort(figuri,new SortShape());//bun si asa cu implenentarea unei alte clase.
		for (Shape g : figuri)
			System.out.println(g);
	}

	private static Comparator SortShape() {
		// TODO Auto-generated method stub
		return null;
	}
}
