package abstarct;

public class Circle extends GraphicObject {
	private	int x,y,raza;
	public int getX()
	{
		return x;
	}
	public int getY() {
		return y;
	}
	public int getRaza() {
		return raza;
	}
	public void setX(int x)
	{
		this.x=x;
	}
	public void setY(int y)
	{
		this.y=y;
	}
	public void setRaza(int raza)
	{
		this.raza=raza;
	}
	public Circle(int x,int y,int raza)
	{
		this.x=x;
		this.y=y;
		this.raza=raza;
	}
	public void aflaParametri(Param param) {
		param.x=x;
		param.y=y;
		param.raza=raza;
	}
	void metoda(Object ... args) {
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i]);
		}
	}
	void draw() {
		
	}

}