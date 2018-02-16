#include "cerc.h"

double Cerc::operator !() {
	return raza*raza*3.14;
}
bool Cerc::operator<(Cerc& c) 
{
	if (!c > !(*this))
		return true;
	else
		return false;
}
int rmax(Cerc c[],int n)
{
	int imax, max = c[0].raza;
	for(int i=1;i<n;i++)
		if (c[i].raza > max)
		{
			max = c[i].raza;
			imax = i;
		}
	return imax;
}
bool numarprim(Cerc c)
{
	int prim = 1, d = 2;
	while (d <= c.cordx / 2 && d <= c.cordy / 2)
	{
		if (c.cordx%d == 0 || c.cordx%d == 0)
			prim = 0;
		d = d + 1;
	}
	if (prim == 1)
		return true;
	else return false;
}
void actualizare(Cerc &c)
{
	c.raza=c.raza+1;
}
istream& operator >> (istream& flux, Cerc &c)
{
	cout << endl << "Care este raza cercului? ";
	flux >> c.raza;
	cout << endl << "Dati coordonata x: ";
	flux >> c.cordx;
	cout << endl << "Dati coordonata y: ";
	flux >> c.cordy;
	return flux;
}
ostream& operator <<(ostream& flux, Cerc c)
{
	flux << endl << "cu raza " << c.raza << " coordonata x:" << c.cordx << " coordonata y:" << c.cordy;
	return flux;
}