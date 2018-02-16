
public class Exemplu {
public static void main(String[] args)
{
 int a[]= {1,2,3,4};
 int b[]=new int[4];
 for(int i=0;i<a.length;i++)
	 b[i]=a[i];
 System.arraycopy(a, 0, b, 0, a.length);
 b=a;
 for(int i=0;i<b.length;i++)
	 System.out.println(b[i]+" ");
}
}
