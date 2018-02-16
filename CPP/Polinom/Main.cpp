#include"Polinom.h"
#include <cmath>
#include <algorithm>
void citire(Polinom *&v, int &n);
void afisare(Polinom *v, int n);
void calcul(Polinom *v, int n, double *&rez, int x);
bool vprim(double x);
int verificare(Polinom *v, int n);
void afisaresuma(Polinom *v, int n);
void afisaresumak(Polinom *v, int n);
int main()
{
	int n,x;
	Polinom *vec;
	double *rez;
	citire(vec, n);
	afisare(vec, n);
	std::cout << "Dati valoarea lui x:";
	std::cin >> x;
	calcul(vec, n, rez, x);
	for (int i = 0; i < n; i++)
	{
		std::cout <<vec[i]<<'='<<rez[i]<<std::endl;
	}
	std::sort(vec, vec + n);
	std::cout << "\nPolinoamele sortate:\n";
	afisare(vec, n);
	std::cout << "\nExista " << verificare(vec, n) << " polinoame ce au toti coeficientii numere prime.\n";
	afisaresuma(vec, n);
	afisaresumak(vec, n);
	delete [] rez;
	delete [] vec;
	return 0;
}
void afisaresuma(Polinom *v, int n)
{
	int k;
	Polinom rezultat;
	std::cout << "\nIntroduceti valoarea lui k:"; std::cin >> k;
	int nr = 0;
	for (int i = 0; i < n; i++)
		if (v[i].getGrad() == k)
		{
			nr++;
			if (nr == 1)
				rezultat = v[i];
			else
				rezultat = rezultat + v[i];
		}
		std::cout << rezultat;
}
void afisaresumak(Polinom *v, int n)
{
	int k;
	Polinom rezultat;
	std::cout << "\nIntroduceti valoarea lui k:"; std::cin >> k;
	std::cout << "\nSuma primelor " << k << " polinoame este \n";
	if (k > 0)
	{
		rezultat = v[0];
		for (int i = 1; i < k; i++)
			rezultat = rezultat + v[i];
		std::cout << rezultat;
	}

}
void citire(Polinom *&v, int &n)
{
	std::cout << "\nCate polinoame aveti?\nRaspuns:";
	std::cin >> n;
	v = new Polinom[n];
	for (int i = 0; i < n; i++)
	{
		std::cout << "\nIntroduceti datele polinomului "<<i<<':';
		std::cin >> v[i];
	}
}
void afisare(Polinom *v, int n)
{
	for (int i = 0; i < n; i++)
	{
		std::cout << v[i]<<std::endl;
	}
}
void calcul(Polinom *v, int n,double *&rez,int x)
{
	rez = new double[n];
	for (int i = 0; i < n; i++)
		rez[i] = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j <= v[i].getGrad(); j++)
			rez[i] = rez[i]+pow(x,v[i].getGrad()-j)*v[i].getDataE(j);
	}
}
bool vprim(double x)
{
	int ok;
	ok = 1;
	for (int i = 2; i <= sqrt(x); i++)
	{
		if ((int)x%i == 0)
		{
			ok = 0;
			break;
		}
	}
	if (ok) return true;
	else return false;
}
int verificare(Polinom *v, int n)
{
	int ok,nr = 0;
	for (int i = 0; i < n; i++)
	{
		ok = 1;
		for (int j = 0; j <= v[i].getGrad(); j++)
			if (vprim(v[i].getDataE(j)) == false)
			{
				ok = 0;
				break;
			}
		if (ok == 1)
			nr++;
	}
	return nr;
}

