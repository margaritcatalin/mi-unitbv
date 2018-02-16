package exceptii;

public class Stiva {
int elemente[] =new int[100];
int n=0;
public void adauga(int x) throws ExceptieStiva{
	if(n==100)
		throw new ExceptieStiva("Stiva este plina!");
	elemente[n++]=x;
}
public int scoate() throws ExceptieStiva{
	if(n==0)
		throw new ExceptieStiva("Stiva este goala!");
	return elemente[n--];
}
public static void main(String[] args) {
	Stiva s=new Stiva();
}
}
