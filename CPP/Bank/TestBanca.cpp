#include"Banca.h"
void getTara(Banca x,char *&tara)
{
	char* pch;
	char* test;
	test = new char[50];
	strcpy(test, x.getNume());
	pch = strtok(test, " ");
	while (pch != NULL)
	{
		strcpy(tara, pch);
		pch = strtok(NULL, " ");
	}
	delete[] test;
}
void cardf(Banca *b, int n)
{
	char* card;
	card = new char[25];
	int max = 1, nr;
	for (int i = 0; i < n; i++)
	{
		strcpy(card, b[0].getTipcard());
		nr = 1;
		for (int j = i + 1; j < n; j++)
		{
			if (strcmp(b[i].getTipcard(), b[j].getTipcard()) == 0)
				nr++;
		}
		if (max < nr)
		{
			max = nr;
			strcpy(card, b[i].getTipcard());
		}
	}
	std::cout << std::endl << "Tipul de card cel mai folosit este " << card << '.';
	delete[] card;
}
void tarad(Banca *b, int n)
{
	char* tara;
	char* tarad;
	tara = new char[4];
	tarad = new char[4];
	int max = 1, nr;
	for (int i = 0; i < n; i++)
	{
		getTara(b[0], tara);
		nr = 1;
		for (int j = i + 1; j < n; j++)
		{
			getTara(b[i], tara);
			getTara(b[j], tarad);
			if (strcmp(tara, tarad) == 0)
				nr++;
		}
		if (max < nr)
		{
			max = nr;
			getTara(b[i], tara);
		}
	}
	std::cout << std::endl << "Tara cea mai frecvent intalnita este: " << tara << '.';
	delete[] tara;
	delete[] tarad;
}

int main()
{
	int n;
	Banca *b;
	std::cout << "Cate banci introduceti? ";
	std::cin >> n;
	b = new Banca[n];
	for (int i = 0; i < n; i++)
		std::cin >> b[i];
	for (int i = 0; i < n; i++)
		std::cout << b[i];
	cardf(b, n);
	tarad(b, n);
	return 0;
}