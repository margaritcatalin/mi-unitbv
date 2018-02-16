package Shape;

public abstract class Shape {
private String name;
public Shape(String name) {
	// TODO Auto-generated constructor stub
	this.name=name;
}
public abstract double aria();
public abstract double perimetru();
@Override
public String toString() {
	return name+" "+aria();
}
}
