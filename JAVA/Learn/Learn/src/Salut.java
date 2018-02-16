
public class Salut {
public static void main(String args[]) {
	if(args.length==0) {
		System.out.println("Numar insuficient de argumente!");
	}
String nume = args[0];
String prenume;
if(args.length >= 1)
prenume=args[1];
else
	prenume = "";
System.out.println("Salut "+ nume + " " + prenume);
}
}
