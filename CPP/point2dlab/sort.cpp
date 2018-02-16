#include<iostream>
#include<string.h>
#include<algorithm>
	using namespace std;

struct punct2D
{
	int coordx, coordy;

	bool operator<(const punct2D& var)
	{
		return coordx < var.coordx;
	}
	int cadran()
	{
		if (coordx > 0 && coordy > 0)
			return 1;
		if (coordx < 0 && coordy>0)
			return 2;
		if (coordx < 0 && coordy < 0)
			return 3;
		if (coordx > 0 && coordy < 0)
			return 4;
		return 0;
	}
	punct2D& operator = (punct2D p)
	{
		this->coordx = p.coordx;
		this->coordy = p.coordy;
		return (*this);
	}
	float distanta1(punct2D p)
	{
		return sqrt((p.coordx - coordx)*(p.coordx - coordx) + (p.coordy - coordy)*(p.coordy - coordy));
	}

};
void citire(punct2D &p)
{
	cin >> p.coordx >> p.coordy;
}

istream& operator >> (istream& flux, punct2D &p)
{
	flux >> p.coordx >> p.coordy;
	return flux;
}
ostream& operator << (ostream& flux, punct2D p)
{
	flux << "(" << p.coordx << "," << p.coordy << ")" << endl;
	return flux;
}
punct2D operator + (punct2D p1, punct2D p2)
{
	punct2D rez;
	rez.coordx = p1.coordx + p2.coordx;
	rez.coordy = p1.coordy + p2.coordy;
	return rez;
}
float distanta2(punct2D p1, punct2D p2)
{
	return sqrt((p1.coordx - p2.coordx)*(p1.coordx - p2.coordx) + (p1.coordy - p2.coordy)*(p1.coordy - p2.coordy));
}
void main()
{
	/*	punct2D a, b, c, d;
	cin >> a.coordx >> a.coordy;
	citire(b);
	cin >> c;
	cout << a << b;
	cout << a.cadran()<<endl;
	d = a + b;
	cout << d<<endl;
	cout << a.distanta1(b)<<endl;
	cout << distanta2(a, b)<<endl;
	*/
	int c[5] = { 0 }, n, i;
	punct2D *p;
	cout << "nr puncte=";
	cin >> n;
	p = new punct2D[n];
	for (i = 0; i < n; i++)
	{
		citire(p[i]);
		c[p[i].cadran()]++;
	}
	int max = c[0];
	int cd = 0;

	for (i = 1; i <= 4; i++)
		if (c[i]>max)
		{
			max = c[i];
			cd = i;
		}
	cout << "cadran=" << cd;
	for (i = 0; i < n; i++)
		cout << p[i];
	sort(p, p + n);
	for (i = 0; i < n; i++)
		cout << p[i];
	punct2D pmin, pmax;
	pmin.coordx = p[0].coordx;
	pmin.coordy = p[0].coordy;
	pmax.coordx = p[0].coordx;
	pmax.coordy = p[0].coordy;
	for (i = 1; i < n; i++)
	{
		if (pmin.coordx > p[i].coordx)
		{
			pmin.coordx = p[i].coordx;
			pmin.coordy = p[i].coordy;
		}
		if (pmax.coordx < p[i].coordx)
		{
			pmax.coordx = p[i].coordx;
			pmax.coordy = p[i].coordy;
		}

	}
	cout << "dist=" << distanta2(pmin, pmax);
	delete[]p;
	system("pause");

}