package AlgoritmulPrim;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class AlgoritmulPrim 
{

	public static int minim(ArrayList<Integer> v,int nrNoduri,ArrayList<Integer> N1b)
	{
		int minim,j;
		int poz=-1;
		minim=99999;
		for(int i=0;i<N1b.size();i++)
		{
			j=N1b.get(i)-1;
			if(v.get(j) < minim)
			{
				minim=v.get(j);
				poz=j;
			}
		}
		return poz;
	}
	
    public static void prim(ArrayList<Integer> N,int nrNoduri,int nrMuchii,ArrayList<Muchie> A,ArrayList<Muchie> E)
    {
    	ArrayList<Integer> N1 = new ArrayList<Integer>();
    	ArrayList<Integer> N1b = new ArrayList<Integer>();
    	ArrayList<Integer> v = new ArrayList<Integer>();
    	ArrayList<Muchie> A1=new ArrayList<Muchie>();
    	ArrayList<Muchie> e=new ArrayList<Muchie>();
    	Muchie m;
    	
    	for(int i=0;i<nrNoduri;i++)
		{
			e.add(null);
		}
    	v.add(0);
    	for(int i=1;i<nrNoduri;i++)
    	{
    		v.add(9999);
    	}
    	
    	for(int i=0;i<nrNoduri;i++)
		{
			N1b.add(i+1);
		}
    	
    	while(N1.size()<N.size())
    	{
    		int poz=minim(v,nrNoduri,N1b);
    		int y=(poz+1);
    		System.out.println();
    		System.out.println("Costul minim:");
    		System.out.println("v["+y+"]="+v.get(poz));
    		N1.add(y);
    		N1b.remove(N1b.indexOf(y));
    		
    		System.out.println("N1:  "+N1);
    		
    		if(y!=1)
    		{
    			A1.add(e.get(y-1));
    			System.out.println("A'= "+A1);
    		}
    		
    		for(int i=0;i<E.size();i++)
    		{
    			if(E.get(i).getX()==y)
    			{
    				if(N1.contains(y))
    				{
    					int yb=E.get(i).getY();
    					if(N1b.contains(yb))
    					{
    						if(v.get(yb-1)>E.get(i).getValoare())
    						{
    							int val=E.get(i).getValoare();
    							v.set(yb-1,val);
    							System.out.println("v["+yb+"]="+val);
    							m=new Muchie(y,yb,val);
    							e.set(yb-1, m);
    							System.out.println("e["+yb+"]="+"["+y+","+yb+"]");
    						}
    					}
    				}
    			}
    		}
    	}
    }
	
	public static void main(String[] args) 
	{
		int nrNoduri,nrMuchii,valoare,x,y;
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> N = new ArrayList<Integer>();
		ArrayList<Muchie> A=new ArrayList<Muchie>();
		ArrayList<Muchie> E=new ArrayList<Muchie>();
		Muchie arc;
		BufferedReader f = null;
		try {
			f = new BufferedReader(new FileReader("C:\\Users\\catal\\Desktop\\Algoritmica Grafurilor Margarit Marian Catalin\\fisiere\\graf.txt"));
			String dateall = f.readLine();
			String[] date = dateall.split(";");
			nrNoduri = Integer.parseInt(date[0]);
			nrMuchii = Integer.parseInt(date[1]);
			String[] sep = date[2].split(",");
			for (int i = 0; i < sep.length; i++) {
				String[] arce = sep[i].split("-");
				arc = new Muchie(Integer.parseInt(arce[0]), Integer.parseInt(arce[1]), Integer.parseInt(arce[2]));
				A.add(arc);
				E.add(arc);
				arc = new Muchie(Integer.parseInt(arce[1]), Integer.parseInt(arce[0]), Integer.parseInt(arce[2]));
				E.add(arc);
			}
			for(int i=0;i<nrNoduri;i++)
			{
				N.add(i+1);
			}
			prim( N,nrNoduri,nrMuchii, A,E);
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

