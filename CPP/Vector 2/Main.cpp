#include"Vector.h"
void afisare(int n,Vector *sir);
void sumavectorilor(int n, Vector *sir,int k);
int main()
{
	int n,k;
	std::cout << "n=";
	std::cin >> n;
	Vector *sir=new Vector[n];
	for (int i = 0; i < n; i++)
		std::cin >> sir[i];
	afisare(n,sir);
	do {
		std::cout << std::endl << "Ce dimensiune au vectorii pe care ii adunati?\nRaspuns:";
		std::cin >> k;
	} while (k == 0);
	sumavectorilor(n,sir,k);
	delete [] sir;
	return 0;
}
void afisare(int n,Vector *sir)
{
	std::cout << std::endl;
	for (int i = 0; i < n; i++)
	{
		std::cout << std::endl;
		std::cout << sir[i];
	}
	std::cout << std::endl;
	for (int i = 0; i < n; i++)
	{
		std::cout << std::endl;
		std::cout << !sir[i];
	}
}
void sumavectorilor(int n, Vector *sir,int k)
{
	int x1, x2;
	x2 = x1 = -1;
	double *Suma;
	for (int i = 0; i < n; i++)
		if (sir[i].getDim() == k)
		{
			x1 = i;
			break;
		}
	for (int i = n - 1; i >= 0; i--)
		if (sir[i].getDim() == k && sir[i].getDim()!=x1)
		{
			x2 = i;
			break;
		}
	if (x1 != -1 && x2 != -1)
	{
		Suma = new double[k];
		for (int i = 0; i < k; i++)
			Suma[i] =sir[x1].getElement(i)+sir[x2].getElement(i);
		for (int i = 0; i < k; i++)
		{
			std::cout << Suma[i] << ' ';
		}
		delete[]Suma;
	}
	else
	{
		std::cout << std::endl << "Nu s-au gasit 2 vectori de dimensiune k.";
	}
}