#include"Masa.h"
#include"Scaun.h"
#include<vector>
#include<algorithm>
void citire(int &n, Laborator *&ob, std::vector<Masa*> &mas, std::vector<Scaun*> &scaun);
void afisareV(std::vector<Masa*> mas);
void afisarescaun(std::vector<Scaun*> scaun);
bool comparare(Masa *m1, Masa *m2);
bool comparare2(Masa *m1, Masa *m2);
bool comparare3(Scaun *s1, Scaun *s2);
void Sortare(int a, int b, std::vector<Masa*> &mas);
int main()
{
	int n,a,b;
	Laborator *obiecte = NULL;
	std::vector<Masa*> mas;
	std::vector<Scaun*> scaun;
	citire(n, obiecte, mas,scaun);
	afisareV(mas);
	sort(mas.begin(), mas.end(), comparare);
	afisareV(mas);
	afisarescaun(scaun);
	do { std::cin >> a; std::cin >> b; } while (a<0 || b<0 || a>n || b>n);
	Sortare(a, b, mas);
	return 0;
}
void citire(int &n, Laborator *&ob, std::vector<Masa*> &mas, std::vector<Scaun*> &scaun)
{
	std::cout << "Cate obiecte aveti?\nRaspuns:";
	std::cin >> n;
	for (int i = 0; i < n; i++)
	{
		int opt;
		std::cout << "Optiuni:\n";
		std::cout << "1.Masa\n";
		std::cout << "2.Scaun\n";
		std::cout << "Ce obiect adaugati?\nRaspuns:";
		std::cin >> opt;
		switch (opt)
		{
		case 1: {
			int x, y;
			std::cout << "Introduceti numarul de picioare:";
			std::cin >> x;
			std::cout << "Introduceti dimensiunea mesei:";
			std::cin >> y;
			ob = new Masa(x, y);
			Masa *m = dynamic_cast<Masa*>(ob);
			mas.push_back(m);
			break;
		}
		case 2: {
			int x;
			char y[4];
			std::cout << "Introduceti numarul de picioare:";
			std::cin >> x;
			std::cout << "Scaunul are spatar(Da) sau (Nu)?\nRaspuns:";
			std::cin >> y;
			ob = new Scaun(x, y);
			Scaun *sc = dynamic_cast<Scaun*>(ob);
			scaun.push_back(sc);
			break;
		}
		default: {
			std::cout << "Nu avem acest obiect:";
			i--;//ne intoarcem pe aceasi pozitie
			break;
		}

		}
	}
}
void afisareV(std::vector<Masa*> mas) {
	std::cout << "\nMese existente:";
	for (size_t i = 0; i < mas.size(); i++)
	{
		Laborator *ob = dynamic_cast<Laborator*>(mas[i]);
		ob->afisare();
	}
}
void afisarescaun(std::vector<Scaun*> scaun) {
	std::cout << "\nScaune existente:";
	for (size_t i = 0; i < scaun.size(); i++)
	{
		Laborator *ob = dynamic_cast<Laborator*>(scaun[i]);
		ob->afisare();
	}
}
bool comparare(Masa *m1, Masa *m2)
{
	if (m1->getDimensiune() < m2->getDimensiune())
		return true;
	return false;
}
bool comparare2(Masa *m1, Masa *m2)
{
	if (m1->getNrPicioare() < m2->getNrPicioare())
		return true;
	return false;
}
bool comparare3(Scaun *s1, Scaun *s2)
{
	if (s1->getNrPicioare() < s2->getNrPicioare())
		return true;
	return false;
}
void Sortare(int a, int b, std::vector<Masa*> &mas) {
	std::sort(mas.begin() + a, mas.begin() + b, comparare2);
	afisareV(mas);
}