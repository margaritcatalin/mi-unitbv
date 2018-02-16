#include <iostream>
#include <math.h>
using namespace std;
struct Punct2D
{
	int coordx, coordy;
	int cadran()
	{
		if (coordx == 0 || coordy == 0)
			return 0;
		if (coordx > 0 && coordy > 0)
			return 1;
		if (coordx < 0 && coordy > 0)
			return 2;
		if (coordx < 0 && coordy < 0)
			return 3;
		if (coordx > 0 && coordy < 0)
			return 4;
	}
	float distanta1(Punct2D p)
	{
		return sqrt((p.coordx - coordx)*(p.coordx - coordx) + (p.coordy - coordy)*(p.coordy - coordy));
	}
	Punct2D& operator = (Punct2D p)
	{
		coordx = p.coordx;
		coordy = p.coordy;
		return (*this);
	}
};

Punct2D operator + (Punct2D p1, Punct2D p2)
{
	Punct2D rez;
	rez.coordx = p1.coordx + p2.coordx;
	rez.coordy = p1.coordy + p2.coordy;
	return rez;
}

istream& operator >> (istream& flux, Punct2D &p)
{
	flux >> p.coordx >> p.coordy;
	return flux;
}
ostream& operator << (ostream& flux, Punct2D p)
{
	flux << "(" << p.coordx << "," << p.coordy << ")" << endl;
	return flux;
}
void citire(Punct2D &p)
{
	cin >> p.coordx >> p.coordy;
}
float distanta2(Punct2D p1, Punct2D p2)
{
	return sqrt((p2.coordx - p1.coordx)*(p2.coordx - p1.coordx) + (p2.coordy - p1.coordy)*(p2.coordy - p1.coordy));
}
void quicksort(Punct2D *a, int inf, int sup)
{
	int i, j;
	Punct2D x, aux;
	i = inf;
	j = sup;
	x = a[(i + j) / 2];
	do
	{
		while ((i < sup) && (a[i].coordx < x.coordx || a[i].coordx == x.coordx && a[i].coordy < x.coordy))
			i++;
		while ((j > inf) && (a[j].coordx > x.coordx || a[j].coordx == x.coordx && a[j].coordy > x.coordy))
			j--;
		if (i <= j)
		{
			aux = a[i];
			a[i] = a[j];
			a[j] = aux;
			i++;
			j--;
		}
	} while (i <= j);
	if (inf < j) quicksort(a, inf, j);
	if (i < sup) quicksort(a, i, sup);
}
void main()
{
	Punct2D *v;
	int c[5] = { 0,0,0,0,0 };
	int n, i, cadrpop, pozcadr;
	cin >> n;
	v = new Punct2D[n];
	for (i = 0; i < n; i++)
	{
		cin >> v[i];
		c[v[i].cadran()]++;
	}
	cadrpop = c[1];
	pozcadr = 1;
	for (i = 2; i < 5; i++)
	{
		if (c[i]>cadrpop)
		{
			cadrpop = c[i];
			pozcadr = i;
		}
	}
	cout << "Cadranul cel mai populat este cadranul " << pozcadr << "." << endl;
	quicksort(v, 0, n - 1);
	for (i = 0; i < n; i++)
		cout << v[i];
	cout << "Distanta dintre punctul cu cea mai mica coordonata x si punctul cu cea mai mare coordonata x este egala cu " << distanta2(v[0], v[n - 1]) << "." << endl;
	delete[] v;
}