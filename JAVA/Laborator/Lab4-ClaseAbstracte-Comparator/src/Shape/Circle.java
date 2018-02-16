package Shape;
public class Circle extends Shape{
private int radius;
final double PI=3.14;
public Circle(String name,int radius) {
	super(name);//apeleaza constructorul din clasa parinte
	this.radius=radius;
	//this.name=name;eroare deoarece nu este vizibil in clasa derivata(protected)
}
public double aria() {
	return PI*Math.pow(radius,2);
}
public double perimetru() {
	return 2*PI*radius;
}

}
