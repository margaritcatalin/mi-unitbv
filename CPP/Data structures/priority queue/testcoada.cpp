#include"priority.h"
void main()
{
	unsigned n;
	int x;
	priority h(20);
	cout << endl << "Cate elemente introduceti in coada de prioritati?";
	cin >> n;
	for (int i = 0; i <n; i++)
	{
		cout << endl << "Introduceti valoarea pe care doriti sa o bagati in coada!:";
		cin >> x;
		h.insert(x);
	}
	cout << endl << "Heap:";
	h.afisare();
	h.extract_max();
	cout << endl << "Dupa extragerea maximului:";
	h.afisare();
}