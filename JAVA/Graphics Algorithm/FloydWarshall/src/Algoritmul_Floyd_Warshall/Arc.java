package Algoritmul_Floyd_Warshall;

public class Arc
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

	public Arc(int x, int y, int valoare) 
	{
		this.x = x;
		this.y = y;
		this.valoare = valoare;
	}
	public Arc(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}
	
	public Arc()
	{
		
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ") valoare=" + valoare;
	}
	
	
	
}
