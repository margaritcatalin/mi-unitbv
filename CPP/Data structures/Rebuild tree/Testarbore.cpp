#include"Arbore.h"
Nod* Refacere(int *RSD, int *SRD, int i, int j)
{
	static int m = 0;
	if (i > j)
		return NULL;
	Nod *k;
	k = new Nod;
	k->setData(RSD[m]);
	m++;
	cout << k->getData() << " ";
	if (i == j)
		return k;
	for (int l = i; l <= j; l++)
		if (SRD[l] == k->getData())
		{
			k->setStanga(Refacere(RSD, SRD, i, l - 1));
			k->setDreapta(Refacere(RSD, SRD, l + 1, j));
			l = j;
		}
	return k;
}

int main() {
	int n;
	cout<<endl << "Introdu numarul de noduri:";
	cin >> n;
	int *RSD = new int[n];
	int *SRD = new int[n];
	cout << endl << "Introdu RSD:";
	for (int i = 0; i < n; i++)
	{
		cout << endl << "Element:";
		cin >> RSD[i];

	}
	cout << endl << "Introdu SRD:";
	for (int i = 0; i < n; i++)
	{
		cout << endl << "Element:";
		cin >> SRD[i];

	}
	Arbore k;
	Nod *a;
	a = new Nod;
	a->setData(RSD[0]);
	k.setRad(a);
	k.setRad(Refacere(RSD, SRD, 0, n - 1));
	system("pause");
	return 0;
}