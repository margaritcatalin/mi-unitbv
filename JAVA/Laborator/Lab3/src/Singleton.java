
public class Singleton {
private Singleton()
{
	
}
public static Singleton obj;
public static Singleton createObj()
{
	if(obj==null)
	obj=new Singleton();
	return obj;
}
}
