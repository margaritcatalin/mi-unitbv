import java.util.Scanner;

public class TestException 
{
	private static void citire() throws MyException
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		if(s.contains(" "))
		{
			throw new MyException("Ai spatii");
		}
	}
	public static void main(String[] args)
	{
		try {
			citire();
			}
		catch (MyException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
