

public class DerivedClass extends BaseClass{
	public void afisare()//nu se poate pune protected sau private
	{
		System.out.println("Derived Class method");
	}
	public void afisare2() {
		super.afisare();//apeleaza metoda din clasa mama
		System.out.println("Metoda2");
	}
}
