
public class Test {
public static void main(String args[])
{
	A a=new A(20);
	A c=new A(a);
	A d=new A();
	a=d;
	System.out.println(a==c);//false
	System.out.println(a==d);//true
	c.nr=25;
	System.out.println(c.nr+" "+a.nr);
	d.nr=30;
	System.out.println(d.nr+" "+a.nr);
}
}
