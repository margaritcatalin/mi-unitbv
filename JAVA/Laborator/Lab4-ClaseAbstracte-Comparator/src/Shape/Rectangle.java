package Shape;

public class Rectangle extends Shape{
private int width;
private int height;
public Rectangle(String s,int l,int L) {
	super(s);
	this.width=l;
	this.height=L;
}
public double aria() {
	return width*height;
}
public double perimetru() {
	return 2*width+2*height;
}
}
