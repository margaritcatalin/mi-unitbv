public class Test {
public static void gigel(String[] args)
{
	BaseClass bc=new BaseClass();
	bc.afisare();
	BaseClass bc2=new DerivedClass();
	bc2.afisare();
	//bc2.afisare2();eroare deoarece la compilare verifica mai intai in BaseClass nu in DerivedClass 
	DerivedClass dc=new DerivedClass();
	dc.afisare2();
	
}
}
