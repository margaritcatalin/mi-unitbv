#include"Punct2d.h"
#include"Punct2dcol.h"
#include<vector>
#include<algorithm>
bool comparare(Punct2dcol *p1, Punct2dcol *p2)
{
	if (p1->getCoordx() < p2->getCoordx())
		return true;
	return false;
}
int cadranpopulat(std::vector<Punct2d*> pncol, std::vector<Punct2dcol*> pcol)
{
	int c1, c2, c3, c4, o;
	c1 = c2 = c3 = c4 = o = 0;
	for (size_t i = 0; i < pncol.size(); ++i)
	{
		if (pncol[i]->getCadran() > 0)
			c1++;
		if (pncol[i]->getCadran() > 0)
			c2++;
		if (pncol[i]->getCadran() < 0)
			c3++;
		if (pncol[i]->getCadran() < 0)
			c4++;
		if (pncol[i]->getCadran() == 0)
			o++;
	}
	for (size_t i = 0; i < pcol.size(); ++i)
	{
		if (pcol[i]->getCadran() > 0)
			c1++;
		else if (pcol[i]->getCadran() > 0)
			c2++;
		else if (pcol[i]->getCadran() < 0)
			c3++;
		else if (pcol[i]->getCadran() < 0)
			c4++;
		else
			o++;
	}
	/*if (o > c1 && o > c2 && o > c3 && o > c4)
		return 0;*/
	if (c1 > 0 && c1 > c2 && c1 > c3 && c1 > c4)
		return 1;
	if (c2 > 0 && c2 > c1 && c2 > c3 && c2 > c4)
		return 2;
	if (c3 > 0 && c3 > c2 && c3 > c1 && c3 > c4)
		return 3;
	if (c4 > 0 && c4 > c2 && c4 > c3 && c4 > c1)
		return 4;
	return 0;
}
int main()
{
	int n, opt;
	Points *puncte = NULL;
	std::vector<Punct2d*> pncol;
	std::vector<Punct2dcol*> pcol;
	std::cout << "Cate puncte aveti?\nRaspuns:";
	std::cin >> n;
	for (int i = 0; i < n; i++)
	{
		std::cout << "Optiuni:\n";
		std::cout << "1.Puncte2 simple\n";
		std::cout << "2.Puncte2 colorate\n";
		std::cout << "Ce tip de punct introduceti?\nRaspuns:";
		std::cin >> opt;
		switch (opt)
		{
		case 1:
		{
			int x, y;
			std::cout << "Introduceti coordonata x:";
			std::cin >> x;
			std::cout << "Introduceti coordonata y:";
			std::cin >> y;
			puncte = new Punct2d(x, y);
			break;
		}
		case 2: {
			int x, y;
			char *c;
			c = new char[20];
			std::cout << "Introduceti coordonata x:";
			std::cin >> x;
			std::cout << "Introduceti coordonata y:";
			std::cin >> y;
			std::cout << "Introduceti culoarea:";
			std::cin >> c;
			puncte = new Punct2dcol(x, y, c);
			delete[]c;
			break; 
		}
		default:
			std::cout << "EROARE!";
			break;
		}
		Punct2d *ncol = dynamic_cast<Punct2d*>(puncte);
		Punct2dcol *col = dynamic_cast<Punct2dcol*>(puncte);
		if (ncol == NULL && col != NULL)
			pcol.push_back(col);
		else
			pncol.push_back(ncol);
	}
	sort(pcol.begin(), pcol.end(), comparare);
	std::cout << std::endl << "Punctele 2D colorate:";
	for (size_t i = 0; i < pcol.size(); i++)
	{
		Points *puncte = dynamic_cast<Points*>(pcol[i]);
		puncte->afisare();
	}
	std::cout << std::endl << "Punctele 2D necolorate:";
	for (size_t i = 0; i < pncol.size(); i++)
	{
		Points *puncte = dynamic_cast<Points*>(pncol[i]);
		puncte->afisare();
	}
	std::cout << "\nCadranul cel mai populat este cadranul "<<cadranpopulat(pncol, pcol)<<".\n";
		return 0;
}