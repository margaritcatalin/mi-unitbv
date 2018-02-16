package catalin.serializari;

import java.io.Serializable;

public class Test1 implements Serializable {
	int x = 1;
	transient int y = 2;
	transient static int z = 3;
	static int t = 4;

	public String toString() {
		return x + ", " + y + ", " + z + ", " + t;
	}
}
