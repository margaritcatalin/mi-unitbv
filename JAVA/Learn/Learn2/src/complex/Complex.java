package complex;

public class Complex {
private double a;//partea intreaga
private double b;//partea imaginara
public Complex(double a,double b) {
	this.a=a;
	this.b=b;
}
public Complex() {
	this(0,1);
}
public boolean equals(Object obj) {
	if(obj==null) return false;
	if(!(obj instanceof Complex)) return false;//instanceof da tipul unei anumite instante(verifica daca obj este de tipul Complex)
	Complex comp = (Complex) obj;
	return (comp.a==a && comp.b==b);
}
public Object clone() {
	return new Complex(a,b);
}
@Override
public String toString() {
	String semn=(b>0 ?"+":"-");
	return a+semn+b+"i";
}
public Complex aduna(Complex comp) {
	Complex suma=new Complex(0,0);
	suma.a=this.a+comp.a;
	suma.b=this.b+comp.b;
	return suma;
}
}
