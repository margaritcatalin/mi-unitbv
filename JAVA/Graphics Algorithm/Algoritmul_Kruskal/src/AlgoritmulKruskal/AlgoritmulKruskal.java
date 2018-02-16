package AlgoritmulKruskal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class AlgoritmulKruskal 
{
	public static int pivot(ArrayList<Muchie> A,int st,int dr)
	{
		int j=dr;
		int i=st;
		int sens=1;
		while(i<j)
		{
			if(A.get(i).getValoare()>A.get(j).getValoare())
			{
				Muchie m=new Muchie();
				m=A.get(i);
				A.set(i,A.get(j));
				A.set(j,m);
				sens=1-sens;
			}
			if(sens==1)
			{
				i++;
			}
			else
				j--;
		}
		return j;
	}
	
	public static void quicksort(ArrayList<Muchie> A,int st,int dr)
	{
		if(st<dr)
		{
			int p=pivot(A,st,dr);
			quicksort(A,st,p-1);
			quicksort(A,p+1,dr);
		}
	}
	
	public static boolean verifCiclu(ArrayList<Muchie> A1,ArrayList<Integer> noduri)
	{
		if(A1.size()<noduri.size())
			return false;
		return true;
	}
	
	public static void Kruskal(ArrayList<Muchie> A,int nrNoduri)
	{
		ArrayList<Muchie> A1=new ArrayList<Muchie>(); //A'
		ArrayList<Integer> noduri = new ArrayList<Integer> ();
		
		quicksort(A,0,A.size()-1);
		System.out.println("Dupa sortare A= "+A);
		System.out.println();
		
		for(int i=0;i<A.size();i++)
		{
			Muchie m=new Muchie();
			m=A.get(i);
			A1.add(m);
			if(!noduri.contains(m.getX()))
				noduri.add(m.getX());
			if(!noduri.contains(m.getY()))
				noduri.add(m.getY());
			if(verifCiclu(A1,noduri)==true)
			{
				A1.remove(A1.size()-1);
				System.out.println("["+m.getX()+","+m.getY()+"] "+ "formeaza ciclu cu A'");
				System.out.println();
			}
			else
			{
				System.out.println("A'= "+A1);
				System.out.println();
			}
		}
		System.out.println("A'= "+A1);
		
	}

    public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		int nrNoduri,nrMuchii,valoare,x,y;
		ArrayList<Muchie> A=new ArrayList<Muchie>();
		Muchie arc;
		BufferedReader f = null;
		try {
			f = new BufferedReader(new FileReader("C:\\Users\\catal\\Desktop\\Algoritmica Grafurilor Margarit Marian Catalin\\fisiere\\Kruskal.txt"));
			String dateall = f.readLine();
			String[] date = dateall.split(";");
			nrNoduri = Integer.parseInt(date[0]);
			nrMuchii = Integer.parseInt(date[1]);
			String[] sep = date[2].split(",");
			for (int i = 0; i < sep.length; i++) {
				String[] arce = sep[i].split("-");
				arc = new Muchie(Integer.parseInt(arce[0]), Integer.parseInt(arce[1]), Integer.parseInt(arce[2]));
				A.add(arc);
			}
			Kruskal(A,nrNoduri);
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
