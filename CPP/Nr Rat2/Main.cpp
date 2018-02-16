#include"NrRat.h"
#include<vector>
#include<algorithm>
void citire(std::vector<NrRat> &rat, int &n);
void sortare(std::vector<NrRat> &sir);
void afisare(std::vector<NrRat> v);
void minim2(std::vector<NrRat> sir, NrRat &min1, NrRat &min2);
void nrAparitii(NrRat *sir, int n);
void operatii(std::vector<NrRat> v,int n);
int main()
{
	std::vector<NrRat>rat;
	int n;
	citire(rat, n);
	afisare(rat);
	operatii(rat, n);
	return 0;
}
void citire(std::vector<NrRat> &rat, int &n)
{
	std::cout << std::endl << "n=";
	std::cin >> n;
	for (int i = 0; i<n; ++i)
	{
		std::cout << std::endl << "Introduceti numarul rational:"<<std::endl;
		NrRat nr;
		std::cin >> nr;
		rat.push_back(nr);
	}
}
void sortare(std::vector<NrRat> &sir)
{
	sort(sir.begin(), sir.end());
}
void afisare(std::vector<NrRat> v)
{
	for (std::vector<NrRat>::iterator it = v.begin(); it != v.end(); ++it)
	{
		std::cout << std::endl << *it;
		if (it == v.end() - 1)
			break;
	}
}
void minim2(std::vector<NrRat> sir, NrRat &min1, NrRat &min2)
{
	sort(sir.begin(), sir.end());
	min1 = sir[0];
	min2 = sir[1];
}
void operatii(std::vector<NrRat> v, int n)
{
	while (1)
	{
		int opt;
		std::cout << " Introduceti cifra corespunzatoare operatiei dorite!" << std::endl;
		std::cout << "Meniu operatii:" << std::endl;
		std::cout << " 1.Adunare" << std::endl;
		std::cout << " 2.Scadere" << std::endl;
		std::cout << " 3.Inmultire" << std::endl;
		std::cout << " 4.Impartire" << std::endl;
		std::cout << " 5.Afisarea celor 2 minime" << std::endl;
		std::cout << " 6.Afisarea sirului sortat crescator" << std::endl;
		std::cout << " 0.Pentru a iesi din program" << std::endl;
		std::cout << "Optiune:";
		std::cin >> opt;
		switch (opt)
		{
		case 1:
		{
			std::cout << "Fractii disponibile:";
			int i = 1;
			for (std::vector<NrRat>::iterator it = v.begin(); it != v.end(); ++it)
			{
				std::cout << std::endl << i << '.' << *it;
				i++;
				if (it == v.end() - 1)
					break;
			}
			int x1, x2;
			std::cout << "Introduceti indicele fractiilor pe care doriti sa le adunati:";
			do {
				std::cin >> x1;
			} while (x1 < 1 || x1 > n);
			do {
				std::cin >> x2;
			} while (x2 < 1 || x2>n);
			std::cout << std::endl << "Rezultatul adunarii este:" << v[x1 - 1] + v[x2 - 1];
			break;
		}
		case 2:
		{
			std::cout << "Fractii disponibile:";
			int i = 1;
			for (std::vector<NrRat>::iterator it = v.begin(); it != v.end(); ++it)
			{
				std::cout << std::endl << i << '.' << *it;
				i++;
				if (it == v.end() - 1)
					break;
			}
			int x1, x2;
			std::cout << "Introduceti indicele fractiilor pe care doriti sa le scadei:";
			do {
				std::cin >> x1;
			} while (x1 < 1 || x1>n);
			do {
				std::cin >> x2;
			} while (x2 < 1 || x2>n);
			std::cout << std::endl << "Rezultatul scaderii este:" << v[x1 - 1] - v[x2 - 1];
			break;
		}
		case 3:
		{
			std::cout << "Fractii disponibile:";
			int i = 1;
			for (std::vector<NrRat>::iterator it = v.begin(); it != v.end(); ++it)
			{
				std::cout << std::endl << i << '.' << *it;
				i++;
				if (it == v.end() - 1)
					break;
			}
			int x1, x2;
			std::cout << "Introduceti indicele fractiilor pe care doriti sa le inmultiti:";
			do {
				std::cin >> x1;
			} while (x1 < 1 || x1>n);
			do {
				std::cin >> x2;
			} while (x2 < 1 || x2>n);
			std::cout << std::endl << "Rezultatul inmultirii este:" << v[x1 - 1] * v[x2 - 1];
			break;
		}
		case 4:
		{
			std::cout << "Fractii disponibile:";
			int i = 1;
			for (std::vector<NrRat>::iterator it = v.begin(); it != v.end(); ++it)
			{
				std::cout << std::endl << i << ')' << *it;
				i++;
				if (it == v.end() - 1)
					break;
			}
			int x1, x2;
			std::cout << "Introduceti indicele fractiilor pe care doriti sa le impartiti:";
			do {
				std::cin >> x1;
			} while (x1 < 1 || x1>n);
			do {
				std::cin >> x2;
			} while (x2 < 1 || x2>n);
			std::cout << std::endl << "Rezultatul impartii este:" << v[x1 - 1] / v[x2 - 1];
			break;
		}
		case 5:
		{
			NrRat min1, min2;
			minim2(v, min1, min2);
			std::cout << std::endl << "Cele 2 minime sut:" << min1 << std::endl << min2;
			break;
		}
		case 6:
		{
			sortare(v);
			std::cout << std::endl << "Sirul sortat:" << std::endl;
			afisare(v);
			break;
		}
		default:
		{
			std::cout << std::endl << "Nu avem aceasta optiune!";
			break;
		}
		}
		if (opt == 0)
		{
			break;
		}
	}

}