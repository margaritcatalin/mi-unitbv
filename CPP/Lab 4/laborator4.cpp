#include<iostream>
#include<conio.h>
using namespace std;
struct Punct2d {
	int cordx, cordy;
	int cadran()
	{
		if (cordx > 0 && cordy > 0)
			return 1;
		if (cordx < 0 && cordy > 0)
			return 2;
		if (cordx < 0 && cordy < 0)
			return 3;
		if (cordx > 0 && cordy < 0)
			return 4;
		return 0;
	}
	double distanta1(Punct2d p)
	{
		return sqrt((p.cordx - cordx)*(p.cordx - cordx) + (p.cordy - cordy)*(p.cordy - cordy));
	}
	Punct2d operator =(Punct2d p)
	{
		cordx = p.cordx;
		cordy = p.cordy;
		return (*this);
	}

};
istream& operator >> (istream& flux, Punct2d &p)
{
	flux >> p.cordx >> p.cordy;
	return flux;
}
ostream& operator <<(ostream& flux, Punct2d p)
{
	flux << "(" << p.cordx << "," << p.cordy << ")" << endl;
	return flux;
}
void citire(Punct2d &p)
{
	cin >> p.cordx >> p.cordy;
}
double distanta2(Punct2d p1, Punct2d p2)
{
	return sqrt((p1.cordx - p2.cordx)*(p1.cordx - p2.cordx) + (p1.cordy - p2.cordy)*(p1.cordy - p2.cordy));
}
Punct2d operator +(Punct2d p1, Punct2d p2)
{
	Punct2d rez;
	rez.cordx = p1.cordx + p2.cordx;
	rez.cordy = p1.cordy + p2.cordy;
	return rez;
}
int cadrandominat(Punct2d a,int n)
{
	int i,imax;
	unsigned *cadran,max;
	cadran = new unsigned[n];
	for(i=0;i<n;i++)
	{
		if (a[i].cadran() == 1)
		{
			cadran[i]++;
		}
	}
	max = cadran[0];
	imax = 0;
	for (i = 1; i < n; i++)
		if (max < cadran[i])
		{
			max = cadran[i];
			imax = i;
		}
	delete cadran;
	return imax;
}
void main()
{
	Punct2d a, b, c, d,*v;
	int n, i;
	cout << "n=" << endl;
	cin >> n;
	v = new Punct2d[n];
	for (i = 0; i < n; i++)
	{
		cout << "v[" << i << "]=";
		citire(v[i]);
		cout << endl;
	}
	cin >> a.cordx >> a.cordy;
	citire(b);
	cin >> c;
	cout << a << b;
	cout << a.cadran();
	d = a + b;
	cout << d;
	cout << a.distanta1(b)<<endl;
	cout << distanta2(a, b)<<endl;
	cout << "Cadranul dominant este:" << cadrandominat(v,n);
	delete v;
	_getch();
}