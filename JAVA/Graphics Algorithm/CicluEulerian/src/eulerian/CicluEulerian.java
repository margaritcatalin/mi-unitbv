package eulerian;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CicluEulerian {
    private int[][] mat;
    private int nrNoduri; 
 
    public CicluEulerian (int nrNoduri, int[][] mat)
    {
        this.nrNoduri = nrNoduri;
        this.mat= new int[nrNoduri + 1] [nrNoduri + 1];
        for (int i = 1; i <= nrNoduri; i++)
        {
            for (int j = 1; j <= nrNoduri; j++)
            {
                this.mat[i][j] = mat[i] [j];
            }
        }
    }
 
    public int grad (int nod)
    {
        int grad = 0;
        for (int i = 1; i <= nrNoduri ; i++)
        {
            if (mat[nod][i] == 1 || mat[i][nod] == 1)
            {
            	grad++;
            }
        }
        return grad;
    }
 
    public int verifParitate ()
    {
        int nod = -1;
        for (int i = 1; i <= nrNoduri; i++) 
        {
            if ((grad(i) % 2) != 0)
            {
                nod = i;
                break;
            }
        }
        return nod;
    }
 
    public void afisare (int nod)
    {
        for (int i = 1; i <= nrNoduri; i++)
        {
            if(mat[nod][i] == 1 && validare(nod, i))
            {
                System.out.println(nod + "  " + i + " ");
                eliminare(nod, i);
                afisare(i);
            }	
        }
    }
 
    public void printEulerTour ()
    {
        int nod = 1;
        if (verifParitate() != -1)
        {
        	nod = verifParitate();
        }
        afisare(nod);
        return;
    }
 
    public boolean validare (int sursa, int destinatie)
    {
        int nr = 0;
        for (int i = 1; i <= nrNoduri; i++)
        {
            if (mat[sursa][i] == 1)
            {
                nr++;
            }
        }
 
        if (nr == 1 )
        {   
            return true;
        }
 
        int vizitate[] = new int[nrNoduri + 1];		
        int count1 = DFSCount(sursa, vizitate);
 
        eliminare(sursa, destinatie);
        for (int i = 1; i <= nrNoduri; i++)
        {
        	vizitate[i] = 0;
        }
 
       int count2 = DFSCount(sursa, vizitate);
       adaugare(sursa, destinatie);
 
       return (count1 > count2 ) ? false : true;
    } 
 
    public int DFSCount (int sursa, int vizitate[])
    {
    	vizitate[sursa] = 1;
        int count = 1;
        int destinatie = 1;
 
        while (destinatie <= nrNoduri)
        {
            if(mat[sursa][destinatie] == 1 && vizitate[destinatie] == 0)
            {
                count += DFSCount(destinatie, vizitate);
            }
            destinatie++;
        }
        return count;
    }
 
    public void eliminare (int source, int destination)
    {
        mat[source][destination]  = 0;
        mat[destination][source] = 0;
    }
 
    public void adaugare (int source, int destination)
    {
        mat[source][destination] = 1;
        mat[destination][source] = 1;
    }
 
    public static void main (String[] args) throws FileNotFoundException
    {
        int nrNoduri;
        Scanner sc = new Scanner(new FileReader("C:\\Users\\catal\\Desktop\\Algoritmica Grafurilor Margarit Marian Catalin\\eulerian.txt"));
        nrNoduri = sc.nextInt();
        int mat[][] = new int[nrNoduri + 1][nrNoduri + 1];
        for (int i = 1; i <= nrNoduri; i++)
          for (int j = 1; j <= nrNoduri; j++)
        	  mat[i][j] = sc.nextInt();
        for (int i = 1; i <= nrNoduri; i++)
        	for (int j = 1; j <= nrNoduri; j++)
        		if (mat[i][j] == 1 && mat[j][i] == 0)
        			mat[j][i] = 1;
        
        CicluEulerian circuit = new CicluEulerian(nrNoduri, mat);
        circuit.printEulerTour();
        sc.close();
    }	
}
