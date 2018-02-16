import java.util.Scanner;
import java.util.InputMismatchException;
public class Laborator2 {
	private static int citire() throws InputMismatchException
	{
	Scanner sc = new Scanner(System.in);
	int nr = sc.nextInt();
	return nr;
	}
	private static int impartire(int a,int b) throws ArithmeticException
	{
		return a/b;
	}
	public static void main(String[] args)
	{
		try {
		System.out.println(impartire(citire(),citire()));
		}
		catch(InputMismatchException ex)
		{
			System.out.println("Introduceti un numar!");
		}
		catch(ArithmeticException ex)
		{
			System.out.println("Impartire la 0");
		}
	}
}
