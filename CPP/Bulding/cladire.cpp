#include "cladire.h"
istream& operator >> (istream& flux, cladire &c)
{
	cout << endl << "Ce pret are cladirea?:";
	flux >> c.pret;
	cout << endl << "Cate apartamente are?: ";
	flux >> c.nrap;
	cout << endl << "Cate etaje are cladirea?:";
	flux >> c.nretaje;
	cout << endl << "Care este locatia cladirii?: ";
	flux >> c.locatie;
	return flux;
}
ostream& operator <<(ostream& flux, cladire c)
{
	flux << endl << "Pretul cladirii:" << c.pret << " Numarul apartamentelor: " << c.nrap << " Numarul etajelor: " << c.nretaje<<" Locatia cladirii:"<<c.locatie;
	return flux;
}
int pmax(cladire *c, int n)
{
	int imax=0;
	float max = c[0].pret;
	for (int i = 1; i<n; i++)
		if (c[i].pret > max)
		{
			max = c[i].pret;
			imax = i;
		}
	return imax;
}
int cladirescumpa(cladire *c, int n)
{
	int imax=0;
	float max = c[0].pret/c[0].nrap;
	for (int i = 1; i<n; i++)
		if (c[i].pret / c[i].nrap > max)
		{
			max = c[i].pret / c[i].nrap;
			imax = i;
		}
	return imax;
}
/*char locatie(cladire *c,int n)
{
	int nrap = 0, nrmaxap = 0;
	for (int i = 0; i < n - 1; i++)
		if (strcmp(c[i].locatie, c[i+1].locatie) = 0)
			nrap++;
	if (nrap >= nrmaxap)
		nrmaxap = nrap;
	
}*/