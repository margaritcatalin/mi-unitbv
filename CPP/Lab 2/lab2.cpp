#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<conio.h>
#include<string.h>
#include<algorithm>
using namespace std;
struct caiet {
	char tip[70];
	char prop[70];
	int nrf;
	double pret;
	bool operator<(const caiet& c) const
	{
		if (strcmp(prop, c.prop) < 0)
			return true;
		else
			return false;
	}

};

istream& operator >> (istream& flux, caiet &c)
{
	cout <<endl<< "Ce tip are caietul? ";
	flux >> c.tip;
	cout << endl << "Care este proprietarul caietului? ";
	flux >> c.prop;
	cout << endl << "Ce numar de file are caietul? ";
	flux >> c.nrf;
	cout << endl << "Ce pret are caietul? ";
	flux >> c.pret;
	return flux;
}
ostream& operator <<(ostream& flux, caiet c)
{
	flux <<endl<< "Caietul de tip " << c.tip << " este detinut de " << c.prop << ".Caietul are " << c.nrf << " file si costa " << c.pret<<" lei.";
	return flux;
}
int max(caiet c[], int n)
{
	int max,i, imax = 0;
	max = c[0].nrf;
	for (i = 1; i < n;i++)
		if (max < c[i].nrf)
		{
			max = c[i].nrf;
			imax = i;
		}
	return imax;
}
int nrv(caiet c)
{
	int nrv = 0;
	char p[70], *d;
	strcpy(p, c.prop);
	d = strtok(c.prop, "aeiou");
	while (d != NULL) {
		nrv++;
		d = strtok(NULL, "aeiou");
		}
	return nrv;
}
void main()
{
	caiet *c;
	int n;
	cout << "n=";
	cin >> n;
	c = new caiet[n];
	for (int i = 0; i < n; i++)
		cin >> c[i];
	for (int i = 0; i < n; i++)
		cout<< c[i];
	cout << endl << "Caietele sortate dupa nume:";
	sort(c+0, c+n);
	for (int i = 0; i < n; i++)
		cout << c[i];
	cout << endl << "Caietul cu numar maxim de file este :" << c[max(c, n)];
	for(int i=0;i<n;i++)
	cout <<endl<< "Proprietarul "<<c[i].prop<<" are "<<nrv(c[i])<<" vocale in nume.";
	delete[] c;
	_getch();
}