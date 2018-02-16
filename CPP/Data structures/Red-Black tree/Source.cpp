#include"RN.h"
#include <fstream>
void meniu(int n, ARN arb);
int main()
{
	ifstream f("data.txt");
	ARN arb;
	int n, nr;
	f >> n;
	for (int i = 0; i < n; i++)
	{
		f >> nr;
		Nod *z;
		z = new Nod;
		z->info = nr;
		arb.insert(z);
	}
	meniu(n, arb);
	return 0;
}

void meniu(int n, ARN arb)
{
	while (1)
	{
		int opt;
		cout <<endl<< "Optiuni disponibile:";
		cout << endl << "1) Afisare in inordine";
		cout << endl << "2) Afisare in preordine";
		cout << endl << "3) Afisare in postordine";
		cout << endl << "4) Cautarea unei valori in arbore";
		cout << endl << "5) Afisarea minimului";
		cout << endl << "6) Afisarea maximului";
		cout << endl << "7) Stergerea unui nod";
		cout << endl << "Optiune:";
		cin >> opt;
		switch (opt)
		{
			case 1: {
				cout << "Parcurgerea in inordine: ";
				arb.SRD(arb.getRad());
				break;
			}
			case 2: {
				cout << endl << "Parcurgerea in preordine: ";
				arb.RSD(arb.getRad());
				break;
			}
			case 3: {
				cout << endl << "Parcurgerea in postordine: ";
				arb.SDR(arb.getRad());
				break;
			}
			case 4: {
				int val;
				cout << endl << "Introduceti informatia pe care o catati:";
				cin >> val;
				if (arb.cautare(val)) cout << "S-a gasit in arbore!" << endl;
				else cout << "Nu s-a gasit in arbore!" << endl;
				break;
			}
			case 5: {
				cout << endl << "Minimul este:" << arb.min(arb.getRad())->info << endl;
			}
			case 6: {
				cout << endl << "Maximul este:" << arb.max(arb.getRad())->info << endl;
			}
			case 7: {
				int val;
				cout << endl << "Introduceti nodul pe care il stergeti:";
				cin >> val;
				arb.sterge(arb.cautare(val));
				break;
			}
			default:
			{
				cout << "Aceasta optiune nu exista!";
				break;
			}
		}
	}
}