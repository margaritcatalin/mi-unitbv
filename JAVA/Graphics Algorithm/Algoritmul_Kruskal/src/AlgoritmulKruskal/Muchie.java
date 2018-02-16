package AlgoritmulKruskal;

public class Muchie
{
	private int x;
	private int y;
	private int valoare;
	
	public int getY() 
	{
		return y;
	}
	
	public void setY(int y) 
	{
		this.y = y;
	}
	
	public int getX() 
	{
		return x;
	}
	
	public void setX(int x) 
	{
		this.x = x;
	}
	
	public int getValoare() 
	{
		return valoare;
	}
	
	public void setValoare(int valoare) 
	{
		this.valoare = valoare;
	}

	public Muchie(int x, int y, int valoare) 
	{
		this.x = x;
		this.y = y;
		this.valoare = valoare;
	}
	public Muchie(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}
	
	public Muchie()
	{
		
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ") valoare=" + valoare;
	}
	
	
	
}
